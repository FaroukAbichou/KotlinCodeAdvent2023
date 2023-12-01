fun main() {
    val input = readInput("Day01")

    getFinalResult(input).println()
}

fun getFinalResult(input: List<String>): Int {
    return input.map {
        getFirstLastNumber(getNumbers(it))
    }.sum()
}

fun getFirstLastNumber(input: String): Int {
    val firstNumber = input.first().toString()
    val secondNumber = input.last().toString()
    return (firstNumber + secondNumber).toInt()
}

fun getNumbers(input: String): String {
    return input.filter { it.isDigit() }
}