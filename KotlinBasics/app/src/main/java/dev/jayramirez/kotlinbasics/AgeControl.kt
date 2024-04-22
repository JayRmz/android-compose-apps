package dev.jayramirez.kotlinbasics

fun main () {
    println("Enter your age:")

    var age = readln().toInt()

    if (age >= 40) {
        println("You're just too old!")
    } else if (age >= 18) {
        println("You may enter")
    } else {
        println("You're just too young!")
    }
}