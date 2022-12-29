package record.liquors.liquor.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import record.liquors.liquor.entity.LiquorRating

@SpringBootTest
@AutoConfigureMockMvc
class LiquorApiControllerTest(
    @Autowired
    val mockMvc: MockMvc,

    @Autowired
    val objectMapper: ObjectMapper
) {
    @Test
    fun save() {
        val content = objectMapper.writeValueAsString(
            LiquorSaveRequest(
                name = "name1",
                rating = LiquorRating.VERY_GOOD,
                review = null,
                category = null

            )
        )
        mockMvc.perform(
            post("/liquor")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)

    }

}