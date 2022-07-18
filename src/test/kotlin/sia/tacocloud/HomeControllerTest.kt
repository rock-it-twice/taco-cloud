package sia.tacocloud

import org.hamcrest.core.StringContains.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
// в тест внедряется mockMvc для управления фиктивным объектом
class HomeControllerTest(@Autowired val mockMvc: MockMvc) {
    @Test
    fun testHomePage(){
        mockMvc.perform(get("/")) //выполняет GET запрос с "/"
            .andExpect(status().isOk) //ожидается ответ HTTP 200
            .andExpect(view().name("home")) //ожидается имя представления home
            .andExpect(content().string(containsString("Welcome to the Taco Club!"))) //ожидание строки

    }
}
