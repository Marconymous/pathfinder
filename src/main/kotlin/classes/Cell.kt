package classes

enum class Cell(val value: Int) {
    WALL(-1),
    PATH(0),
    STRT(Int.MAX_VALUE),
    GOAL(Int.MIN_VALUE);
}