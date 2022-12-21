package record.liquors

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LiquorsApplication

fun main(args: Array<String>) {
	runApplication<LiquorsApplication>(*args)
}
