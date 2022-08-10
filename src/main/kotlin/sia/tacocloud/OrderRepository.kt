package sia.tacocloud

import org.springframework.data.repository.CrudRepository
import java.util.*


// CrudRepository уже содержит все необходимые методы, для манипуляции с хранилищем
interface OrderRepository : CrudRepository<TacoOrder, UUID>{

    // Поиск по Delivery_zip
    // fun findByDeliveryZip(deliveryZip: String): List<TacoOrder>

    // Поиск заказов по Delivery_zip внесенных в БД в диапазоне startDate-endDate
    // fun readOrdersByDeliveryZipAndPlacedAtBetween(deliveryZip: String, startDate:Date, endDate: Date): List<TacoOrder>

    // Поиск заказов по имени(deliveryTo) и Городу доставки(deliveryCity) без учёта регистра букв
    // fun findByDeliveryToAndDeliveryCityAllIgnoresCase(deliveryTo: String, deliveryCity: String): List<TacoOrder>

    // Для сложных запросов лучше использовать аннотацию Query

    // fun readOrdersDeliveredInSeattle():List<TacoOrder>
}