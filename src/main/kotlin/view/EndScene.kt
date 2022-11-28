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

/**
 * A [MenuScene], which shows the end result of the game.
 *
 * Shows which player ended up where on the ranking.
 *
 * @param gameService The [GameService] of the game
 */
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
        text = "2nd: No one",
        font = Font(size = 25, fontWeight = Font.FontWeight.SEMI_BOLD)
    )
    private val thirdLabel = Label(
        posX = 625, posY = 400,
        width = 600, height = 200,
        text = "3rd: No one",
        font = Font(size = 25, fontWeight = Font.FontWeight.SEMI_BOLD)
    )
    private val fourthLabel = Label(
        posX = 625, posY = 500,
        width = 600, height = 200,
        text = "4th: No one",
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
        showScore()
        addComponents(
            winnerLabel,secondLabel,thirdLabel,fourthLabel,
            newGameButton)
    }

    fun initScoreConfig(){
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
    fun showScore(){
        val players = gameService.game.playerList
        players.sortByDescending { player -> player.points  }
        var firstAndSecond = false
        var secondAndThird = false
        var thirdAndFourth = false
        when(players.size){
            2 -> {
                if(players[0].points == players[1].points) firstAndSecond = true
                if(firstAndSecond) {
                    winnerLabel.text = "${players[0].name} and ${players[1].name} have won with ${players[0].points} points!"
                }else{
                    winnerLabel.text = "${players[0].name} has won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[1].name} with ${players[1].points} points."
                }
            }
            3 -> {
                if (players[0].points == players[1].points) firstAndSecond = true
                if (players[1].points == players[2].points) secondAndThird = true
                if(firstAndSecond && secondAndThird) {
                    winnerLabel.text = "${players[0].name},${players[1].name} and " +
                            "${players[2].name} have won with ${players[0].points} points!"

                }else if (firstAndSecond){
                    winnerLabel.text = "${players[0].name} and ${players[1].name} have won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[2].name} with ${players[2].points} points."
                }else if(secondAndThird){
                    winnerLabel.text = "${players[0].name} has won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[1].name} and ${players[2].name} with ${players[2].points} points."
                }else{
                    winnerLabel.text = "${players[0].name} has won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[1].name} with ${players[1].points} points."
                    thirdLabel.text = "3rd: ${players[2].name} with ${players[2].points} points."
                }
            }
            4 -> {
                if (players[0].points == players[1].points) firstAndSecond = true
                if (players[1].points == players[2].points) secondAndThird = true
                if (players[2].points == players[3].points) thirdAndFourth = true
                if(firstAndSecond && secondAndThird && thirdAndFourth){
                    winnerLabel.text = "All players have won with ${players[0].points} points"
                }else if(firstAndSecond && secondAndThird) {
                    winnerLabel.text = "${players[0].name},${players[1].name} and " +
                            "${players[2].name} have won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[3].name} with ${players[3].points} points.\""
                }else if (firstAndSecond){
                    winnerLabel.text = "${players[0].name} and ${players[1].name} have won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[2].name} with ${players[2].points} points."
                    thirdLabel.text = "3rd: ${players[3].name} with ${players[3].points} points."
                }else if(secondAndThird){
                    winnerLabel.text = "${players[0].name} has won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[1].name} and ${players[2].name} with ${players[2].points} points."
                    thirdLabel.text = "3rd: ${players[3].name} with ${players[3].points} points."
                }else if(thirdAndFourth){
                    winnerLabel.text = "${players[0].name} has won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[1].name} with ${players[1].points} points."
                    thirdLabel.text = "3rd: ${players[2].name} and ${players[3].name} with ${players[2].points} points."
                }else{
                    winnerLabel.text = "${players[0].name} has won with ${players[0].points} points!"
                    secondLabel.text = "2nd: ${players[1].name} with ${players[1].points} points."
                    thirdLabel.text = "3rd: ${players[2].name} with ${players[2].points} points."
                    fourthLabel.text = "4th: ${players[3].name} with ${players[3].points} points."
                }
            }
        }
    }
}