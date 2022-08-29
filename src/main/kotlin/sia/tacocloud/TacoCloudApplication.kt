package sia.tacocloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class TacoCloudApplication

fun main(args: Array<String>) {
	runApplication<TacoCloudApplication>(*args)
}

//ToDo: при развертывании приложения, в application.yml spring.thymeleaf.cache=false изменить на =true