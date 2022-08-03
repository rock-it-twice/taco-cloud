package sia.tacocloud

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet


@Repository
class JdbcIngredientRepository(@Autowired private val jdbcTemplate:JdbcTemplate): IngredientRepository {

    // Лямбда-выражение, которое преобразует результат запроса в ResultSet (RawMapping)
    private val resultSet =
        { rs: ResultSet, _: Int -> Ingredient(rs.getString("id"), rs.getString("name"),
        Ingredient.Type.valueOf(rs.getString("type"))) }
    // Тексты запросов
    private val findAllBody = "SELECT id, name, type FROM Ingredient"
    private val findByIdBody = "SELECT id, name, type FROM Ingredient WHERE id=?"
    private val saveBody = "INSERT INTO Ingredient (id, name, type) VALUES (?, ?, ?)"

    override fun findAll(): Iterable<Ingredient> {
        return jdbcTemplate.query(findAllBody, resultSet)
    }

    override fun findById(id: String): Ingredient? {
        val results: List<Ingredient?> = jdbcTemplate.query(findByIdBody, resultSet, id)
        return if (results.isNotEmpty()) results[0] else null
    }


    override fun save(ingredient: Ingredient): Ingredient {
        jdbcTemplate.update(saveBody, ingredient.id, ingredient.name, ingredient.getType().toString())
        return ingredient
    }
}