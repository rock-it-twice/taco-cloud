package sia.tacocloud

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*


// Класс для конвертации запроса из типа String в тип Ingredient
@Component // Аннотация для автоматической регистрации конвертера в SpringMVC
class IngredientByIdConverter(@Autowired val ingredientRepo: IngredientRepository):
    Converter<String, Ingredient> {
    //Переопределяем функцию класса Converter фреймворка Spring
    override fun convert(id: String): Ingredient? = ingredientRepo.findByIdOrNull(id)
}