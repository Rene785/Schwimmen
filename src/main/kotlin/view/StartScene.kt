package view

import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class StartScene: MenuScene() {

    private val startButton = Button(
        posX = 500,
        posY = 800,
        width = 400,
        height = 150,
        text = "Start",
        font = Font(size = 20)
    )
    private val endButton = Button(
        posX = 1000,
        posY = 800,
        width = 400,
        height = 150,
        text = "End",
        font = Font(size = 20)
    )

    init{
        addComponents(startButton,endButton)
    }
}