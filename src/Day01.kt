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
        a.forEachIndexed { index, i -> result += Math.abs(i - b[index]) }

        return result
    }

    val testInput = readInput("Day01_test")
    println(part1(testInput))
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
}
