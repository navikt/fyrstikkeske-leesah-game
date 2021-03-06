package no.nav

import no.nav.db.Database
import no.nav.quizrapid.*
import no.nav.rapid.Assessment
import no.nav.rapid.Question


/**
 * QuizApplication
 *
 * Her skal teamet bygge ut funksjonalitet for å løse oppgavene i leesah-game.
 */
class QuizApplication(private val teamName: String, database: Database? = null): QuizParticipant(teamName) {

    override fun handle(question: Question) {
        logger.log(question)

        when (question.category) {
            "team-registration" -> handleRegisterTeam(question)
            "arithmetic" -> handleArithmetic(question)
            "make-ingress" -> handleIngress(question)
            "NAV" -> handleNav(question)
        }
    }


    override fun handle(assessment: Assessment) {
        logger.log(assessment)
    }

    /**
     * Spørsmål handlers
     */

    private fun handleIngress(question: Question) {
        answer(category = question.category, questionId = question.id(), answer = "fyrstikkeske-leesah-game.dev.intern.nav.no")
    }
    private fun handleNav(question: Question) {
        val result = when (question.question) {
            "På hvilken nettside finner man informasjon om rekruttering til NAV IT?" -> "detsombetyrnoe.no"
            else -> "NAIS"
        }
        answer(category = question.category, questionId = question.id(), answer = result)
    }

    private fun handleArithmetic(question: Question) {
        val biter = question.question.split(" ")
        val delimiter = biter[1]
        val tall1 = biter[0].toInt()
        val tall2 = biter[2].toInt()
        println(biter)

        val result = when (delimiter) {
            "+" -> tall1 + tall2

            "-" -> tall1 - tall2

            "/" -> tall1.floorDiv(tall2)

            else -> tall1 * tall2
        }

        answer(category =  question.category, questionId = question.id(), answer = result.toString())
    }

    private fun handleRegisterTeam(question: Question) {
        answer(category =  question.category, questionId = question.id(), answer = "fyrstikkeske")
    }

}