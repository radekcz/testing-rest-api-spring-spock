package cz.rk.spring.controller

import cz.rk.spring.service.StatsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
/**
 * StatsController SprintBootTest
 * If we want to overwrite Bean StatsService in Spring context,
 * it's necessary to turn on property "allow-bean-definition-overriding: true"
 */
class StatsControllerSpringBootTest2Spec extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "can get stats/statistics using TestConfiguration"() {
        expect:
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stats")
                .contentType(APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
    }

    @org.springframework.boot.test.context.TestConfiguration
    static class TestConfiguration {

        @Bean
        StatsService statsService() {
            return new StatsService()
        }
    }
}