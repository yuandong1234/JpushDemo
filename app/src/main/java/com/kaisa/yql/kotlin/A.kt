package com.kaisa.yql.kotlin

open class A {
    open fun foo(bar: Int = 0, baz: Int) {
        println("bar = [${bar}], baz = [${baz}]")
    }

    open fun foo2(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {
        println("bar = [${bar}], baz = [${baz}]")
    }

    fun foo3(bar: Int = 0, baz: Int = 1, qux: () -> Int) {

    }
}