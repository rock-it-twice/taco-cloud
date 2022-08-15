package sia.tacocloud


import java.util.Date
import java.util.UUID
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size



data class Taco(
                @field:NotBlank(message = "Field can't be blank")
                @field:Size(min = 5, message = "Name must be at least 5 characters long")
                private var name: String = "",
                private val createdAt: Date = Date(),
                @field:Size(min=1, message = "You must choose at least 1 ingredient")
                private var ingredients: MutableList<Ingredient> = mutableListOf()) {

    fun setName(name: String) { this.name = name }

    fun setIngredients(ingredients: MutableList<Ingredient>) { this.ingredients = ingredients }

    fun addIngredient(ingredient: Ingredient) { ingredients.add(ingredient) }

    fun getName() = name

    fun getIngredients() = ingredients

}