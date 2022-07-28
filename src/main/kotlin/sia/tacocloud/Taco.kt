package sia.tacocloud


import java.sql.Date
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class Taco(private var id: Long = 0,
                @field:NotBlank(message = "Field can't be blank")
                @field:Size(min = 5, message = "Name must be at least 5 characters long")
                var name: String = "",
                @field:Size(min=1, message = "You must choose at least 1 ingredient")
                var ingredients: List<Ingredient> = listOf(),

               ){
    private lateinit var createdAt: Date
    fun setId(id: Long) {
        this.id = id
    }
    fun setCreatedAt(createdAt: Date) {
        this.createdAt = createdAt
    }
}