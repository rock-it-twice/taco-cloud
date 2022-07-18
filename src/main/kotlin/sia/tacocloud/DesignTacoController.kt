package sia.tacocloud

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
import java.util.*
import java.util.stream.Collectors

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
class DesignTacoController {

    @ModelAttribute
    fun addIngredientsToModel(model: Model){
        val ingredients: List<Ingredient> = listOf(
            Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
            Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
            Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
            Ingredient("CARN", "Carnita", Ingredient.Type.PROTEIN),
            Ingredient("TMTO","Diced Tomato", Ingredient.Type.VEGGIES),
            Ingredient("LETC","Lettuce", Ingredient.Type.VEGGIES),
            Ingredient("CHED","Chedder", Ingredient.Type.CHEESE),
            Ingredient("JACK","Monterrey Jack", Ingredient.Type.CHEESE),
            Ingredient("SLSA","Salsa", Ingredient.Type.SAUCE),
            Ingredient("SRCR","Sour Cream", Ingredient.Type.SAUCE)
        )
        val types = Ingredient.Type.values()
        types.forEach {
            model.addAttribute(it.toString().lowercase())
            filterByType(ingredients, it)
        }
    }
    @ModelAttribute(name = "TacoOrder")
    fun tacoOrder() = TacoOrder()
    @ModelAttribute(name = "Taco")
    fun taco() = Taco()
    @GetMapping
    fun showDesignForm() = "design"

    private fun filterByType(ingredients: List<Ingredient>, type: Ingredient.Type): Iterable<Ingredient> {
        return ingredients.stream()
            .filter{ x -> x.getType().equals(type) }
            .collect(Collectors.toList())
    }
}