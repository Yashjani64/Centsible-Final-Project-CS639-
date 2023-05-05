package com.example.centsible

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog

class SecondActivity : AppCompatActivity() {

    private lateinit var incomeTextView: TextView
    private lateinit var monthlyGoalTextView: TextView
    private lateinit var caloriesGoalTextView: TextView
    private lateinit var mealListLinearLayout: LinearLayout
    private lateinit var dailyExpenseTextView: TextView
    private lateinit var totalBalanceTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        incomeTextView = findViewById(R.id.incomeTextView)
        monthlyGoalTextView = findViewById(R.id.monthlyGoalTextView)
        caloriesGoalTextView = findViewById(R.id.caloriesGoalTextView)
        mealListLinearLayout = findViewById(R.id.mealListLinearLayout)
        dailyExpenseTextView = findViewById(R.id.dailyExpenseTextView)
        totalBalanceTextView = findViewById(R.id.totalBalanceTextView)

        val income = intent.getIntExtra("INCOME", 0)
        val monthlyGoal = intent.getIntExtra("MONTHLY_GOAL", 0)
        val caloriesGoal = intent.getIntExtra("CALORIES_GOAL", 0)

        incomeTextView.text = "Income: $income"
        monthlyGoalTextView.text = "Monthly Goal:                                                       $monthlyGoal"
        caloriesGoalTextView.text = "Calories Goal:                                           $caloriesGoal"


        val addExpenseButton = findViewById<Button>(R.id.addExpenseButton)

        addExpenseButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Add Expense")
            val view = layoutInflater.inflate(R.layout.dialog_add_expense, null)
            builder.setView(view)

            // Get a reference to the RadioGroup and the selected RadioButton
            val frequencyRadioGroup = view.findViewById<RadioGroup>(R.id.frequencyRadioGroup)
            val selectedRadioButtonId = frequencyRadioGroup.checkedRadioButtonId
            val selectedRadioButton = view.findViewById<RadioButton>(selectedRadioButtonId)

            builder.setPositiveButton("Add") { dialogInterface, i ->
                // Handle adding expense with the selected frequency
                val frequency = selectedRadioButton.text.toString()

                // Move this line outside the block
                val amountEditText = view.findViewById<EditText>(R.id.amountEditText)

                val amount = amountEditText.text.toString().toIntOrNull() ?: 0

                // Update daily expense and total balance based on frequency and amount
                when (frequency) {
                    "Daily" -> {
                        val dailyExpense = dailyExpenseTextView.text.toString().split(": ")[1].toInt()
                        dailyExpenseTextView.text = "Daily Expense: ${dailyExpense + amount}"
                        totalBalanceTextView.text = "Total Balance: ${income - dailyExpense - amount}"
                    }
                    "Weekly" -> {
                        val weeklyExpense = dailyExpenseTextView.text.toString().split(": ")[1].toInt() * 7
                        dailyExpenseTextView.text = "Daily Expense: ${weeklyExpense + amount / 7}"
                        totalBalanceTextView.text = "Total Balance: ${income - weeklyExpense - amount}"
                    }
                    "Monthly" -> {
                        val monthlyExpense = dailyExpenseTextView.text.toString().split(": ")[1].toInt() * 30
                        dailyExpenseTextView.text = "Daily Expense: ${monthlyExpense + amount / 30}"
                        totalBalanceTextView.text = "Total Balance: ${income - monthlyExpense - amount}"
                    }
                }
            }

            builder.setNegativeButton("Cancel") { dialogInterface, i ->
                // Handle canceling expense addition
            }
            builder.show()
        }





        // Create LinearLayout for each meal and add to the mealListLinearLayout
        val mealList = arrayOf("Breakfast", "Lunch", "Dinner")
        val caloriesList = arrayOf(300, 500, 700)
        for (i in mealList.indices) {
            val mealLinearLayout = LinearLayout(this)
            mealLinearLayout.orientation = LinearLayout.HORIZONTAL

            val mealTextView = TextView(this)
            mealTextView.text = mealList[i]
            mealTextView.width = 250

            val caloriesTextView = TextView(this)
            caloriesTextView.text = caloriesList[i].toString()
            caloriesTextView.width = 150

            mealLinearLayout.addView(mealTextView)
            mealLinearLayout.addView(caloriesTextView)

            mealListLinearLayout.addView(mealLinearLayout)
        }

        dailyExpenseTextView.text = "Daily Expense: "
        totalBalanceTextView.text = "Total Balance:                        $income"
    }


}
