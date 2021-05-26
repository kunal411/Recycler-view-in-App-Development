package com.example.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

val expenses = arrayOf(Exp("Rent", 5000.00, "13/June/2020"),
                       Exp("Cell Phone", 5000.00, "13/June/2020"),
                       Exp("Utility Bills", 5000.00, "13/June/2020"),
                       Exp("Insurance", 5000.00, "13/June/2020"),
                       Exp("Groceries", 5000.00, "13/June/2020"),
                       Exp("Transportation", 5000.00, "13/June/2020"),
                       Exp("Rent1", 6000.00, "13/June/2020"),
                       Exp("Rent2", 7000.00, "13/June/2020"),
                       Exp("Rent3", 8000.00, "13/June/2020"),
                       Exp("Rent4", 9000.00, "13/June/2020"))

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expense_list = findViewById<RecyclerView>(R.id.expense_list).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)

            adapter = ExpenseAdapter().apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }
        (expense_list.adapter as ExpenseAdapter).expenseData = expenses
        val total = findViewById<TextView>(R.id.total_price)
        total.text = Exp.total(expenses).toString()
    }
}