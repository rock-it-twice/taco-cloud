package sia.tacocloud

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {
    override fun addViewControllers(registry: ViewControllerRegistry){
        registry.addViewController("/").setViewName("home")
        registry.addViewController("/login")
        registry.addViewController("/privacy")
    }

    @Bean
    @Profile("!prod")
    fun dataLoader(ingRepo: IngredientRepository,
                   userRepo: UserRepository,
                   encoder: PasswordEncoder,
                   tacoRepo: TacoRepository): CommandLineRunner{
        return CommandLineRunner {
            // создаем ингредиенты
        val flourTortilla = Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP)
        val cornTortilla = Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP)
        val groundBeef = Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN)
        val carnitas = Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN)
        val dicedTomatoes = Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES)
        val lettuce = Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES)
        val cheddar = Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE)
        val monterreyJack = Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE)
        val salsa = Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE)
        val sourCream = Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)

            // заливаем ингредиенты в бд
        ingRepo.save(flourTortilla)
        ingRepo.save(cornTortilla)
        ingRepo.save(groundBeef)
        ingRepo.save(carnitas)
        ingRepo.save(dicedTomatoes)
        ingRepo.save(lettuce)
        ingRepo.save(cheddar)
        ingRepo.save(monterreyJack)
        ingRepo.save(salsa)
        ingRepo.save(sourCream)

        // создаем 3 Тако

        val taco1 = Taco("First Taco",
            mutableListOf( flourTortilla, groundBeef, dicedTomatoes, cheddar, salsa )
        )

        val taco2 = Taco("Second Taco",
            mutableListOf( cornTortilla, carnitas, lettuce, monterreyJack, sourCream )
        )

        val taco3 = Taco("Fat Taco",
            mutableListOf( flourTortilla, groundBeef, carnitas, dicedTomatoes, lettuce,
                cheddar, monterreyJack, salsa, sourCream )
        )

        // заливаем тако в БД

        tacoRepo.save(taco1)
        tacoRepo.save(taco2)
        tacoRepo.save(taco3)

        }

    }

}