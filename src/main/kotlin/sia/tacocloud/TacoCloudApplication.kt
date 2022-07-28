package sia.tacocloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TacoCloudApplication

fun main(args: Array<String>) {
	runApplication<TacoCloudApplication>(*args)
}

//ToDo: при развертывании приложения, в application.yml spring.thymeleaf.cache=false изменить на =true