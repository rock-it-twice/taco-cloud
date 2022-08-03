package sia.tacocloud

import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
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
                     sessionStatus: SessionStatus): String {
        if (errors.hasErrors()) return "orderForm"
        orderRepository.save(order)
        sessionStatus.setComplete()

        return "redirect:/"
    }
}