fun main() {
    val input = readInput("Day03")

    val rowArray = mutableListOf("")
    val columnArray = mutableListOf("")
    input.forEachIndexed { index, value ->
        columnArray.add(value[index].toString())
        value.forEachIndexed { lineIndex, lineValue ->
            rowArray.add(value[lineIndex].toString())
        }
    }
    columnArray.forEach {
        println(it)
    }
//    rowArray.forEach {
//        println(it)
//    }
}
