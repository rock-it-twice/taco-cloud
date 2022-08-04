package sia.tacocloud

import org.springframework.asm.Type
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.PreparedStatementCreatorFactory
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Date
import java.sql.Types


@Repository
class JdbcOrderRepository(@Autowired private val jdbcOprations: JdbcOperations): OrderRepository {

    // Функция для сохранения заказа в БД Taco_Order
    @Transactional
    override fun save(order: TacoOrder): TacoOrder {
        // Текст запроса
        val insertBody: String = "insert INTO Taco_Order " +
                "(delivery_Name, delivery_Street, delivery_City, " +
                "delivery_State, delivery_Zip, cc_Number, cc_Expiration, cc_CVV, placed_at)"
        // Вместо вопросов Spring подставит данные представленные в объекте pscf (Types.VARCHAR и т.д.)
        val insertValues: String = " values (?, ?, ?, ?, ?, ?, ?, ?, ?)"

        // Объект описывающий запрос INSERT вместе с типами параметра
        val pscf = PreparedStatementCreatorFactory(insertBody + insertValues,
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP)

        // Генерация id заказа
        pscf.setReturnGeneratedKeys(true)

        // получение даты заведения заказа
        val newDate = Date()
        // присвоение даты экземпляру TacoOrder
        order.setPlacedAt(newDate)
        // создание запроса INSERT INTO с полученными данными
        val psc = pscf.newPreparedStatementCreator(
            listOf(
                order.deliveryName,
                order.deliveryStreet,
                order.deliveryCity,
                order.deliveryState,
                order.deliveryZip,
                order.ccNumber,
                order.ccExpiration,
                order.ccCVV,
                order.getPlacedAt())
        )

        // Получаем сгенерированный БД id заказа
        val keyHolder = GeneratedKeyHolder()
        // Сохранение заказа вызовом метода .update
        jdbcOprations.update(psc, keyHolder)

        // Присвоение id объекту TacoOrder
        val orderId: Long = keyHolder.key!!.toLong()
        order.setId(orderId)

        val tacos: List<Taco> = order.tacos
        var i = 0
        tacos.forEach { saveTaco(orderId, i++, it) }
        return order
    }

    // Функция для добавления Тако в БД Taco
    private fun saveTaco(orderId: Long, orderKey: Int, taco: Taco): Long {
        // Создаем дату заведения Тако и присваиваем её экземпляру Тако
        taco.setCreatedAt(Date())
        // Текст запроса
        val insertBody: String = "insert INTO Taco (name, created_at, taco_order, taco_order_key)"
        // Вместо вопросов Spring подставит данные представленные в объекте pscf (Types.VARCHAR и т.д.)
        val insertValues: String = " values (?, ?, ?, ?)"

        // Объект описывающий запрос INSERT вместе с типами параметра
        val pscf = PreparedStatementCreatorFactory(insertBody + insertValues,
            Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG)
        // Генерация id Тако
        pscf.setReturnGeneratedKeys(true)

        // Создадим запрос INSERT INTO с полученными данными
        val psc = pscf.newPreparedStatementCreator(
            listOf(
                taco.name,
                taco.getCreatedAt(),
                orderId,
                orderKey))

        // Получаем сгенерированный БД id Тако
        val keyHolder = GeneratedKeyHolder()
        // Сохранение заказа вызовом метода .update (1-арг. Передаем запрос, 2 арг. передаем id)
        jdbcOprations.update(psc, keyHolder)
        // Присваиваем объекту Тако сгенерированный БД id
        val tacoId = keyHolder.key!!.toLong()
        taco.setId(tacoId)

        saveIngredientsRefs(tacoId, taco.ingredients)
        return tacoId
    }

    // Функция для сохранения связующего объекта Ingredient_Ref в БД ingredient_Ref
    private fun saveIngredientsRefs(tacoId: Long, ingredientRefs: List<Ingredient>){
        var key = 0
        val insertBody: String = "insert INTO Ingredient_Ref (ingredient, taco, taco_key)"
        // Вместо вопросов Spring подставит данные представленные в объекте pscf (Types.VARCHAR и т.д.)
        val insertValues: String = " values (?, ?, ?)"

        // Передача всех экземпляров Taco в БД
        ingredientRefs.forEach {jdbcOprations.update(insertBody + insertValues, it.id, tacoId, key++)}
    }



}