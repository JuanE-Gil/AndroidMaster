package com.juanegil.androidmaster.sintaxis

fun main() {
    val name: String = "Juan"

    println(name?.get(3) ?: "Es nulo")
}