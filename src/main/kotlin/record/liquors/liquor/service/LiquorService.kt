package record.liquors.liquor.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.api.LiquorResponse
import record.liquors.liquor.api.LiquorSaveRequest
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.repository.LiquorRepository
import java.util.NoSuchElementException

@Service
@Transactional
class LiquorService(
  val liquorRepository: LiquorRepository
) {
  fun save(request: LiquorSaveRequest): Long {
    val liquor = LiquorSaveRequest.toEntity(request)
    liquorRepository.save(liquor)
    return liquor.id!!
  }

  fun findById(id: Long): Liquor {
    val liquor = liquorRepository.findById(id)
    if (liquor.isEmpty) {
      throw NoSuchElementException("liquor not found")
    }
    return liquor.get()
  }

  fun findLiquors(): List<LiquorResponse> {
    return liquorRepository.findAll().stream().map { liquor -> LiquorResponse.toDto(liquor) }.toList()
  }
}