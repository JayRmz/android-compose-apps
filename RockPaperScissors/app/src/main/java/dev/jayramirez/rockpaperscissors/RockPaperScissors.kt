package dev.jayramirez.rockpaperscissors

fun main () {
    val computerChoice = (1..3).random()
    var playerChoice = 0
    var winner = ""

    println("\n1) Rock \n2) Paper \n3) Scissors \nEnter your choice: ")
    playerChoice = readln().toInt()

    println("Computer choose:")
    if (computerChoice == 1) {
        println("Rock")
    } else if (computerChoice == 2) {
        println("Paper")
    } else {
        println("Scissors")
    }

    println("Player choose: ")
    if (playerChoice == 1) {
        println("Rock")
    } else if (playerChoice == 2) {
        println("Paper")
    } else {
        println("Scissors")
    }

    if (computerChoice == 1) {
        if (playerChoice == 1) {
            winner = "Tie!"
        } else if (playerChoice == 2) {
            winner = "You win!"
        } else if (playerChoice == 3){
            winner = "Computer wins!"
        }
    } else if (computerChoice == 2) {
        if (playerChoice == 1) {
            winner = "Computer wins!"
        } else if (playerChoice == 2) {
            winner = "Tie!"
        } else if (playerChoice == 3){
            winner = "You win!"
        }
    } else if (computerChoice == 3) {
        if (playerChoice == 1) {

            winner = "You win!"
        } else if (playerChoice == 2) {
            winner = "Computer wins!"
        } else if (playerChoice == 3){
            winner = "Tie!"
        }
    }

    println("Te result is..... ${winner}")

}