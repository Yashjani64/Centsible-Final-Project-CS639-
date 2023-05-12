package com.example.centsible

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*


class SecondActivity : AppCompatActivity() {

    private lateinit var incomeTextView: TextView
    private lateinit var monthlyGoalTextView: TextView
    private lateinit var caloriesGoalTextView: TextView
    private lateinit var mealListLinearLayout: LinearLayout
    private lateinit var dailyExpenseTextView: TextView
    private lateinit var totalBalanceTextView: TextView
    private lateinit var addExpenseButton: Button
    private lateinit var expenseEditText: EditText

    private var income: Int = 0
    private var monthlyGoal: Int = 0
    private var caloriesGoal: Int = 0
    private var totalExpenses: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        incomeTextView = findViewById(R.id.incomeTextView)
        monthlyGoalTextView = findViewById(R.id.monthlyGoalTextView)
        caloriesGoalTextView = findViewById(R.id.caloriesGoalTextView)
        mealListLinearLayout = findViewById(R.id.mealListLinearLayout)
        dailyExpenseTextView = findViewById(R.id.dailyExpenseTextView)
        totalBalanceTextView = findViewById(R.id.totalBalanceTextView)
        addExpenseButton = findViewById(R.id.addExpenseButton)
        expenseEditText = findViewById(R.id.expenseEditText)

        income = intent.getIntExtra("INCOME", 0)
        monthlyGoal = intent.getIntExtra("MONTHLY_GOAL", 0)
        caloriesGoal = intent.getIntExtra("CALORIES_GOAL", 0)

        incomeTextView.text = "Income: $income"
        monthlyGoalTextView.text =
            "Monthly Goal:                                                       $monthlyGoal"
        caloriesGoalTextView.text =
            "Calories Goal:                                           $caloriesGoal"
// Add the following code
        if (monthlyGoal <= 0) {
            monthlyGoalTextView.setBackgroundColor(Color.RED)
        } else if (monthlyGoal <= 25) {
            monthlyGoalTextView.setBackgroundColor(Color.YELLOW)
            monthlyGoalTextView.setTextColor(Color.BLACK);
        } else {

            monthlyGoalTextView.setBackgroundColor(Color.parseColor("#252425"))
        }

        // Create LinearLayout for each meal and add to the mealListLinearLayout
        // Create LinearLayout for each meal and add to the mealListLinearLayout
        // Create LinearLayout for each meal and add to the mealListLinearLayout
//        val mealList = arrayOf(
//            "Breakfast - Scrambled Eggs (300 cal) - $5",
//            "Lunch - Grilled Chicken Sandwich (500 cal) - $8",
//            "Dinner - Spaghetti Bolognese (700 cal) - $12",
//            "Breakfast - Scrambled Eggs (300 cal) - $5",
//            "Lunch - Grilled Chicken Sandwich (500 cal) - $8",
//            "Dinner - Spaghetti Bolognese (700 cal) - $12"
//        )
        val mealList = arrayOf(
            "Grilled Chicken   - Lean chicken breast with steamed vegetables.(300 cal) - $10",
            "Salmon with Quinoa - Fresh salmon with quinoa and roasted asparagus.(400 cal) - $12",
            "Turkey Meatballs  - Delicious turkey meatballs with whole wheat pasta and marinara sauce.(450 cal) - $5",
            "Greek Salad       - Classic Greek salad with grilled chicken.(300 cal) - $5",
            "Veggie Burger     - Veggie burger with sweet potato fries.(300 cal) - $5",
            "Grilled Chicken   - Lean chicken breast with steamed vegetables.(300 cal) - $10",
            "Salmon with Quinoa - Fresh salmon with quinoa and roasted asparagus.(400 cal) - $12",
            "Turkey Meatballs  - Delicious turkey meatballs with whole wheat pasta and marinara sauce.(450 cal) - $5",
            "Greek Salad       - Classic Greek salad with grilled chicken.(300 cal) - $5",
            "Veggie Burger     - Veggie burger with sweet potato fries.(300 cal) - $5",
            "Grilled Chicken   - Lean chicken breast with steamed vegetables.(300 cal) - $10",
            "Salmon with Quinoa - Fresh salmon with quinoa and roasted asparagus.(400 cal) - $12",
            "Turkey Meatballs  - Delicious turkey meatballs with whole wheat pasta and marinara sauce.(450 cal) - $5",
            "Greek Salad       - Classic Greek salad with grilled chicken.(300 cal) - $5",
            "Veggie Burger     - Veggie burger with sweet potato fries.(300 cal) - $5",
            "Grilled Chicken   - Lean chicken breast with steamed vegetables.(300 cal) - $10",
            "Salmon with Quinoa - Fresh salmon with quinoa and roasted asparagus.(400 cal) - $12",
            "Turkey Meatballs  - Delicious turkey meatballs with whole wheat pasta and marinara sauce.(450 cal) - $5",
            "Greek Salad       - Classic Greek salad with grilled chicken.(300 cal) - $5",
            "Veggie Burger     - Veggie burger with sweet potato fries.(300 cal) - $5",
//            "Shrimp Stir-Fry   - Shrimp stir-fry with brown rice.(300 cal) - $5",
//            "Quinoa Salad      - Quinoa salad with avocado and black beans.",
//            "Baked Cod         - Baked cod with steamed broccoli and brown rice.",
//            "Grilled Tofu      - Grilled tofu with stir-fried vegetables.",
//            "Caprese Salad     - Caprese salad with balsamic glaze.",
//            "Turkey Chili      - Turkey chili with beans.",
//            "Grilled Salmon    - Grilled salmon with lemon-dill sauce and roasted Brussels sprouts.",
//            "Mediterranean Wrap- Mediterranean chicken wrap with hummus.",
//            "Roasted Vegetable - Roasted vegetable quinoa bowl.",
//            "Spinach Omelette  - Spinach and mushroom omelette with whole wheat toast.",
//            "Chicken Stir-Fry  - Chicken and vegetable stir-fry with brown rice.",
//            "Black Bean Burger - Black bean burger with avocado and salsa.",
//            "Baked Chicken     - Baked chicken breast with roasted sweet potatoes and green beans.",
//            "Greek Yogurt      - Greek yogurt parfait with fresh berries and granola.",
//            "Grilled Veggie    - Grilled veggie skewers with quinoa.",
//            "Asian Sesame Salad- Asian sesame ginger salad with grilled shrimp.",
//            "Sweet Potato      - Sweet potato and black bean enchiladas.",
//            "Turkey Lettuce    - Turkey and vegetable lettuce wraps.",
//            "Quinoa Stuffed    - Quinoa stuffed bell peppers.",
//            "Cauliflower Fried - Cauliflower fried rice with chicken.",
//            "Mixed Green Salad - Mixed green salad with grilled salmon."
        )


        for (meal in mealList) {
            val mealLayout = LinearLayout(this)
            mealLayout.orientation = LinearLayout.HORIZONTAL
            mealLayout.setPadding(0, 10, 0, 10)

            mealLayout.setOnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_HOVER_ENTER -> mealLayout.setBackgroundColor(Color.BLACK)
                    MotionEvent.ACTION_HOVER_EXIT -> mealLayout.setBackgroundColor(Color.TRANSPARENT)
                }
                false
            }

            val mealTextView = TextView(this)
            val parts = meal.split("-")
            val name = parts[0].trim()
            val description = parts[1].trim()
            val price = parts[2].trim()

            val mealText = "$name\n$description"

            mealTextView.text = mealText
            mealTextView.setTextColor(Color.WHITE)
            mealTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            mealTextView.setTypeface(null, Typeface.BOLD) // Set the text to bold
            mealTextView.layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
            )

            val priceTextView = TextView(this)
            priceTextView.text = price
            priceTextView.setTextColor(Color.WHITE)
            priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
            priceTextView.setTypeface(null, Typeface.BOLD) // Set the text to bold
            priceTextView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val descriptionTextView = TextView(this)
            descriptionTextView.text = description
            descriptionTextView.setTextColor(Color.WHITE)
            descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 1f) // Set a smaller text size for the description
            descriptionTextView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val selectButton = Button(this)
            selectButton.text = "Select"
            selectButton.gravity = Gravity.CENTER
            selectButton.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            selectButton.setOnClickListener {
                // Your button click logic here
                selectButton.setOnClickListener {
                    val mealPrice = extractMealPrice(meal)
                    val mealCalories = extractMealCalories(meal)
                    income -= mealPrice
                    monthlyGoal -= mealPrice
                    totalExpenses += mealPrice


                    val originalCaloriesGoal = caloriesGoal
                    caloriesGoal -= mealCalories

                    totalBalanceTextView.text = "Total Balance:                      $income"
                    monthlyGoalTextView.text = "Monthly Goal:                                                       $monthlyGoal"

                    val currentDate = Calendar.getInstance()
                    val daysInMonth = currentDate.getActualMaximum(Calendar.DAY_OF_MONTH)
                    val dailyExpense = totalExpenses
                    val monthlyExpense = dailyExpense * daysInMonth

                    dailyExpenseTextView.text = "Daily Expense: $dailyExpense"



                    if (monthlyGoal < 0) {
                        monthlyGoalTextView.setBackgroundColor(Color.RED)
                    }

                    val monthlyGoalThreshold75 = originalCaloriesGoal * 0.75
                    val monthlyGoalThreshold50 = originalCaloriesGoal * 0.5
                    val monthlyGoalThreshold25 = originalCaloriesGoal * 0.25

                    if (monthlyExpense > monthlyGoal) {
                        dailyExpenseTextView.setBackgroundColor(Color.RED)
                    } else if (monthlyExpense > monthlyGoalThreshold75) {
                        dailyExpenseTextView.setBackgroundColor(Color.YELLOW)
                        dailyExpenseTextView.setTextColor(Color.BLACK);
                    } else {
                        dailyExpenseTextView.setBackgroundColor(Color.parseColor("#3F0071"))
                    }

                    if (caloriesGoal > monthlyGoalThreshold75) {
                        caloriesGoalTextView.setBackgroundColor(Color.RED)
                    } else if (caloriesGoal > monthlyGoalThreshold50) {
                        caloriesGoalTextView.setBackgroundColor(Color.YELLOW)
                        dailyExpenseTextView.setTextColor(Color.BLACK);
                    } else if (caloriesGoal > monthlyGoalThreshold25) {
                        caloriesGoalTextView.setBackgroundColor(Color.GREEN)
                    } else {
                        caloriesGoalTextView.setBackgroundColor(Color.GREEN)
//                        caloriesGoalTextView.setBackgroundColor(Color.parseColor("#FB2576"))

//
                    }

                    caloriesGoalTextView.text = "Calories Goal:                                           $caloriesGoal"
                }
            }

            val buttonLayout = LinearLayout(this)
            buttonLayout.orientation = LinearLayout.HORIZONTAL
            buttonLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            buttonLayout.gravity = Gravity.CENTER

            buttonLayout.addView(selectButton)

            mealLayout.addView(mealTextView)
            mealLayout.addView(priceTextView)
            mealLayout.addView(buttonLayout)

            mealListLinearLayout.addView(mealLayout)
        }








        dailyExpenseTextView.text = "Daily Expense: $totalExpenses"
        totalBalanceTextView.text = "Total Balance:                      $income"

        addExpenseButton.setOnClickListener {
            val expense = expenseEditText.text.toString().toIntOrNull()
            if (expense != null) {
                totalExpenses += expense
                monthlyGoal -= expense
                income -= expense

                val currentDate = Calendar.getInstance()
                val daysInMonth = currentDate.getActualMaximum(Calendar.DAY_OF_MONTH)
                val monthlyExpense = totalExpenses * daysInMonth

                dailyExpenseTextView.text = "Daily Expense: $totalExpenses"

                if (monthlyExpense > monthlyGoal) {
                    dailyExpenseTextView.setBackgroundColor(Color.RED)
                } else if (monthlyExpense > (monthlyGoal * 0.75)) {
                    dailyExpenseTextView.setBackgroundColor(Color.YELLOW)
                } else {
                    dailyExpenseTextView.setBackgroundColor(Color.parseColor("#3F0071"))
                }

                totalBalanceTextView.text = "Total Balance:                      $income"
                monthlyGoalTextView.text = "Monthly Goal:                                                       $monthlyGoal"
                expenseEditText.text.clear()
            } else {
                Toast.makeText(this, "Please enter a valid expense amount", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun extractMealPrice(meal: String): Int {
        val priceString = meal.substringAfterLast("-").trim().substringAfter("$").trim()
        return priceString.toIntOrNull() ?: 0
    }

    private fun extractMealCalories(meal: String): Int {
        val caloriesString = meal.substringAfterLast("(").substringBefore("cal").trim()
        return caloriesString.toIntOrNull() ?: 0
    }





}

