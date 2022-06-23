package no.nav

import no.nav.rapid.Answer
import no.nav.rapid.Question
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class QuizApplicationTest {


    @Test
    fun `håndterer team-registration`() {
        val teamNavn = "fyrstikkeske"
        val qa = QuizApplication(teamNavn)
        qa.handle(Question(category = "team-registration", question =  "register new team..."))
        val messages = qa.messages()
        assertEquals(1, messages.size)
        assertEquals(teamNavn, (messages[0] as Answer).answer)
    }

    @Test
    fun `håndterer matte`() {
        val spm1 = 39 - 45
        val spm2 = 56.floorDiv(24)
        val spm7 = 38 + 15
        val spm8 = 34 * 6

        val teamNavn = "fyrstikkeske"
        val qa = QuizApplication(teamNavn)
        qa.handle(Question(category = "arithmetic", question = "39 - 45"))
        qa.handle(Question(category = "arithmetic", question = "56 / 24"))
        qa.handle(Question(category = "arithmetic", question = "38 + 15"))
        qa.handle(Question(category = "arithmetic", question = "34 * 6"))

        val messages = qa.messages()
        assertEquals(4, messages.size)
        assertEquals(spm1.toString(), (messages[0] as Answer).answer)
        assertEquals(spm2.toString(), (messages[1] as Answer).answer)
        assertEquals(spm7.toString(), (messages[2] as Answer).answer)
        assertEquals(spm8.toString(), (messages[3] as Answer).answer)

    }

}