package sia.tacocloud

data class TacoOrder(val deliveryName: String = "",
                     val deliveryStreet: String = "",
                     val deliveryCity: String = "",
                     val deliveryState: String = "",
                     val deliveryZip: String = "",
                     val ccNumber: String = "",
                     val ccExpiration: String = "",
                     val ccCVV: String = "",
                     val tacos: MutableList<Taco> = mutableListOf()
                    ){
    fun addTaco(taco: Taco) = tacos.add(taco)
}
