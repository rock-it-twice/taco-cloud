package sia.tacocloud

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.Date


// CrudRepository уже содержит все необходимые методы, для манипуляции с хранилищем
interface OrderRepository : CrudRepository<TacoOrder, Long>{
}