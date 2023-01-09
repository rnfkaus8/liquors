package record.liquors.liquor.api

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun getLiquorList(page: Int, size: Int): ResponseEntity<Page<LiquorResponse>> {
        val findLiquors = liquorService.findLiquors(PageRequest.of(page, size))
        return ResponseEntity(findLiquors, HttpStatus.OK)
    }

    @GetMapping("/liquor/{id}")
    fun getLiquor(@PathVariable("id") id: Long): LiquorResponse {
        return LiquorResponse.toDto(liquorService.findOne(id))
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