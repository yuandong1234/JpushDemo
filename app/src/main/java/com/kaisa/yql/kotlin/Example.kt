package com.kaisa.yql.kotlin

class Example {
}


fun main() {
    val items = listOf(1, 2, 3, 4, 5) // Lambdas 表达式是花括号括起来的代码块。
    var value = items.fold(0, { // 如果⼀个 lambda 表达式有参数，前⾯是参数，后跟“->”
        acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // lambda 表达式中的最后⼀个表达式是返回值：
        result
    })
    println("----------------------")
    println("value = $value")
    val product = items.fold(1, Int::times)

    println("product = $product")
}