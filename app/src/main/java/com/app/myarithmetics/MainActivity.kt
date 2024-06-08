package com.app.myarithmetics

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnMin = findViewById<Button>(R.id.btnMin)
        val btnMax = findViewById<Button>(R.id.btnMax)
        val btnAvg = findViewById<Button>(R.id.btnAvg)
        val btnSum = findViewById<Button>(R.id.btnSum)
        val btnSearch = findViewById<Button>(R.id.btnSearch)

        val etNumber = findViewById<EditText>(R.id.etNumber).text
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val numbers = arrayOf<Int>(22, 30, 15, 4, 8, 90, 45, 32, 78, 100)

        btnDisplay.setOnClickListener {
            var output = ""
            var position = 0

            while (position < numbers.size) {
//                output = output + numbers[position] + "\n"
                output += "\n" + numbers[position]
                position++
            }

            tvResult.text = output
        }

        btnMin.setOnClickListener {

            var min = numbers[0]
            var position = 0

            while (position < numbers.size) {

                if (numbers[position] < min) {
                    min = numbers[position]
                }
                position++
            }

            tvResult.text = "The minimum value is $min"

        }

        btnMax.setOnClickListener {
            var max = numbers[0]
            var index = 0

            while (index < numbers.size) {

                if (numbers[index] > max) {
                    max = numbers[index]
                }
                index++
            }

            tvResult.text = "The maximum value is $max"
        }

        btnSum.setOnClickListener {
            var total = 0

            for (number in numbers) {
                total += number
            }

            tvResult.text = "The total value is $total"
        }

        btnAvg.setOnClickListener {
            var avg = 0
            var total = 0

            for (number in numbers) {
                total += number
            }

            avg = total / numbers.size

            tvResult.text = "The average is $avg"
        }

        btnSearch.setOnClickListener {
            val number = etNumber.toString().toInt()
            var found = false
            var index = -1

            var position = 0
            while (position < numbers.count()) {

                if (numbers[position] == number) {
                    found = true
                    index = position
                    break
                }

                position++
            }

            if (found) {
                tvResult.text = "$number found at index $index"
            } else {
                tvResult.text = "We could not find the number $number"
            }

        }
    }
}