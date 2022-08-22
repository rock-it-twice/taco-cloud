package sia.tacocloud

import lombok.Data
import org.springframework.security.crypto.password.PasswordEncoder
import javax.validation.constraints.NotBlank

@Data
class RegistrationForm(@field:NotBlank(message = "Field can't be blank")
                       private var name: String = "",
                       @field:NotBlank(message = "Field can't be blank")
                       private var password: String = "",
                       @field:NotBlank(message = "Field can't be blank")
                       private var fullname: String = "",
                       @field:NotBlank(message = "Field can't be blank")
                       private var street: String = "",
                       @field:NotBlank(message = "Field can't be blank")
                       private var city: String = "",
                       @field:NotBlank(message = "Field can't be blank")
                       private var state: String = "",
                       @field:NotBlank(message = "Field can't be blank")
                       private var zip: String = "",
                       @field:NotBlank(message = "Field can't be blank")
                       private var phone: String = "") {


    fun toUser(encoder: PasswordEncoder): User {
        return User(name,
                    encoder.encode(password),
                    fullname,
                    street,
                    city,
                    state,
                    zip,
                    phone)
    }


}