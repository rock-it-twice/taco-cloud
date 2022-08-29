package sia.tacocloud

import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.*


interface TacoRepository: JpaRepository<Taco, Long>{
}