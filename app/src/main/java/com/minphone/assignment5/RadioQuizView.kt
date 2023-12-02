package com.minphone.assignment5

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.minphone.assignment5.databinding.RadioQuizBinding

class RadioQuizView : ConstraintLayout, QuizViewType {

      private val binding = RadioQuizBinding.inflate(LayoutInflater.from(context), this, true)
      private var choiceAnswer = ""
      private lateinit var quiz: Quiz

      constructor(context: Context) : super(context)

      constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

      constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
            context,
            attrs,
            defStyleAttr
      )

      override fun bind(quiz: Quiz) {
            this.quiz = quiz
            binding.tvQuizQuestion.text = quiz.question

            binding.rgQuiz.orientation = LinearLayout.VERTICAL
            quiz.choice.forEach { question ->
                  val btnRadio = RadioButton(context)
                  btnRadio.text = question
                  btnRadio.setTextColor(context.getColor(R.color.black))
                  btnRadio.setOnClickListener {
                        choiceAnswer = (it as RadioButton).text.toString()
                  }
                  binding.rgQuiz.addView(btnRadio)
            }
      }

      override fun reset() {
            choiceAnswer = String()
            binding.rgQuiz.clearCheck()
      }

      override fun isCorrect(): Boolean = quiz.answer[0] == choiceAnswer

}