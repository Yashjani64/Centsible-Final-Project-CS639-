package com.example.centsible

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var incomeEditText: EditText
    private lateinit var monthlyGoalEditText: EditText
    private lateinit var caloriesGoalEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        incomeEditText = findViewById(R.id.incomeEditText)
        monthlyGoalEditText = findViewById(R.id.monthlyGoalEditText)
        caloriesGoalEditText = findViewById(R.id.caloriesGoalEditText)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val income = incomeEditText.text.toString().toInt()
            val monthlyGoal = monthlyGoalEditText.text.toString().toInt()
            val caloriesGoal = caloriesGoalEditText.text.toString().toInt()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("INCOME", income)
            intent.putExtra("MONTHLY_GOAL", monthlyGoal)
            intent.putExtra("CALORIES_GOAL", caloriesGoal)
            startActivity(intent)
        }
    }
}

