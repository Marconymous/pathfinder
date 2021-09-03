import classes.Point

class Algorithm(private val board: Array<Array<Boolean>>) {
    private val intBoard = Array(board.size) {
        Array(board[0].size) {
            0
        }
    }

    fun solve(start: Point, end: Point): ArrayList<Point> {
        intBoard[start.y][start.x] = Int.MAX_VALUE
        intBoard[end.y][end.x] = Int.MIN_VALUE

        printBoards()

        var done = false
        var count = 0
        var lastPoints = arrayListOf(
            start
        )
        while (!done) {
            count++
            done = true

            val newLastPoints = arrayListOf<Point>()

            for (lp in lastPoints) {
                val positions = getNeighbors(lp)

                for (p in positions) {
                    if (!inArray(p)) continue

                    if (intBoard[p.y][p.x] == 0) {
                        newLastPoints.add(p)
                        done = false
                        intBoard[p.y][p.x] = count
                    }
                }
                lastPoints = newLastPoints
            }
        }

        printBoards()

        return backtrack(end)
    }

    private fun getNeighbors(point: Point): Array<Point> {
        return arrayOf(
            Point(point.y - 1, point.x),
            Point(point.y + 1, point.x),
            Point(point.y, point.x + 1),
            Point(point.y, point.x - 1),
        )
    }

    private fun inArray(point: Point): Boolean {
        return !(point.y >= intBoard.size || point.y < 0 || point.x >= intBoard[0].size || point.x < 0)
    }

    private fun backtrack(end: Point): ArrayList<Point> {
        var current = end
        val path = arrayListOf<Point>()
        whileLoop@ while (true) {
            val neighbors = getNeighbors(current)

            var lowest = Int.MAX_VALUE
            var lowestPoint = Point(Int.MAX_VALUE, Int.MAX_VALUE)
            for (p in neighbors) {
                if (!inArray(p)) continue
                if (intBoard[p.y][p.x] == Int.MIN_VALUE) continue

                if (intBoard[p.y][p.x] == Int.MAX_VALUE) {
                    path.add(p)
                    break@whileLoop
                }

                println("current: ${lowest}; new: ${intBoard[p.y][p.x]}")
                if (intBoard[p.y][p.x] < lowest) {
                    lowest = intBoard[p.y][p.x]
                    lowestPoint = p
                }
            }


            current = lowestPoint
            path.add(lowestPoint)
        }

        return path
    }

    private fun printBoards() {
        println("-".repeat(board[0].contentToString().length))
        println("[")

        for (y in board.indices) {
            print("[")
            for (x in 0 until board[y].size) {
                print("${board[y][x]} -> ${intBoard[y][x]},")
            }
            print("],\n")
        }

        println("]")
        println("-".repeat(board[0].contentToString().length))
    }
}