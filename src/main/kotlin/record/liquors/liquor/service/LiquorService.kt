package record.liquors.liquor.service

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.api.LiquorResponse
import record.liquors.liquor.api.LiquorSaveRequest
import record.liquors.liquor.api.LiquorUpdateRequest
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.repository.LiquorRepository
import java.util.NoSuchElementException
import kotlin.streams.toList

@Service
class LiquorService(
  val liquorRepository: LiquorRepository
) {
  @Transactional
  fun save(request: LiquorSaveRequest): Long {
    val liquor = LiquorSaveRequest.toEntity(request)
    liquorRepository.save(liquor)
    return liquor.id!!
  }

  fun findOne(id: Long): Liquor {
    val liquor = liquorRepository.findById(id)
    if (liquor.isEmpty) {
      throw NoSuchElementException("liquor not found")
    }
    return liquor.get()
  }

  fun findLiquors(pageable: Pageable): List<LiquorResponse> {
    return liquorRepository.findAll(pageable).stream().map { liquor -> LiquorResponse.toDto(liquor) }.toList()
  }

  @Transactional
  fun update(id: Long, request: LiquorUpdateRequest): Long {
    val liquorOptional = liquorRepository.findById(id)
    if (liquorOptional.isEmpty) {
      throw NoSuchElementException("liquor not found")
    }

    val liquor = liquorOptional.get()
    liquor.update(
      name = request.name,
      rating = request.rating,
      review = request.review,
      category = request.category
    )

    return id
  }
}