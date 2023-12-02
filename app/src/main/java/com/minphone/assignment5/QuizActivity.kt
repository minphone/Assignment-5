package com.minphone.assignment5

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.minphone.assignment5.databinding.ActivityQuizBinding
import java.util.Calendar

class QuizActivity : AppCompatActivity() {

      private lateinit var binding: ActivityQuizBinding

      private val quizList = listOf(
            Quiz(
                  id = 1,
                  type = QuizType.RADIO,
                  question = "What is not the Kotlin Integer Data Type",
                  choice = listOf("Byte", "Float", "Short", "Int"),
                  answer = listOf("Float")
            ),
            Quiz(
                  id = 1,
                  type = QuizType.CHECK,
                  question = "What is the Kotlin Features",
                  choice = listOf(
                        "Modern and expressive",
                        "Paid Version and Good Customer Support",
                        "Multiplatform",
                        "Statically type"
                  ),
                  answer = listOf("Modern and expressive", "Multiplatform", "Statically type")
            )
      )

      companion object {
            fun newInstance(context: Context): Intent {
                  return Intent(context, QuizActivity::class.java)
            }
      }

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityQuizBinding.inflate(layoutInflater)

            quizList.forEach {
                  val view =
                        if (it.type == QuizType.RADIO) RadioQuizView(this) else CheckboxView(this)
                  view.bind(it)
                  binding.llQuizContainer.addView(view)
            }

            setContentView(binding.root)

            binding.btnSubmit.setOnClickListener {
                  var correctQuestion = 0
                  for (index in 0..<binding.llQuizContainer.childCount) {
                        if ((binding.llQuizContainer[index] as QuizViewType).isCorrect()) correctQuestion++
                  }
                  AlertDialog.Builder(this).setTitle("Result")
                        .setMessage("Congratulations! You submitted on the current ${Calendar.getInstance().time}, you achieved ${(correctQuestion * 100) / quizList.size}%")
                        .setPositiveButton(
                              "Close",
                              DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() })
                        .show()
            }

            binding.btnReset.setOnClickListener {
                  for (index in 0..<binding.llQuizContainer.childCount) {
                        (binding.llQuizContainer[index] as QuizViewType).reset()
                  }
            }
      }
}
