package view

import service.GameService
import tools.aqua.bgw.core.BoardGameApplication

class SwimmingApplication() : Refreshables,BoardGameApplication("SoPra Game") {

    private val gameService = GameService()
    private val startScene = StartScene(gameService)
    private val gameScene = GameScene(gameService)
    private val afterMoveScene = AfterMoveScene(gameService)
    private val endScene = EndScene(gameService)

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
        this.showMenuScene(endScene)
    }

    override fun refreshAfterStart() {
        this.hideMenuScene()
        gameScene.refreshHandCards()
        gameScene.refreshMiddleCards()
        gameScene.orderNames()
    }
    override fun refreshAfterNextPlayer() {
        this.showMenuScene(afterMoveScene)
        gameScene.refreshHandCards()
        gameScene.refreshMiddleCards()
        gameScene.refreshAfterKnocking()
        gameScene.orderNames()
    }
    override fun refreshAfterNextPlayerScene(){
        this.hideMenuScene()
    }
}

