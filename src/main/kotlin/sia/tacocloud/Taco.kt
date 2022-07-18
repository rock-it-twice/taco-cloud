package sia.tacocloud

data class Taco(var name: String = "",
                var ingredients: MutableList<Ingredient> = mutableListOf()
               )