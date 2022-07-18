package sia.tacocloud

data class Ingredient(private val id: String,
                      private val name: String,
                      private val type: Type){
    // enum класс-перечисления
    enum class Type{ WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE }
    fun getType() = type
}
