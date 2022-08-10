package sia.tacocloud

object TacoUDRUtils {
    // Преобразует объект типа Ingredient в IngredientUDT
        fun toIngredientUDT(ingredient: Ingredient): IngredientUDT {
            return IngredientUDT(ingredient.getName(), ingredient.getType())
        }
    // Taco в TacoUDT
        fun toTacoUDT(taco: Taco): TacoUDT {
            return TacoUDT(taco.getName(), taco.getIngredients())
        }
    }

