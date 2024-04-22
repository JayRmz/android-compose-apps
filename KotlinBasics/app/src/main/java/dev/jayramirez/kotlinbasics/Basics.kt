package dev.jayramirez.kotlinbasics

fun main() {
    println("-- Variables and constants --")
    val number1 = 1 //val are constants, immutable variables.
    var myAge : Byte = 27
    myAge = 28 //on July 2024

    println("Hello Jay! I'm ${myAge} years old")

    //Floats , Double
    println("-- Floats and Doubles --")
    var pi = 3.14 //infers it's a Float
//    var pi = 3.14f //infers it's a Float
    println(pi)
    pi = 3.1415926535
    println(pi)


    //Unsigned
    println("-- Unsigned --")
    var age: UShort = 27u
    println(age)

    //Booleans
    println("-- Booleans --")

    val myTrue: Boolean = true
    val myFalse: Boolean = false

    println(myTrue || myFalse) //
    println(myTrue && myFalse)
    println(!myTrue)

    //Characters
    println("-- Characters --")
    val myChar: Char = '\u00AE'
    println(myChar)

    //Strings
    println("-- Strings --")

    val str = "abcd 123"
    println(str)

    for(c in str) {
        println(c.lowercase())
    }

    var firstName = "Jay"
    var lastName = "Ramirez"

    println(firstName + " " + lastName)

    //If Else
    println("-- If Else --")

    var theAgeAgain = 0

    println("Enter your age: ")
    theAgeAgain = readln().toInt()

   if (theAgeAgain >= 40) {
       println("You're just too old!")
   } else if (theAgeAgain >= 18) {
       println("You may enter")
   } else {
       println("You're just too young!")
   }

}