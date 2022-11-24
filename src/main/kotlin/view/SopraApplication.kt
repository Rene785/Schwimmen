package view

import service.GameService
import tools.aqua.bgw.components.gamecomponentviews.TokenView
import tools.aqua.bgw.core.BoardGameApplication

class SopraApplication() : Refreshables,BoardGameApplication("SoPra Game") {

    private val gameService = GameService()
    private val startScene = StartScene(gameService)
    private val gameScene = GameScene()
    private val afterMoveScene = AfterMoveScene()
    private val endScene = EndScene()

    init {
        gameService.addRefreshable(this)
        gameService.addRefreshable(startScene)
        gameService.addRefreshable(gameScene)
        gameService.playerService.addRefreshable(this)
        gameService.playerService.addRefreshable(startScene)
        gameService.playerService.addRefreshable(gameScene)
        this.showGameScene(gameScene)
        this.showMenuScene(startScene)
    }

    override fun refreshScore() {
        TODO("Not yet implemented")
    }

    override fun refreshAfterStart() {
       this.hideMenuScene()
    }

}

