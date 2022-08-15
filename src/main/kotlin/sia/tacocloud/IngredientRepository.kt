package sia.tacocloud

import org.springframework.data.repository.CrudRepository

// CrudRepository уже содержит все необходимые методы, для манипуляции с хранилищем

interface IngredientRepository: CrudRepository<Ingredient, String>