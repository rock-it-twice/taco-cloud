package sia.tacocloud


import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size


data class Taco(@field:NotBlank(message = "Field can't be blank")
                @field:Size(min = 5, message = "Name must be at least 5 characters long")
                var name: String = "",
                @field:Size(min = 1, message = "You must add at least 1 ingredient")
                val ingredients: MutableList<Ingredient> = mutableListOf()
               )