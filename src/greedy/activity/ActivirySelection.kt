package greedy.activity

class ActivitySelection {
    companion object {
        fun schedule(activities: List<Activity>) {
            if (activities.isEmpty()) return

            val sortedActivities = activities.sortedBy { it.end }

            println(sortedActivities)

            var prevActivity = sortedActivities[0]
            println("Recommended Activities:")
            println(prevActivity)

            for (activity in sortedActivities.drop(1)) {
                if (activity.start >= prevActivity.end) {
                    println(activity)
                    prevActivity = activity
                }
            }
        }
    }
}