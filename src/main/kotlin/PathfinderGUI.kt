import tornadofx.*

class PathfinderGUI : View(){
    override val root = gridpane {
        label {
            text = "Pathfinder"
            gridpaneConstraints {
                columnIndex = 1
                rowIndex = 1
            }
        }
    }
}

class PathfinderStyle : Stylesheet() {
    init {
        label {
            fontSize = 30.px
        }
    }
}