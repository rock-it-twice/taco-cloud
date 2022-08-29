package sia.tacocloud

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid


@Controller
@RequestMapping("/register")
class RegistrationController(@Autowired
                             private val userRepo: UserRepository,
                             private val passwordEncoder: PasswordEncoder) {

    @GetMapping
    fun registerForm() = "registration"

    @PostMapping
    fun processRegistration(form: RegistrationForm): String {
        userRepo.save(form.toUser(passwordEncoder))
        println("__________________________________________")
        println(userRepo.findAll())
        println("__________________________________________")
        return "redirect:/login"
    }

}