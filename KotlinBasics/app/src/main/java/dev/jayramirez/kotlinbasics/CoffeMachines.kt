package dev.jayramirez.kotlinbasics

fun main () {


   var user = ""
   var spoons = -1

   while(user.isEmpty()) {
      println("What's your name: ")
      user = readln()
   }


   while (spoons < 0) {
      println("How many sugar spoons? ")
      spoons = readln().toInt()
   }

   makeCoffee(spoons, user)

}

fun makeCoffee(sugarCount: Int, user: String) {

   if(sugarCount == 0) {
      println("Making a coffee with no sugar for: $user ")
      return
   }

   val spoons = if(sugarCount == 1)  "spoon" else "spoons"
   println("Making coffee  with $sugarCount $spoons of sugar for: $user")
}