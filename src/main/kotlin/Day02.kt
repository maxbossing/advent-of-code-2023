fun main() = aocDay(2) {
    part1test = 8
    part2test = 2286

    separateInputs = false

    data class Cubes(var red: Int, var green: Int, var blue: Int)

    bothParts { part ->
        val max = Cubes(
            red = 12,
            green = 13,
            blue = 14
        )

        val cubes = mutableListOf<Cubes>()

        for (line in inputLines) {

            val cube = Cubes(0, 0, 0)

            for (
                record in line
                .removePrefix("Game ")
                .split(":")[1]
                    .split("; ")
            ) {
                for (i in record.split(", ")) {
                    if (i.endsWith(" red")) {
                        val value = i.removeSuffix(" red").trim(' ').toInt()
                        if (cube.red < value)
                            cube.red = value
                    }
                    if (i.endsWith(" blue")) {
                        val value = i.removeSuffix(" blue").trim(' ').toInt()
                        if (cube.blue < value)
                            cube.blue = value
                    }
                    if (i.endsWith(" green")) {
                        val value = i.removeSuffix(" green").trim(' ').toInt()
                        if (cube.green < value)
                            cube.green = value
                    }
                }
            }
            cubes.add(cube)
        }

        var sum = 0
        if (part == 1) {
            cubes.forEachIndexed { index, cubes ->
                if (cubes.blue <= max.blue && cubes.green <= max.green && cubes.red <= max.red) {
                    sum += index + 1
                }
            }
        } else if (part == 2) {
            cubes.forEach {
                sum += it.blue * it.green * it.red
            }
        }

        sum
    }
}