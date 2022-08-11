package sia.tacocloud
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table



@Table("ingredients")
data class Ingredient(@PrimaryKey
                      private val id: String,
                      private val name: String,
                      private val type: Type) {


    // enum класс-перечисления
    enum class Type{ WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE }

    //    fun setId(id: String) { this.id = id }
    //    fun setName(name: String) { this.name = name }
    //    fun setType(type: Type) {this.type = type}

    fun getId() = id
    fun getName() = name
    fun getType() = type

  }
