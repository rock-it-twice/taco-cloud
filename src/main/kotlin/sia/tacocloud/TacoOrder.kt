package sia.tacocloud


import org.hibernate.validator.constraints.CreditCardNumber
import java.util.Date
import javax.validation.constraints.Digits
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import kotlinx.serialization.Serializable
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document
@Serializable
data class TacoOrder(private val serialVersionUID: Long = 1L,
                @Id
                private var id: String? = null, //Если id - null, MongoDB его сгенерирует автоматоматически
                private val placedAt: Date = Date(),
                @field:NotBlank(message="Delivery name is required")
                var deliveryName: String = "",
                @field:NotBlank(message="Delivery street is required")
                var deliveryStreet: String = "",
                @field:NotBlank(message="Delivery city is required")
                var deliveryCity: String = "",
                @field:NotBlank(message="Delivery state is required")
                var deliveryState: String = "",
                @field:NotBlank(message="Delivery zip is required")
                var deliveryZip: String = "",
                @field:CreditCardNumber(message = "Not a valid credit card number")
                var ccNumber: String = "",
                @field:Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9][2-9])\$", message = "Must be formatted MM/YY")
                var ccExpiration: String = "",
                @field:Digits(integer = 3, fraction = 0, message = "Invalid CVV")
                var ccCVV: String = "",
                private val tacos: MutableList<Taco> = mutableListOf()){

    fun setId(id: String) { this.id = id }

    fun addTaco(taco: Taco) = tacos.add(taco)
    fun getTacos() = tacos
}
