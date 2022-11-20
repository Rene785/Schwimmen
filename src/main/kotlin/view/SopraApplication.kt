package view

import tools.aqua.bgw.components.gamecomponentviews.TokenView
import tools.aqua.bgw.core.BoardGameApplication

class SopraApplication : Refreshables,BoardGameApplication("SoPra Game") {

    private val helloScene = HelloScene()
    private val startScene = StartScene()
    private val gameScene = GameScene()
    private val afterMoveScene = AfterMoveScene()

   // private val middleToken1 = TokenView()
    //private val middleImages = listOf()

    init {
        registerMenuEvents()
        this.showGameScene(gameScene)
        this.showMenuScene(afterMoveScene)
    }

    private fun registerMenuEvents() {}
    override fun refreshHandCards() {
        TODO("Not yet implemented")
    }

    override fun refreshMiddleCards() {
        TODO("Not yet implemented")
    }

    override fun refreshScore() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterKnocking() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterPass() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterStart() {
        TODO("Not yet implemented")
    }

    override fun refreshCreatePlayer() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterNextPlayer() {
        TODO("Not yet implemented")
    }

}

