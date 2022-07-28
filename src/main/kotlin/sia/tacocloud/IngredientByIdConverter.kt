package sia.tacocloud

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

// Класс для конвертации запроса из типа String в тип Ingredient
@Component // Аннотация для автоматической регистрации конвертера в SpringMVC
class IngredientByIdConverter(@Autowired private val ingredientRepo: IngredientRepository):
    Converter<String, Ingredient> {
    //Переопределяем функцию класса Converter фреймворка Spring
    override fun convert(id: String): Ingredient? = ingredientRepo.findById(id)
}