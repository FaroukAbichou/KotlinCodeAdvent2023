fun main() {
    val input = readInput("Day01")
    getFinalResult(input).println()
}

private fun getFinalResult(input: List<String>): Int {
    return input.sumOf { line ->
        getLineSum(getSpelledLettersNumber(line))
    }
}

private fun getLineSum(pair: List<Int>): Int {
    return (pair.first().toString().plus(pair.last())).toInt()
}

private fun getSpelledLettersNumber(input: String): List<Int> {
    val spelledOutNumbers = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine"
    )
    val result = emptyList<Int>().toMutableList()

    repeat(input.length) { times ->
        spelledOutNumbers.forEach { (key, value) ->
            if (input.subSequence(times, input.length).startsWith(value)) {
                result += key
            }
        }
        if (input[times].isDigit()) {
            result += input[times].toString().toInt()
        }
    }

    return result
}