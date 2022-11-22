package view

import tools.aqua.bgw.components.gamecomponentviews.TokenView
import tools.aqua.bgw.core.BoardGameApplication

class SopraApplication : Refreshables,BoardGameApplication("SoPra Game") {

    private val helloScene = HelloScene()
    private val startScene = StartScene()
    private val gameScene = GameScene()
    private val afterMoveScene = AfterMoveScene()
    private val endScene = EndScene()

   // private val middleToken1 = TokenView()
    //private val middleImages = listOf()

    init {
        registerMenuEvents()
        setScene(0)
    }

    private fun setScene(x:Int){
        if(x == 0){ // Start Scene
            showGameScene(gameScene)
            showMenuScene(startScene)
        }else if(x == 1){ // Game Scene
            hideMenuScene()
        }else if(x == 2) { //After Move Scene
            showMenuScene(afterMoveScene)
        }else if(x == 3){ //End Scene
            showMenuScene(endScene)
        }
    }

    private fun registerMenuEvents() {

    }
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

