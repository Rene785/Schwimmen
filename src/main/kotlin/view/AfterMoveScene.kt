package view

import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font

class AfterMoveScene : MenuScene() {
    private val startTurnButton = Button(
        posX = 710,
        posY = 600,
        width = 400,
        height = 150,
        text = "START TURN",
        font = Font(size = 40, fontWeight = Font.FontWeight.SEMI_BOLD)
    )

    private val waitLabel = Label(
        posX = 325,
        posY = 400,
        width = 1200,
        font = Font(size = 50, fontWeight = Font.FontWeight.SEMI_BOLD),
        text = "Wait for the next player and press START TURN"
    )

    init {
        addComponents(startTurnButton,waitLabel)
    }

}