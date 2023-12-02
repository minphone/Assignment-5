package com.minphone.assignment5

data class Quiz(
      val id: Int,
      val type: QuizType,
      val question: String,
      val choice: List<String>,
      val answer: List<String>
)

enum class QuizType {
      RADIO, CHECK
}
