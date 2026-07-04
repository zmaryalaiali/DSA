package greedy.activity

fun main() {
    val list = listOf<Activity>(
        Activity("A1", 0, 6),
        Activity("A2", 3, 4),
        Activity("A3", 1, 2),
        Activity("A4", 5, 8),
        Activity("A5", 5, 7),
        Activity("A6", 8, 9)
    )

    ActivitySelection.schedule(list)
}