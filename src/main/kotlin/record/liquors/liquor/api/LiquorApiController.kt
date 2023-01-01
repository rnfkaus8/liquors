package record.liquors.liquor.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import record.liquors.liquor.service.LiquorService
import javax.validation.Valid

@RestController
class LiquorApiController(
    val liquorService: LiquorService
) {
    @GetMapping("/liquors")
    fun getLiquorList(): List<LiquorResponse> {
        return liquorService.findLiquors()
    }

    @PostMapping("/liquor")
    fun save(@RequestBody @Valid request: LiquorSaveRequest): Long {
        return liquorService.save(request)
    }

    @PutMapping("/liquor/{id}")
    fun update(
        @PathVariable("id") id: Long,
        @RequestBody @Valid request: LiquorUpdateRequest): UpdateLiquorResponse {
        val updatedId = liquorService.update(id, request)
        return UpdateLiquorResponse.toDto(liquorService.findOne(updatedId))
    }


}