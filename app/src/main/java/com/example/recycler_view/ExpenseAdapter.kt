package com.example.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>(){

    var expenseData = arrayOf<Exp>()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    class ExpenseViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val expense_type  = view.findViewById<TextView>(R.id.exp_type)
        val expense_price  = view.findViewById<TextView>(R.id.exp_price)
        val expense_date  = view.findViewById<TextView>(R.id.date)
    }

    override fun getItemCount(): Int {
        return expenseData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {

        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.expense_format, parent, false)
        return ExpenseViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        with(holder){
            expense_type.text = expenseData[position].exp_type
            expense_price.text = expenseData[position].price.toString()
            expense_date.text = expenseData[position].date
        }
    }

    override fun getItemId(position: Int): Long {
        return expenseData[position].exp_type.hashCode().toLong()
    }
}