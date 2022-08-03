package sia.tacocloud

interface OrderRepository {
    fun save(order: TacoOrder): TacoOrder
}