package sia.tacocloud


import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class TacoUser(private var username: String,
                    private var password: String,
                    private var fullName: String,
                    private var street: String,
                    private var city: String,
                    private var state: String,
                    private var zip: String,
                    private var phoneNumber: String,
                    @Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    private var id: Long = 0) : UserDetails {
    fun setUsername(username: String) { this.username = username }
    fun setPassword(password: String, encoder: PasswordEncoder) { this.password = encoder.encode(password).toString() }
    fun setFullName(fullname: String) { this.fullName=fullname }
    fun setCity(city: String) { this.city = city }
    fun setState(state: String) { this.state = state }
    fun setZip(zip: String) { this.zip = zip }
    fun SetPhoneNumber(phoneNumber: String) { this.phoneNumber = phoneNumber }


    fun getId(): Long = id
    override fun getUsername() = username
    override fun getPassword() = password
    fun getFullName() = fullName
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

    override fun getAuthorities(): List<out GrantedAuthority> {
        return listOf(SimpleGrantedAuthority("ROLE_USER"))
    }

}