package record.liquors.liquor.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.api.LiquorResponse
import record.liquors.liquor.api.LiquorSaveRequest
import record.liquors.liquor.api.LiquorUpdateRequest
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.repository.LiquorCategoryRepository
import record.liquors.liquor.repository.LiquorRepository
import kotlin.NoSuchElementException
import kotlin.streams.toList

@Service
@Transactional(readOnly = true)
class LiquorService(
  val liquorRepository: LiquorRepository,
  val liquorCategoryRepository: LiquorCategoryRepository
) {
  @Transactional
  fun save(request: LiquorSaveRequest): Long {
    val liquor = Liquor(
      name = request.name,
      rating = request.rating,
      review = request.review,
      category = liquorCategoryRepository.findById(request.categoryId)
        .orElseThrow { throw NoSuchElementException("liquor category not found") }
    )
    liquorRepository.save(liquor)
    return liquor.id!!
  }

  fun findOne(id: Long): Liquor {
    return liquorRepository.findById(id).orElseThrow { throw NoSuchElementException("liquor not found") }
  }

  fun findLiquors(pageable: Pageable): Page<LiquorResponse> {
    return PageImpl(liquorRepository.findAll(pageable).stream().map { liquor -> LiquorResponse.toDto(liquor) }.toList())
  }

  @Transactional
  fun update(id: Long, request: LiquorUpdateRequest): Long {
    liquorRepository.findById(id).orElseThrow { throw NoSuchElementException("liquor not found") }.update(
      name = request.name,
      rating = request.rating,
      review = request.review,
      category = liquorCategoryRepository.findById(request.categoryId)
        .orElseThrow { throw NoSuchElementException("liquor category not found") }
    )
    return id
  }
}