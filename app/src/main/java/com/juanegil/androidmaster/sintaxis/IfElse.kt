package com.juanegil.androidmaster.sintaxis

fun main() {
    ifMultipleOR()
}

fun ifMultipleOR() {
    var pet = "dog"
    var isHappy = true

    if (pet == "dog" || (pet == "cat" && isHappy)) {
        println("Es un perro o un gato")
    }
}


fun ifMultiple() {
    var age = 18
    var parentPermission = false
    var imHappy = true

    if (age >= 18 && parentPermission && imHappy) {
        println("Puedo beber cerveza")
    } else {
        println("No puedo beber")
    }
}


fun ifInt() {
    var age = 18

    if (age >= 18) {
        println("Beber cerveza")
    } else {
        println("Beber jugo")
    }
}


fun ifBoolean() {
    var soyFeliz: Boolean = true

    // Sin nada == true
    // Con ! al principio == false

    if (!soyFeliz) {
        println("Estoy triste :(")
    }
}


fun ifAnidado() {
    val animal = "juan"

    if (animal == "dog") {
        println("Es un perrito!")
    } else if (animal == "cat") {
        println("Es un gato")
    } else if (animal == "bird") {
        println("Es un pajaro")
    } else {
        println("No es uno de los animales esperados")
    }
}

fun ifBasic() {
    val name = "Juan"

    if (name == "Juan") {
        println("Oye, la variable name es Juan")
    } else {
        println("Este no es Juan")
    }
}