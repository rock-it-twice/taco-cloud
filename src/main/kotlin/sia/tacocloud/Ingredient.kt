package sia.tacocloud
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "ingredients")
data class Ingredient(@Id
                      private var id: String = "",
                      private var name: String = "",
                      private var type: Type) {
    fun setId(id: String) { this.id = id }
    fun setName(name: String) { this.name = name }
    fun setType(type: Type) { this.type = type }
    fun getType() = type
    fun getId() = id
    fun getName() = name

    // enum класс-перечисления
    enum class Type{ WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE }
  }
