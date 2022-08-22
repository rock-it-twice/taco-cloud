package sia.tacocloud

import lombok.Data
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Data
class User(private val username: String,
           private val password: String,
           private val fullname: String,
           private val street: String,
           private val city: String,
           private val state: String,
           private val zip: String,
           private val phoneNumber: String,
           @Id
           @GeneratedValue(strategy = GenerationType.AUTO)
           private var id: Long = 0) : UserDetails {

    fun getId(): Long = id
    override fun getUsername() = username
    override fun getPassword() = password
    fun getFullname() = fullname
    fun getCity() = city
    fun getStreet() = street
    fun getState() = state
    fun getZip() = zip
    fun getPhoneNumber() = phoneNumber

    // Пока не предусмотрено отключение пользователей, все функции is... возвращают true
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
    }

}