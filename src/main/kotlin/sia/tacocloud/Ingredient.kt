package sia.tacocloud
import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document("ingredient")
data class Ingredient(@Id
                 private var id: String,
                 private var name: String,
                 private var type: Type) {
    fun getType() = type
    fun getId() = id
    fun getName() = name

    // enum класс-перечисления
    enum class Type{ WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE }
  }
