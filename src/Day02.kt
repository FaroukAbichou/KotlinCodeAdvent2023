fun main() {
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun part2(input: List<String>): Int {
    var sumOfPower = 0
    input.forEach { game ->
        val parts = getGameParts(game)
        var redCount = 0
        var blueCount = 0
        var greenCount = 0

        parts.forEach { part ->
            val redCubesCountByName = getCubesCountByName("red", part)
            val blueCubesCountByName = getCubesCountByName("blue", part)
            val greenCubesCountByName = getCubesCountByName("green", part)

            if (redCubesCountByName > redCount) redCount = redCubesCountByName
            if (blueCubesCountByName > blueCount) blueCount = blueCubesCountByName
            if (greenCubesCountByName > greenCount) greenCount = greenCubesCountByName
        }

        sumOfPower += redCount * blueCount * greenCount
    }
    return sumOfPower
}

fun part1(input: List<String>): Int {
    var IDs = 0
    input.forEachIndexed { index, game ->
        val parts = getGameParts(game)
        if (isGameValid(parts)) IDs += index + 1
    }
    return IDs
}

fun isGameValid(game: List<String>): Boolean {
    val bagCubes = mapOf(
        12 to "red",
        13 to "green",
        14 to "blue"
    )
    var isValid = true

    game.forEach { part ->
        bagCubes.forEach { (key, value) ->
            if (part.contains(value) && getCubesCountByName(value, part) > key) isValid = false
        }
    }
    return isValid
}

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