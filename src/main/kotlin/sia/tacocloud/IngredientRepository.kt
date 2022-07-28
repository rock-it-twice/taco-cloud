package sia.tacocloud


interface IngredientRepository {
    fun findAll(): Iterable<Ingredient>
    fun findById(id: String): Ingredient?
    fun save(ingredient: Ingredient): Ingredient
}