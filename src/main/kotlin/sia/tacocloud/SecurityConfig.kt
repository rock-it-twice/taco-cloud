package sia.tacocloud

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(userRepo: UserRepository): (String) -> UserDetails {
        // Возвращает лямбду, которая принимает имя пользователя и возвращает User из хранилища,
        // если значение не null (проверяется элвисом), иначе бросает исключение
        return { username: String ->
            userRepo.findByUsername(username) ?: throw UsernameNotFoundException("User: $username not found") }
        }

    @Bean
    // Определение прав на доступ к запросам для различных групп пользователей. (permitAll - доступно всем)
    fun filterChain(http: HttpSecurity): DefaultSecurityFilterChain {
        return  http
            .authorizeHttpRequests()
                .antMatchers("/design", "/orders").hasRole("USER")
                .antMatchers("/", "/**").permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design", true)
            .and()
                .logout()
                .logoutSuccessUrl("/")
            .and()
            .build()

    }

    }