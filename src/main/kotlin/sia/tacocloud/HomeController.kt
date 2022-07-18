package sia.tacocloud

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

//Контроллер домашней страницы
@Controller
class HomeController {
    @GetMapping("/")
    fun home() = "home"
}