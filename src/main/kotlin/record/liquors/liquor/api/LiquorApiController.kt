package record.liquors.liquor.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import record.liquors.liquor.service.LiquorService

@RestController
class LiquorApiController(
    val liquorService: LiquorService
) {
    @GetMapping("/liquors")
    fun getLiquorList(): List<LiquorResponse> {
        return liquorService.findLiquors()
    }

    @PostMapping("/liquor")
    fun save(request: LiquorSaveRequest) {
        liquorService.save(request)
    }
}