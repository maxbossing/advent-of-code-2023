fun main() = aocDay(1) {
    part1test = 142
    part2test = 281

    separateInputs = true

    part1 {
        val nums = mutableListOf<Pair<Char, Char>>()

        for (line in inputLines) {
            nums.add(
                line.find { it.isDigit() }!! to line.findLast { it.isDigit() }!!
            )
        }

        nums.sumOf { "${it.first}${it.second}".toInt() }
    }

    part2 {

        val numberNames = listOf("one", "two",  "three",  "four",  "five",  "six",  "seven",  "eight",  "nine")

        inputLines.sumOf { line ->
            val nums = ArrayDeque<Int>()

            line.forEachIndexed { cIndex, c ->
                if (c.isDigit())
                    nums.add(c.digitToInt())

                numberNames.forEachIndexed { index, digit ->
                    if (line.drop(cIndex).startsWith(digit))
                        nums.add(index + 1)
                }
            }
            "${nums.first()}${nums.last()}".toInt()
        }
    }
}