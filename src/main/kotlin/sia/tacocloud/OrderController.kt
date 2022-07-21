package sia.tacocloud

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
class OrderController {

    @GetMapping("/current")
    fun orderForm() = "orderForm"
}