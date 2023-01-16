package record.liquors

import org.springframework.stereotype.Component
import record.liquors.liquor.entity.LiquorCategory
import record.liquors.liquor.repository.LiquorCategoryRepository
import record.liquors.liquor.service.LiquorService
import javax.annotation.PostConstruct

@Component
class InitDb(
    val liquorService: LiquorService,
    val liquorCategoryRepository: LiquorCategoryRepository
) {
    @PostConstruct
    fun init() {
        val whiskey = LiquorCategory(categoryName = "위스키")
        liquorCategoryRepository.save(whiskey)

        // 아메리칸 위스키
        val bourbon = LiquorCategory(categoryName = "버번 위스키", parent = whiskey)
        val tennessee = LiquorCategory(categoryName = "테네시 위스키", parent = whiskey)
        val rye = LiquorCategory(categoryName = "라이 위스키", parent = whiskey)
        val wheat = LiquorCategory(categoryName = "위트 위스키", parent = whiskey)
        val corn = LiquorCategory(categoryName = "콘 위스키", parent = whiskey)
        whiskey.addChildCategory(bourbon)
        whiskey.addChildCategory(tennessee)
        whiskey.addChildCategory(rye)
        whiskey.addChildCategory(wheat)
        whiskey.addChildCategory(corn)
        liquorCategoryRepository.save(bourbon)
        liquorCategoryRepository.save(tennessee)
        liquorCategoryRepository.save(rye)
        liquorCategoryRepository.save(wheat)
        liquorCategoryRepository.save(corn)

        // 스카치 위스키
        val singleMaltScotch  = LiquorCategory(categoryName = "싱글 몰트 스카치 위스키", parent = whiskey)
        val singleGrainScotch  = LiquorCategory(categoryName = "싱글 그레인 스카치 위스키", parent = whiskey)
        val blendedMaltScotch  = LiquorCategory(categoryName = "블렌디드 몰트 스카치 위스키", parent = whiskey)
        val blendedGrainScotch  = LiquorCategory(categoryName = "블렌디드 그레인 스카치 위스키", parent = whiskey)
        val blendedScotch  = LiquorCategory(categoryName = "블렌디드 스카치 위스키", parent = whiskey)
        whiskey.addChildCategory(singleMaltScotch)
        whiskey.addChildCategory(singleGrainScotch)
        whiskey.addChildCategory(blendedMaltScotch)
        whiskey.addChildCategory(blendedGrainScotch)
        whiskey.addChildCategory(blendedScotch)
        liquorCategoryRepository.save(singleMaltScotch)
        liquorCategoryRepository.save(singleGrainScotch)
        liquorCategoryRepository.save(blendedMaltScotch)
        liquorCategoryRepository.save(blendedGrainScotch)
        liquorCategoryRepository.save(blendedScotch)



        // 아이리쉬 위스키
        val irish = LiquorCategory(categoryName = "아이리쉬 위스키", parent = whiskey)
        whiskey.addChildCategory(irish)
        liquorCategoryRepository.save(irish)


        // 케나디안 위스키
        val canadian = LiquorCategory(categoryName = "케나디안 위스키", parent = whiskey)
        whiskey.addChildCategory(canadian)
        liquorCategoryRepository.save(canadian)

        // 일본 위스키
        val japanese = LiquorCategory(categoryName = "재패니스 위스키", parent = whiskey)
        whiskey.addChildCategory(japanese)
        liquorCategoryRepository.save(japanese)

        // 한국 위스키
        val korean = LiquorCategory(categoryName = "코리안 위스키", parent = whiskey)
        whiskey.addChildCategory(korean)
        liquorCategoryRepository.save(korean)
    }

}