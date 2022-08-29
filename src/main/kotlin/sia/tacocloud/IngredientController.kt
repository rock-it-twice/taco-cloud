package sia.tacocloud

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(path = ["/api/ingredients"], produces = ["application/json"])
@CrossOrigin("http://localhost:8080")
class IngredientController(@Autowired private val repo: IngredientRepository) {

    @GetMapping
    fun getIngredients(): List<Ingredient> = repo.findAll().toList()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveIngredient(@RequestBody ingredient: Ingredient): Ingredient = repo.save(ingredient)

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteIngredient(@PathVariable("id") IngredientId: String){
        repo.deleteById(IngredientId)
    }

}