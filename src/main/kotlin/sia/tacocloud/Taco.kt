package sia.tacocloud


import lombok.Data

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Data
@Entity
class Taco(@Id
           @GeneratedValue(strategy = GenerationType.AUTO)
           private var id: Long = 0,
           @field:NotBlank(message = "Field can't be blank")
           @field:Size(min = 5, message = "Name must be at least 5 characters long")
           private var name: String = "",
           private var createdAt: Date = Date(),
           @field:Size(min=1, message = "You must choose at least 1 ingredient")
           @ManyToMany
           private val ingredients: MutableList<Ingredient> = mutableListOf()) {
    fun addIngredient(ingredient: Ingredient) = ingredients.add(ingredient)

}