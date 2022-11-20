package view

import tools.aqua.bgw.core.BoardGameApplication

class SopraApplication : BoardGameApplication("SoPra Game") {

    private val helloScene = HelloScene()
    private val startScene = StartScene()
    private val gameScene = GameScene()

    init {
        this.showGameScene(gameScene)
    }

}

