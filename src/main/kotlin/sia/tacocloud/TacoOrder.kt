package sia.tacocloud

data class TacoOrder(private var deliveryName: String = "",
                     private var deliveryStreet: String = "",
                     private var deliveryCity: String = "",
                     private var deliveryState: String = "",
                     private var deliveryZip: String = "",
                     private var ccNumber: String = "",
                     private var ccExpiration: String = "",
                     private var ccCVV: String = "",
                     private var tacos: MutableList<Taco> = mutableListOf()
                    ){
    fun addTaco(taco: Taco) = tacos.add(taco)
}
