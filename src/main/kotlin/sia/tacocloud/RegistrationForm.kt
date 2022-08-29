package sia.tacocloud


import org.springframework.security.crypto.password.PasswordEncoder
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class RegistrationForm(@field:NotBlank(message = "Field can't be blank")
                            private var username: String = "",
                            @field:NotBlank(message = "Field can't be blank")
                            @field:Size(min = 8)
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


    fun toUser(encoder: PasswordEncoder): TacoUser {
        return TacoUser(username = username,
                        password = encoder.encode(password),
                        fullName = fullname,
                        street = street,
                        city = city,
                        state = state,
                        zip = zip,
                        phoneNumber = phone)
    }


}