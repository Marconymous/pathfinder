import classes.Cell
import classes.Point
import classes.Solution

fun main(args: Array<String>) {
//    launch<PathfinderApp>(args)

    val board = Cell.createCellArray(
        arrayOf(
            arrayOf("O", "O", "X", "O", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
            arrayOf("O", "E", "X", "O", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
            arrayOf("O", "X", "X", "X", "X", "O", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
            arrayOf("O", "O", "X", "O", "X", "S", "X", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
            arrayOf("O", "X", "X", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
            arrayOf("O", "O", "O", "X", "X", "X", "X", "O", "X", "O", "O", "O", "X", "O", "O", "O"),
            arrayOf("O", "O", "X", "O", "O", "O", "X", "O", "O", "O", "O", "X", "O", "O", "O", "O"),
            arrayOf("O", "O", "O", "O", "O", "O", "X", "O", "X", "O", "X", "X", "O", "O", "O", "O"),
            arrayOf("O", "O", "O", "O", "O", "O", "X", "O", "X", "O", "O", "O", "X", "O", "O", "O"),
            arrayOf("O", "O", "X", "X", "X", "X", "X", "O", "O", "O", "O", "O", "O", "X", "O", "O"),
            arrayOf("O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "X", "O", "O"),
            arrayOf("O", "O", "O", "X", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O", "X", "O"),
            arrayOf("O", "O", "O", "O", "X", "O", "X", "O", "O", "O", "O", "O", "O", "O", "X", "O"),
            arrayOf("O", "O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "O", "X", "O", "O"),
            arrayOf("O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "X", "X", "O", "O"),
            arrayOf("O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "X", "O", "O", "O"),
            arrayOf("O", "O", "O", "O", "O", "O", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O"),
            arrayOf("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
        )
    )

    val algo = Algorithm(board)
    val solved = algo.solve()

    Algorithm.createFile(solved.grid, "int.txt")
    Algorithm.createFile(solved.createView(), "solution.txt")
}