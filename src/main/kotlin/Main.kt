import classes.Cell
import classes.GUI
import tornadofx.App
import tornadofx.launch


class ViewGUI : App(GUI::class)

fun main(args: Array<String>) {
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

    launch<ViewGUI>(args)
}