
/**
 * Number guessing game tutorial, by Connor Brennan
 */

val ansi = Ansi()

fun main() {
    ansi.detectConsole()
    ansi.clear()
    ansi.setFormat("1;35")

    println("------------------------------------")
    println("Welcome to my Kotlin guessing game!")
    println("------------------------------------\n")
    ansi.setFormat("35")

    val numToGuess = (1..100).random()

    println("I am thinking of a number from 1 to 100")
    println("Can you guess what it is?")


    //Main loop
    while (true) {
        var guess = readlnOrNull()?.toIntOrNull()
        if (guess == null) {
            println("Please enter number")
            continue
        } else if (guess !in 1..100) {
            println("Please enter number from 1 to 100")
        }
        when {
            guess == numToGuess -> {
                ansi.println("1;32","You guessed correctly!")
                break
            }
            guess<numToGuess -> {
                ansi.println("1;31","Your guess is too low.")
            }
            guess>numToGuess -> {
                ansi.println("1;31","Your guess is too high.")
            }
        }
        
    }

}