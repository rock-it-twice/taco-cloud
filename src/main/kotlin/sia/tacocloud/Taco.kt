package sia.tacocloud


import org.springframework.data.rest.core.annotation.RestResource
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


@Entity
@RestResource(rel = "tacos", path = "tacos")
data class Taco(@field:NotBlank(message = "Field can't be blank")
                @field:Size(min = 5, message = "Name must be at least 5 characters long")
                private var name: String = "",
                @field:Size(min=1, message = "You must choose at least 1 ingredient")
                @ManyToMany
                private var ingredients: MutableList<Ingredient> = mutableListOf(),
                @Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                private var id: Long = 0,
                private var createdAt: Date = Date()) {
    fun setName(name: String) { this.name = name }
    fun setIngredients(ingredients: MutableList<Ingredient>) { this.ingredients = ingredients }

    fun getName() = name
    fun getIngredients() = ingredients
    fun addIngredient(ingredient: Ingredient) = ingredients.add(ingredient)

}