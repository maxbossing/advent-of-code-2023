import kotlin.system.exitProcess
import kotlin.system.measureNanoTime
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*
import com.github.ajalt.mordant.terminal.Terminal

val t = Terminal()

/**
 * Creates a new [AOCDay] and opens a builder for it
 */
fun aocDay(day: Int, builder: AOCDay.() -> Unit) {
    AOCDay(day).apply(builder).run()
}

/**
 * Represents a Day of Advent Of Code
 * @see [aocDay]
 */
class AOCDay(val number: Int) {
    private fun inputFileName(extra: String = "") = "Day${number.toString().padStart(2, '0')}${extra}.txt"

    /**
     * The raw input data
     */
    var inputString = ""

    /**
     * Input data line by line
     */
    val inputLines get() = inputString.lines()

    /**
     * Input data line by line as Int
     */
    val inputInts get() = inputLines.map { it.toInt() }

    private var part1: (() -> Any)? = null
    private var part2: (() -> Any)? = null

    /**
     * Test result of [part1]
     *
     * This is the test result that is given in the example of part 1
     */
    var part1test: Any? = null

    /**
     * Test result of [part2]
     *
     * This is the test result that is given in the example of part 1
     */
    var part2test: Any? = null

    /**
     *  First part of the Day
     */
    fun part1(function: () -> Any) {
        part1 = function
    }

    /**
     * Second part of the Day
     */
    fun part2(function: () -> Any) {
        part2 = function
    }

    private fun runTest(part: Int, block: (() -> Any?)?, expected: Any?) {
        inputString = this::class.java.getResourceAsStream(inputFileName("_test"))!!.bufferedReader().readText()
        t.println("Running test on part $part...")
        var testResult = block?.invoke()
        if (testResult != expected) {
            t.println(red("${bold("Part $part:")} Expected ${bold("$expected")} but got ${bold("$testResult")}"))
        }
        t.println("Part $part: Test passed")
    }

    private fun runPart(part: Int, block: (() -> Any?)?) {
        inputString = this::class.java.getResourceAsStream(inputFileName())!!.bufferedReader().readText()
        t.println("Running part $part...")
        var result = block?.invoke()
        t.println("Part $part: $result")
    }

    fun run() {
        t.println("Running Tests...")
        t.println()
        runTest(1, part1, part1test)
        runTest(2, part2, part2test)
        t.println()
        t.println("Tests Passed, running against real input...")
        t.println()
        val time = measureNanoTime {
            runPart(1, part1)
            runPart(2, part2)
        }
    }
}

