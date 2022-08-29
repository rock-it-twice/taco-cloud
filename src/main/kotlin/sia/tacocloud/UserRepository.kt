package sia.tacocloud

import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<TacoUser, Long> {
    fun findByUsername(username: String): TacoUser?
}