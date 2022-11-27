package view

import service.CardImageLoader
import service.GameService
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual
import tools.aqua.bgw.visual.ImageVisual
import java.awt.Color
import javax.imageio.ImageIO

class EndScene(private val gameService: GameService): MenuScene(1920,1080, background = ColorVisual.LIGHT_GRAY),Refreshables {

    private val winnerLabel = Label(
        posX = 625, posY = 200,
        width = 600, height = 200,
        text = "Player and OtherPlayer have won with x points!!!",
        font = Font(size = 25, fontWeight = Font.FontWeight.SEMI_BOLD)
    )
    private val secondLabel = Label(
        posX = 625, posY = 300,
        width = 600, height = 200,
        text = "2nd: Player and OtherPlayer with x points",
        font = Font(size = 25, fontWeight = Font.FontWeight.SEMI_BOLD)
    )
    private val thirdLabel = Label(
        posX = 625, posY = 400,
        width = 600, height = 200,
        text = "3rd: Player and OtherPlayer with x points",
        font = Font(size = 25, fontWeight = Font.FontWeight.SEMI_BOLD)
    )
    private val fourthLabel = Label(
        posX = 625, posY = 500,
        width = 600, height = 200,
        text = "4th: Player and OtherPlayerwith x points",
        font = Font(size = 25, fontWeight = Font.FontWeight.SEMI_BOLD)
    )
    val newGameButton = Label(
        posX = 775, posY = 700,
        width = 300, height = 100,
        text = "New Game",
        font = Font(size = 35, color = Color.WHITE),
        visual = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/button.png")))
    )
    init {
        initScoreConfig()
        addComponents(
            winnerLabel,secondLabel,thirdLabel,fourthLabel,
            newGameButton)
    }

    private fun initScoreConfig(){
        when(gameService.game.playerList.size){
            2 -> {
                winnerLabel.isVisible = true
                secondLabel.isVisible = true
                thirdLabel.isVisible = false
                fourthLabel.isVisible = false
            }
            3 -> {
                winnerLabel.isVisible = true
                secondLabel.isVisible = true
                thirdLabel.isVisible = true
                fourthLabel.isVisible = false
            }
            4 -> {
                winnerLabel.isVisible = true
                secondLabel.isVisible = true
                thirdLabel.isVisible = true
                fourthLabel.isVisible = true
            }
        }
    }
}