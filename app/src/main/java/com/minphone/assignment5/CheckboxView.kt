package com.minphone.assignment5

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import com.minphone.assignment5.databinding.CheckboxQuizBinding

class CheckboxView : ConstraintLayout, QuizViewType {

      private val binding = CheckboxQuizBinding.inflate(LayoutInflater.from(context), this, true)
      private var choiceAnswers = mutableListOf<String>()
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

            binding.llCheckbox.orientation = LinearLayout.VERTICAL
            quiz.choice.forEach { question ->
                  val btnCheck = CheckBox(context)
                  btnCheck.text = question
                  btnCheck.setTextColor(context.getColor(R.color.black))
                  btnCheck.setOnClickListener {
                        val answer = (it as CheckBox).text.toString()
                        if (choiceAnswers.contains(answer)) choiceAnswers.remove(answer)
                        else choiceAnswers.add(answer)
                  }
                  binding.llCheckbox.addView(btnCheck)
            }
      }

      override fun reset() {
            choiceAnswers = mutableListOf()
            for (index in 0..<binding.llCheckbox.childCount) {
                  (binding.llCheckbox[index] as CheckBox).isChecked = false
            }
      }

      override fun isCorrect(): Boolean {
            var result = true
            quiz.answer.forEach {
                  if (!choiceAnswers.contains(it)) result = false
            }
            return result
      }

}