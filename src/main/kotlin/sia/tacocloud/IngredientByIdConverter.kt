package sia.tacocloud

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

// Класс для конвертации запроса из типа String в тип Ingredient
@Component // Аннотация для автоматической регистрации конвертера в SpringMVC
class IngredientByIdConverter : Converter<String, Ingredient> {

    //Создаем Map, которая будет возвращать объект Ingredient по id: String
    private val ingredientMap:HashMap<String, Ingredient> = hashMapOf()

    init{
        ingredientMap["FLTO"] = Ingredient("FLTO","Flour Tortilla", Ingredient.Type.WRAP)
        ingredientMap["COTO"] = Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP)
        ingredientMap["GRBF"] = Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN)
        ingredientMap["CARN"] = Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN)
        ingredientMap["TMTO"] = Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES)
        ingredientMap["LETC"] = Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES)
        ingredientMap["CHED"] = Ingredient("CHED", "Chedder", Ingredient.Type.CHEESE)
        ingredientMap["JACK"] = Ingredient("JACK", "Lamber Jack", Ingredient.Type.CHEESE)
        ingredientMap["SLSA"] = Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE)
        ingredientMap["SRCR"] = Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
    }

    //Переопределяем функцию класса Converter фреймворка Spring
    override fun convert(id: String): Ingredient {
        return ingredientMap[id]!!
    }


}