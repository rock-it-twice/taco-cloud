package sia.tacocloud


import com.datastax.oss.driver.api.core.uuid.Uuids
import lombok.Data
import org.springframework.data.cassandra.core.cql.Ordering
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table

import java.util.Date
import java.util.UUID
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Data
@Table("tacos")
class Taco(@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
           private val id: UUID = Uuids.timeBased(),
           @field:NotBlank(message = "Field can't be blank")
           @field:Size(min = 5, message = "Name must be at least 5 characters long")
           private var name: String = "",
           @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
           private val createdAt: Date = Date(),
           @field:Size(min=1, message = "You must choose at least 1 ingredient")
           @Column("ingredients") //Тип переменной <IngredientUDT> (UDT - user defined type)
           private val ingredients: MutableList<IngredientUDT> = mutableListOf()) {

    fun setName(name: String) { this.name = name }
    fun addIngredient(ingredient: Ingredient) = ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient))
    fun getIngredients() = ingredients
    fun getName() = name

}