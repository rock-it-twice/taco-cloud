package sia.tacocloud

import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SecurityConfig {

    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}