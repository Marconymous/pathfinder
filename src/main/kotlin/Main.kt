import classes.Cell
import classes.Point
import classes.Solution

fun main(args: Array<String>) {
//    launch<PathfinderApp>(args)

    val board = arrayOf(
        arrayOf(Cell.STRT, Cell.PATH, Cell.PATH, Cell.WALL, Cell.PATH, Cell.WALL, Cell.PATH, Cell.PATH),
        arrayOf(Cell.WALL, Cell.WALL, Cell.PATH, Cell.WALL, Cell.PATH, Cell.PATH, Cell.PATH, Cell.PATH),
        arrayOf(Cell.WALL, Cell.PATH, Cell.PATH, Cell.WALL, Cell.PATH, Cell.WALL, Cell.WALL, Cell.PATH),
        arrayOf(Cell.WALL, Cell.PATH, Cell.WALL, Cell.WALL, Cell.PATH, Cell.WALL, Cell.WALL, Cell.PATH),
        arrayOf(Cell.WALL, Cell.PATH, Cell.PATH, Cell.WALL, Cell.PATH, Cell.WALL, Cell.WALL, Cell.PATH),
        arrayOf(Cell.WALL, Cell.PATH, Cell.PATH, Cell.PATH, Cell.PATH, Cell.WALL, Cell.GOAL, Cell.PATH),
    )

    val algo = Algorithm(board)
    val solved = algo.solve()


    printSolution(solved)
}

fun printSolution(solution: Solution) {
    val height = solution.grid.size
    val width = solution.grid[0].size

    val show = Array(height) {
        Array(width) { "" }
    }

    for ((y, row) in solution.grid.withIndex()) {
        for ((x, cell) in row.withIndex()) {
            val s = when (cell) {
                -1 -> "X"
                else -> "."
            }
            show[y][x] = s
        }
    }

    for ((index, point) in solution.path.withIndex()) {
        val s: String = when (index) {
            0 -> "E"
            solution.path.size - 1 -> "S"
            else -> "☐"
        }

        show[point.y][point.x] = s
    }


    for (row in show) {
        println(row.contentToString())
    }
}