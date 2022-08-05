package sia.tacocloud

import org.springframework.data.repository.CrudRepository
import java.util.*

// CrudRepository уже содержит все необходимые методы, для манипуляции с хранилищем
interface IngredientRepository: CrudRepository<Ingredient, String>