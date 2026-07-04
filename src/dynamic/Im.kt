package dynamic

class Im {
    companion object {
        @JvmStatic
        fun fibMemo(n: Int, hashMap: HashMap<Int, Int>): Int {
            if (n == 1) return 0
            if (n == 2) return 1
            if (!hashMap.containsKey(n)) {
                hashMap[n] = fibMemo(n - 1, hashMap) + fibMemo(n - 2, hashMap)
            }

            return hashMap[n]!!
        }

        fun fibTab(n: Int): Int {

            val list = mutableListOf<Int>()
            list.add(0)
            list.add(1)

            for (i in 2..<n) {
                val n1 = list[i - 1]
                val n2 = list[i - 2]
                list.add(n1 + n2)
            }
            return list[n - 1]
        }

        fun numberFactorTop(n: Int, array: IntArray): Int {
            if (n == 0 || n == 1 || n == 2) return 0
            if (n == 3) return 1
            if (array[n] == 0) {
                array[n] = n - 1 + n - 3 + n - 4
            }
            return array[n]
        }

        fun numberFactorDown(n: Int): Int {
            val array = IntArray(n + 1) { 0 }
            array[0] = 1
            array[1] = 1
            array[2] = 1
            array[3] = 2
            for (i in 4..n) {
                array[i] = array[i - 1] + array[i - 3] + array[i - 4]
            }
            return array[n]
        }
    }


}