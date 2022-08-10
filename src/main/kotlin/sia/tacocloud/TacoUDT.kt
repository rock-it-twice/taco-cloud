package sia.tacocloud

import org.springframework.data.cassandra.core.mapping.UserDefinedType


@UserDefinedType("taco")
data class TacoUDT(private val name: String,
                   private val ingredients: List<IngredientUDT>)
