fun main() {
    val input = readInput("Day02")
    var IDs = 0
    input.forEachIndexed { index, game ->

        val parts = getGameParts(game)
        println(parts)
        println(isGameValid(parts))
        if (isGameValid(parts)) IDs += index +1
        println(IDs)
    }

}

fun isGameValid(game: List<String>): Boolean {
    var isValid = true
    game.forEach { part ->
        bagCubes.forEach { (key, value) ->
            if (part.contains(value) && getCubesCountByName(value, part) > key)  isValid = false
        }

    }
    return isValid
}

private val bagCubes = mapOf(
    12 to "red",
    13 to "green",
    14 to "blue"
)

// 9 red, 2 green, 13 blue
private fun getCubesCountByName(cubeName: String, gamePart: String): Int {
    val cubes = gamePart.split(",")
    var result = 0
    cubes.forEach { cube ->
        if (cube.contains(cubeName))
            result += getColorAppearance(cube)
    }
    return result
}

private fun getColorAppearance(cube: String): Int {
    var result = ""
    cube.forEach { ch ->
        if (ch.isDigit()) result += ch
    }
    return result.toInt()
}


private fun getGameParts(input: String): List<String> {
    val games = input.substring(input.indexOf(":") + 1)
    return games.split(";")
}

private fun countMatches(string: String, pattern: String): Int {
    return string.split(pattern)
        .dropLastWhile { it.isEmpty() }
        .toTypedArray().size - 1
}
