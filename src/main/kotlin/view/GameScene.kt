package view

import tools.aqua.bgw.components.container.CardStack
import tools.aqua.bgw.components.container.LinearLayout
import tools.aqua.bgw.components.gamecomponentviews.CardView
import tools.aqua.bgw.components.uicomponents.Orientation
import tools.aqua.bgw.core.Alignment
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.visual.ColorVisual

class GameScene: BoardGameScene(width = 1920, height = 1080,background = ColorVisual(108, 168, 59)),Refreshables {

    private val drawStack: CardStack<CardView> = CardStack(
        height = 200,
        width = 130,
        posX = 480,
        posY = 385,
        visual = ColorVisual(255, 255, 255, 50)
    )

    private val middleCards: LinearLayout<CardView> = LinearLayout(
        height = 220,
        width = 600,
        posX = 650,
        posY = 375,
        spacing = 0,
        alignment = Alignment.CENTER,
        visual = ColorVisual(255, 255, 255, 50)
    )
    private val currentPlayerCards: LinearLayout<CardView> = LinearLayout(
        height = 220,
        width = 600,
        posX = 650,
        posY = 750,
        spacing = 0,
        alignment = Alignment.CENTER,
        visual = ColorVisual(255, 255, 255, 50)
    )
    val leftPlayerCards: LinearLayout<CardView> = LinearLayout<CardView>(
        height = 600,
        width = 220,
        posX = 50,
        posY = 200,
        spacing = 0,
        alignment = Alignment.CENTER,
        orientation = Orientation.VERTICAL,
        visual = ColorVisual(255, 255, 255, 50)
    ).apply {
        rotation = 180.0
    }
    val upPlayerCards: LinearLayout<CardView> = LinearLayout<CardView>(
        height = 220,
        width = 600,
        posX = 650,
        posY = 50,
        spacing = 0,
        alignment = Alignment.CENTER,
        visual = ColorVisual(255, 255, 255, 50)
    ).apply {
        rotation = 180.0
    }
    val rightPlayerCards: LinearLayout<CardView> = LinearLayout<CardView>(
        height = 600,
        width = 220,
        posX = 1650,
        posY = 200,
        spacing = 0,
        alignment = Alignment.CENTER,
        orientation = Orientation.VERTICAL,
        visual = ColorVisual(255, 255, 255, 50)
    ).apply {
        rotation = 180.0
    }

    init {
        addComponents(
            drawStack,
            middleCards,
            currentPlayerCards,
            leftPlayerCards,
            upPlayerCards,
            rightPlayerCards
        )
    }

    override fun refreshAfterNextPlayer() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterPass() {
        TODO("Not yet implemented")
    }

    override fun refreshHandCards() {
        TODO("Not yet implemented")
    }

    override fun refreshMiddleCards() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterKnocking() {
        TODO("Not yet implemented")
    }

    override fun refreshCreatePlayer() {
        TODO("Not yet implemented")
    }
}