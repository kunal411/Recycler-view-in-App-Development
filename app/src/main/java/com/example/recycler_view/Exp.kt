package com.example.recycler_view

data class Exp(val exp_type : String, val price : Double, val date : String){

    companion object {
        fun total(expense: Array<Exp>): Double {
            var count: Double = 0.0
            expense.forEach {
                count += it.price
            }

            return count
        }
    }
}