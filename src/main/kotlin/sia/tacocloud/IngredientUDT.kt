package sia.tacocloud

import org.springframework.data.cassandra.core.mapping.UserDefinedType

@UserDefinedType("ingredient")
data class IngredientUDT(private val name: String,
                         private val type: Ingredient.Type) {
    fun getName() = name
    fun getType() = type
}
