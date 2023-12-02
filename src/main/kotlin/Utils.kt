
fun List<String>.splitByEntry(entry: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    var currentList = mutableListOf<String>()

    for (item in this) {
        if (item == entry) {
            if (currentList.isNotEmpty()) {
                result.add(currentList)
                currentList = mutableListOf()
            }
        } else {
            currentList.add(item)
        }
    }

    if (currentList.isNotEmpty()) {
        result.add(currentList)
    }

    return result
}