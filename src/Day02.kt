fun main() {
    val input = readInput("Day02")
    part1(input)
    part2(input)
}

fun part2(input: List<String>) {
    var sumOfPower = 0
    input.forEachIndexed { index, game ->
        val parts = getGameParts(game)
        var redCount = 0
        var blueCount = 0
        var greenCount = 0
        parts.forEach { part ->
            if (getCubesCountByName("red", part) > redCount) {
                redCount = getCubesCountByName("red", part)
            }
            if (getCubesCountByName("blue", part) > blueCount) {
                blueCount = getCubesCountByName("blue", part)
            }
            if (getCubesCountByName("green", part) > greenCount) {
                greenCount = getCubesCountByName("green", part)
            }
        }
        sumOfPower += redCount * blueCount * greenCount
        println(parts)
        println(redCount)
        println(blueCount)
        println(greenCount)
        println(sumOfPower)
    }
//    println(sumOfPower)
}

fun part1(input: List<String>) {
    var IDs = 0
    input.forEachIndexed { index, game ->
        val parts = getGameParts(game)
        if (isGameValid(parts)) IDs += index + 1
    }
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