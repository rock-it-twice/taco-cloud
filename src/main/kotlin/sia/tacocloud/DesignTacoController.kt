package sia.tacocloud

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
import java.util.stream.Collectors
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.Errors
import javax.validation.Valid


private val logger = KotlinLogging.logger {}

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
class DesignTacoController(@Autowired private var ingredientRepository: IngredientRepository) {


    @ModelAttribute
    fun addIngredientsToModel(model: Model){
        val ingredients: Iterable<Ingredient> = ingredientRepository.findAll()
        val types = Ingredient.Type.values()
        types.forEach {
            model.addAttribute(it.toString().lowercase(),
            filterByType(ingredients.toList(), it))
        }
    }

    private fun filterByType(ingredients: List<Ingredient>, type: Ingredient.Type): Iterable<Ingredient> {
        return ingredients.stream()
            .filter{ x -> x.getType() == type }
            .collect(Collectors.toList())
    }
    @ModelAttribute(name = "tacoOrder")
    fun tacoOrder() = TacoOrder()
    @ModelAttribute(name = "taco")
    fun taco() = Taco()
    @GetMapping
    fun showDesignForm() = "design"

    @PostMapping
    fun processTaco(@Valid taco: Taco,
                    errors: Errors,
                    @ModelAttribute tacoOrder: TacoOrder
                    ): String{
        if (errors.hasErrors()) {
            println("--------------------------------------------------------")
            println(errors.allErrors)
            println("--------------------------------------------------------")
            return "design"}
        tacoOrder.addTaco(taco)
        logger.info { "Processing taco: $taco" }
        return "redirect:/orders/current"
    }



}