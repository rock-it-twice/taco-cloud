package sia.tacocloud

import org.springframework.data.repository.CrudRepository


// CrudRepository уже содержит все необходимые методы, для манипуляции с хранилищем
interface OrderRepository : CrudRepository<TacoOrder, Long>{
    fun findByDeliveryZip(deliveryZip: String): List<TacoOrder>
}