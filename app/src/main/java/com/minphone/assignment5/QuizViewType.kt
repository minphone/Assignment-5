package com.minphone.assignment5

interface QuizViewType {

      fun bind(quiz: Quiz)

      fun reset()

      fun isCorrect(): Boolean

}