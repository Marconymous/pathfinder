package classes

import tornadofx.View
import tornadofx.gridpane
import tornadofx.label

class GUI : View() {
    override val root = gridpane {
        label("sus")
    }
}