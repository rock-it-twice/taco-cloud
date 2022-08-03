package sia.tacocloud

data class IngredientRef(private var ingredient: String){
    fun setIngredient(ingredient: String) { this.ingredient = ingredient }
    fun getIngredient() = ingredient
}
