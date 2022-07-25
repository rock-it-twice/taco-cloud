package sia.tacocloud


import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class Taco(@NotBlank @Size(min = 5, message = "Name must be at least 5 characters long")
                var name: String = "",
                @NotBlank @Size(min = 1, message = "You must choose at least 1 ingredient")
                val ingredients: MutableList<Ingredient> = mutableListOf()
               )