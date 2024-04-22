package dev.jayramirez.rockpaperscissors

fun main () {
    val computerChoice = (1..3).random()
    var playerChoice = 0
    var winner = ""



    while (playerChoice > 3 || playerChoice < 1 ) {
        println("\n1) Rock \n2) Paper \n3) Scissors \nEnter your choice: ")
        playerChoice = readln().toInt()
    }

//    if (playerChoice > 3 || playerChoice < 1) {
//        println("Not supported entry..")
//        return
//    }


    println("Computer choose:")
    if (computerChoice == 1) {
        println("Rock")
    } else if (computerChoice == 2) {
        println("Paper")
    } else {
        println("Scissors")
    }

    println("Player choose: ")
    when (playerChoice) {
        1 -> {
            println("Rock")
        }
        2 -> {
            println("Paper")
        }
        else -> {
            println("Scissors")
        }
    }

    winner = when {
        playerChoice == computerChoice -> "Tie!"
        playerChoice == 1 && computerChoice == 3 -> "You win!"
        playerChoice == 2 && computerChoice == 1 -> "You win!"
        playerChoice == 3 && computerChoice == 2 -> "You win!"
        else -> "Computer wins!"
    }



    println("Te result is..... $winner")

}