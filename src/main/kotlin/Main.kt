import androidx.compose.desktop.Window
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import classes.Board
import kotlin.math.min

fun main() = Window {
    val board = Board.generateRandom(10, 20)

    val algo = Algorithm(board)
    val solved = algo.solve()
    val view = solved.createView()

    println(view.contentDeepToString())

    MaterialTheme {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val cellHeight = size.height / view.size
            val cellWidth = size.width / view[0].size
            val sze = min(cellHeight, cellWidth)
            val cellSize = Size(sze, sze)

            for ((y, row) in view.withIndex()) {
                for ((x, cell) in row.withIndex()) {
                    val color = when (cell) {
                        "." -> Color.Green
                        "X" -> Color.Red
                        "*" -> Color.Blue
                        else -> Color.Black
                    }
                    drawRect(
                        color = color,
                        size = cellSize,
                        topLeft = Offset(x = cellSize.height * x, y = cellSize.width * y)
                    )
                }
            }
        }
    }
}