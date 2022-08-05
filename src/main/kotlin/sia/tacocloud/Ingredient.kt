package sia.tacocloud

import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.Id



@Entity
class Ingredient(@Id
                 private var id: String = "",
                 private var name: String = "",
                 private var type: Type) {


    // enum класс-перечисления
    enum class Type{ WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE }
    fun setId(id: String) { this.id = id }
    fun setName(name: String) { this.name = name }
    fun setType(type: Type) { this.type = type }

    fun getId() = id
    fun getName() = name
    fun getType() = type

  }
