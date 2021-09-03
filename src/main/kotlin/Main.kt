import classes.Point
import tornadofx.App

class PathfinderApp : App(PathfinderGUI::class, PathfinderStyle::class)

fun main(args: Array<String>) {
//    launch<PathfinderApp>(args)

    val board = Array(6) { Array(8) { false } }
    val algo = Algorithm(board)
    val solved = algo.solve(Point(0, 0), Point(5, 7))

    println(solved)
}