package sia.tacocloud

import mu.KotlinLogging
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.support.SessionStatus
import javax.validation.Valid


@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
class OrderController(val orderRepository: OrderRepository) {
    private val logger = KotlinLogging.logger {}

    @GetMapping("/current")
    fun orderForm() = "orderForm"
    @PostMapping
    fun processOrder(@Valid order: TacoOrder,
                     errors: Errors,
                     sessionStatus: SessionStatus,
                     authentication: Authentication): String {
        // Получаем данные пользователя создавшего заказ из БД
        val tacoUser: TacoUser = authentication.principal as TacoUser // приводим результат типа java к классу User
        // Проверка правил заполнения полей формы
        if (errors.hasErrors()) return "orderForm"
        // Связываем заказ с пользователем (в т.ч. чтобы можно было подтянуть его данные в форму)
        order.setUser(tacoUser)
        orderRepository.save(order)
        sessionStatus.setComplete()

        return "redirect:/"
    }

//    @PutMapping(path = ["/{orderId}"], consumes = ["application/json"])
//    @ResponseStatus(HttpStatus.OK)
//    fun putOrder(@PathVariable orderId: Long, @RequestBody order: TacoOrder): TacoOrder{
//        order.setId(orderId)
//        return orderRepository.save(order)
//    }
//
//    @PatchMapping("/{orderId}")
//    fun patchOrder(@PathVariable orderId: Long,
//                   @RequestBody patch: TacoOrder): TacoOrder{
//        val order = orderRepository.findById(orderId).get()
//        if (patch.deliveryName != "") order.deliveryName = patch.deliveryName
//        if (patch.deliveryStreet != "") order.deliveryStreet = patch.deliveryStreet
//        if (patch.deliveryCity != "") order.deliveryCity = patch.deliveryCity
//        if (patch.deliveryState != "") order.deliveryState = patch.deliveryState
//        if (patch.deliveryZip != "") order.deliveryZip = patch.deliveryZip
//        if (patch.getCcNumber() != "") order.setCcNumber(patch.getCcNumber())
//        if (patch.getCcCVV() != "") order.setCcCVV(patch.getCcCVV())
//        if (patch.getCcExpiration() != "") order.setCcExpiration(patch.getCcExpiration())
//        return orderRepository.save(order)
//
//    }
//
//    @DeleteMapping("/{OrderId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteOrder(@PathVariable orderId: Long ){
//        try { orderRepository.deleteById(orderId)
//        } catch (_: EmptyResultDataAccessException){}
//    }
}