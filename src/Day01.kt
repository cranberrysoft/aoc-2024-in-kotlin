import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val a = mutableListOf<Int>()
        val b = mutableListOf<Int>()
        for (line in input) {
            val split = line.split(Regex("\\s+"))
            a.add(split[0].toInt())
            b.add(split[1].toInt())
        }
        a.sort()
        b.sort()

        var result = 0
        a.forEachIndexed { index, i -> result += abs(i - b[index]) }

        return result
    }

    fun part2(input: List<String>): Int {
        val a = mutableListOf<Int>()
        val b = mutableMapOf<Int, Int>()
        for (line in input) {
            val split = line.split(Regex("\\s+"))
            a.add(split[0].toInt())
            b.compute(split[1].toInt()) { _, v -> v?.plus(1 ) ?: 1 }
        }

        var result = 0
        a.forEach {i -> result+= i * b.getOrDefault(i, 0) }
        return result
    }

    val testInput = readInput("Day01_test")
    println(part1(testInput))
    println(part2(testInput))
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
