package view

import entity.CardState
import service.CardImageLoader
import service.GameService
import tools.aqua.bgw.components.container.LinearLayout
import tools.aqua.bgw.components.gamecomponentviews.CardView
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.Alignment
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual
import tools.aqua.bgw.visual.ImageVisual
import java.awt.Color
import java.util.*
import javax.imageio.ImageIO

/**
 * A [BoardGameScene], which shows the Game Scene.
 *
 * Shows middle cards, hand cards, player labels, the deck, and a pass counter
 * Handles every Event.
 *
 * @param gameService The [GameService] of the game
 */
class GameScene(private val gameService:GameService): BoardGameScene(width = 1920, height = 1080,background = ColorVisual(108, 168, 59)),Refreshables {

    private var middleSelect = -1
    private var handSelect = -1

    private val passLabel = Label(
        height = 100,
        width = 400,
        text = "Pass Counter:${gameService.game.passCounter}",
        font = Font(size = 30, fontWeight = Font.FontWeight.SEMI_BOLD, color = Color.WHITE)
    )

    private val drawStack = CardView(
        height = 200,
        width = 130,
        posX = 480,
        posY = 385,
        front = ImageVisual(CardImageLoader().backImage)
    )
    private val drawStackLabel = Label(
        posX = 495,
        posY = 560,
        height = 100,
        width = 100,
        text = gameService.game.deck.filter { card -> card.state == CardState.DRAW_STACK }.size.toString(),
        font = Font(size = 22, fontWeight = Font.FontWeight.SEMI_BOLD, color = Color.WHITE)
    )

    private val middleCards = LinearLayout<CardView>(
        height = 220,
        width = 600,
        posX = 650,
        posY = 375,
        spacing = 0,
        alignment = Alignment.CENTER,
        visual = ColorVisual(255, 255, 255, 50)
    )
    private val middleCardOne = CardView(
        height = 200,
        width = 130,
        posX = 730,
        posY = 385,
        front = ImageVisual(CardImageLoader().blankImage)
    ).apply {
        onMouseClicked = {
            handleMiddleCardSelection(0)
        }
    }
    private val middleCardTwo = CardView(
        height = 200,
        width = 130,
        posX = 880,
        posY = 385,
        front = ImageVisual(CardImageLoader().blankImage)
    ).apply {
        onMouseClicked = {
            handleMiddleCardSelection(1)
        }
    }
    private val middleCardThree = CardView(
        height = 200,
        width = 130,
        posX = 1030,
        posY = 385,
        front = ImageVisual(CardImageLoader().blankImage)
    ).apply {
        onMouseClicked = {
            handleMiddleCardSelection(2)
        }
    }

    private val currentPlayerCards= LinearLayout<CardView>(
        height = 220,
        width = 600,
        posX = 650,
        posY = 750,
        spacing = 0,
        alignment = Alignment.CENTER,
        visual = ColorVisual(255, 255, 255, 50)
    )
    private val handCardOne = CardView(
        height = 200,
        width = 130,
        posX = 730,
        posY = 760,
        front = ImageVisual(CardImageLoader().blankImage)
    ).apply {
        onMouseClicked = {
            handleHandCardSelection(0)
        }
    }
    private val handCardTwo = CardView(
        height = 200,
        width = 130,
        posX = 880,
        posY = 760,
        front = ImageVisual(CardImageLoader().blankImage)
    ).apply {
        onMouseClicked = {
            handleHandCardSelection(1)
        }
    }
    private val handCardThree = CardView(
        height = 200,
        width = 130,
        posX = 1030,
        posY = 760,
        front = ImageVisual(CardImageLoader().blankImage)
    ).apply {
        onMouseClicked = {
            handleHandCardSelection(2)
        }
    }
    private val currentPlayerLabel = Label(
        posX = 800,
        posY = 950,
        height = 100,
        width = 300,
        text = "Player 1 Name",
        font = Font(size = 22, fontWeight = Font.FontWeight.SEMI_BOLD, color = Color.WHITE)
    )
    private val leftPlayerLabel = Label(
        posX = 0,
        posY = 450,
        height = 100,
        width = 300,
        text = "Player 2 Name",
        font = Font(size = 22, fontWeight = Font.FontWeight.SEMI_BOLD, color = Color.WHITE)
    )
    private val topPlayerLabel = Label(
        posX = 800,
        posY = 0,
        height = 100,
        width = 300,
        text = "Player 3 Name",
        font = Font(size = 22, fontWeight = Font.FontWeight.SEMI_BOLD, color = Color.WHITE)
    )
    private val rightPlayerLabel = Label(
        posX = 1600,
        posY = 450,
        height = 100,
        width = 300,
        text = "Player 4 Name",
        font = Font(size = 22, fontWeight = Font.FontWeight.SEMI_BOLD, color = Color.WHITE)
    )
    private val leftKnock = CardView(
        posX = 125,
        posY = 525,
        width = 50,
        height = 50,
        front = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/fist.png"))),
    ).apply {
        isVisible = false
    }
    private val topKnock = CardView(
        posX = 925,
        posY = 75,
        width = 50,
        height = 50,
        front = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/fist.png"))),
    ).apply {
        isVisible = false
    }
    private val rightKnock = CardView(
        posX = 1725,
        posY = 525,
        width = 50,
        height = 50,
        front = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/fist.png"))),
    ).apply {
        isVisible = false
    }
    private val currentKnock = CardView(
        posX = 925,
        posY = 1025,
        width = 50,
        height = 50,
        front = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/fist.png"))),
    ).apply {
        isVisible = false
    }
    private val passButton = Button(
        posX = 350,
        posY = 775,
        width = 250,
        height = 80,
        text = "Pass",
        font = Font(size = 35, color = Color.WHITE),
        visual = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/button.png")))
    ).apply {
        onMouseClicked = {
            gameService.playerService.pass()
        }
    }
    private val knockButton = Button(
        posX = 350,
        posY = 875,
        width = 250,
        height = 80,
        text = "Knock",
        font = Font(size = 35, color = Color.WHITE),
        visual = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/button.png")))
    ).apply {
        onMouseClicked = {
            gameService.playerService.knock()
        }
    }
    private val swapOneButton = Button(
        posX = 1300,
        posY = 775,
        width = 250,
        height = 80,
        text = "Swap One",
        font = Font(size = 35, color = Color.WHITE),
        visual = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/button.png")))
    ).apply {
        onMouseClicked = {
            check(middleSelect != -1 && handSelect != -1) { "Before swapping select the cards you want to swap" }
            gameService.playerService.exchangeOneCard(gameService.game.currentPlayer().handCardList!![handSelect],
                gameService.middleCards[middleSelect],
                gameService.game.currentPlayer())
            resetCardPositions()
        }
    }
    private val swapAllButton = Button(
        posX = 1300,
        posY = 875,
        width = 250,
        height = 80,
        text = "Swap All",
        font = Font(size = 35, color = Color.WHITE),
        visual = ImageVisual(ImageIO.read(CardImageLoader::class.java.getResource("/button.png")))
    ).apply {
        onMouseClicked = {
            gameService.playerService.exchangeAllCards(gameService.game.currentPlayer())
        }
    }
    init {
        addComponents(
            passLabel,
            drawStack,drawStackLabel,
            middleCards,middleCardOne,middleCardTwo,middleCardThree,
            currentPlayerCards,handCardOne,handCardTwo,handCardThree,
            currentPlayerLabel,leftPlayerLabel,topPlayerLabel,rightPlayerLabel,
            leftKnock,topKnock,rightKnock,currentKnock,
            passButton,knockButton,swapOneButton,swapAllButton,
        )
    }

    override fun refreshAfterPass() {
        passLabel.text = "Pass Counter:${gameService.game.passCounter}"
        refreshMiddleCards()
        refreshHandCards()
        refreshAfterKnocking()
        drawStackLabel.text = gameService.game.deck.filter { card -> card.state == CardState.DRAW_STACK }.size.toString()
    }

    override fun refreshHandCards() {
        val currentPlayer = gameService.game.currentPlayer().handCardList
        handCardOne.apply {
            currentSide = CardView.CardSide.FRONT
            frontVisual = ImageVisual(CardImageLoader().frontImageFor(currentPlayer!![0].color,currentPlayer[0].value))
        }
        handCardTwo.apply {
            currentSide = CardView.CardSide.FRONT
            frontVisual = ImageVisual(CardImageLoader().frontImageFor(currentPlayer!![1].color,currentPlayer[1].value))
        }
        handCardThree.apply {
            currentSide = CardView.CardSide.FRONT
            frontVisual = ImageVisual(CardImageLoader().frontImageFor(currentPlayer!![2].color,currentPlayer[2].value))
        }
        resetCardPositions()
    }

    override fun refreshMiddleCards() {
        val middle = gameService.middleCards
        middleCardOne.apply {
            currentSide = CardView.CardSide.FRONT
            frontVisual = ImageVisual(CardImageLoader().frontImageFor(middle[0].color,middle[0].value))
        }
        middleCardTwo.apply {
            currentSide = CardView.CardSide.FRONT
            frontVisual = ImageVisual(CardImageLoader().frontImageFor(middle[1].color,middle[1].value))
        }
        middleCardThree.apply {
            currentSide = CardView.CardSide.FRONT
            frontVisual = ImageVisual(CardImageLoader().frontImageFor(middle[2].color,middle[2].value))
        }
        resetCardPositions()
        drawStackLabel.text = gameService.game.deck.filter { card -> card.state == CardState.DRAW_STACK }.size.toString()
    }

    override fun refreshAfterKnocking() {
        val players = gameService.game.playerList
        val playerNameList = LinkedList<String>()
        players.forEach{ player -> playerNameList += player.name}
        when(players.size){
            2 -> {
                currentKnock.isVisible = false
                rightKnock.isVisible = false
                leftKnock.isVisible = false
                topKnock.isVisible = players[playerNameList.indexOf(topPlayerLabel.text)].hasKnocked
            }
            3 -> {
                currentKnock.isVisible = false
                topKnock.isVisible = false
                leftKnock.isVisible = players[playerNameList.indexOf(leftPlayerLabel.text)].hasKnocked
                rightKnock.isVisible = players[playerNameList.indexOf(rightPlayerLabel.text)].hasKnocked
            }
            4 -> {
                currentKnock.isVisible = false
                leftKnock.isVisible = players[playerNameList.indexOf(leftPlayerLabel.text)].hasKnocked
                topKnock.isVisible = players[playerNameList.indexOf(topPlayerLabel.text)].hasKnocked
                rightKnock.isVisible = players[playerNameList.indexOf(rightPlayerLabel.text)].hasKnocked
            }
        }

    }

    fun orderNames(){
        val playerAmount = gameService.game.playerList.size
        var index = gameService.game.currentPlayerIndex
        if(++index >= playerAmount){
            index = 0
        }
        when(playerAmount){
            2 -> {
                topPlayerLabel.text = gameService.game.playerList[index].name
                topPlayerLabel.isVisible = true
                rightPlayerLabel.isVisible = false
                leftPlayerLabel.isVisible = false
            }
            3 -> {
                leftPlayerLabel.text = gameService.game.playerList[index++].name
                if(index >= playerAmount) index = 0
                rightPlayerLabel.text = gameService.game.playerList[index].name
                topPlayerLabel.isVisible = false
                rightPlayerLabel.isVisible = true
                leftPlayerLabel.isVisible = true
            }
            4 -> {
                leftPlayerLabel.text = gameService.game.playerList[index++].name
                if(index >= playerAmount) index = 0
                topPlayerLabel.text = gameService.game.playerList[index++].name
                if(index >= playerAmount) index = 0
                rightPlayerLabel.text = gameService.game.playerList[index].name
                topPlayerLabel.isVisible = true
                rightPlayerLabel.isVisible = true
                leftPlayerLabel.isVisible = true
            }
        }
        currentPlayerLabel.text = gameService.game.currentPlayer().name
    }
    private fun handleMiddleCardSelection(cardNumber: Int){
        when(middleSelect){
            -1 -> {
                when(cardNumber){
                    0 -> middleCardOne.posY -= 25
                    1 -> middleCardTwo.posY -= 25
                    2 -> middleCardThree.posY -= 25
                }
            }
            0 -> {
                when(cardNumber){
                    0 -> {}
                    1 -> {
                        middleCardOne.posY += 25
                        middleCardTwo.posY -= 25
                    }
                    2 -> {
                        middleCardOne.posY += 25
                        middleCardThree.posY -= 25
                    }
                }
            }
            1 -> {
                when(cardNumber){
                    0 -> {
                        middleCardOne.posY -= 25
                        middleCardTwo.posY += 25
                    }
                    1 -> {}
                    2 -> {
                        middleCardTwo.posY += 25
                        middleCardThree.posY -= 25
                    }
                }
            }
            2 -> {
                when(cardNumber){
                    0 -> {
                        middleCardOne.posY -= 25
                        middleCardThree.posY += 25}
                    1 -> {
                        middleCardTwo.posY -= 25
                        middleCardThree.posY += 25
                    }
                    2 -> {}
                }
            }
        }
        middleSelect = cardNumber
    }
    private fun handleHandCardSelection(cardNumber: Int){
        when(handSelect){
            -1 -> {
                when(cardNumber){
                    0 -> handCardOne.posY -= 25
                    1 -> handCardTwo.posY -= 25
                    2 -> handCardThree.posY -= 25
                }
            }
            0 -> {
                when(cardNumber){
                    0 -> {}
                    1 -> {
                        handCardOne.posY += 25
                        handCardTwo.posY -= 25
                    }
                    2 -> {
                        handCardOne.posY += 25
                        handCardThree.posY -= 25
                    }
                }
            }
            1 -> {
                when(cardNumber){
                    0 -> {
                        handCardOne.posY -= 25
                        handCardTwo.posY += 25
                    }
                    1 -> {}
                    2 -> {
                        handCardTwo.posY += 25
                        handCardThree.posY -= 25
                    }
                }
            }
            2 -> {
                when(cardNumber){
                    0 -> {
                        handCardOne.posY -= 25
                        handCardThree.posY += 25}
                    1 -> {
                        handCardTwo.posY -= 25
                        handCardThree.posY += 25
                    }
                    2 -> {}
                }
            }
        }
        handSelect = cardNumber
    }
    private fun resetCardPositions() {
        middleCardOne.posY = 385.0
        middleCardTwo.posY = 385.0
        middleCardThree.posY = 385.0
        handCardOne.posY = 760.0
        handCardTwo.posY = 760.0
        handCardThree.posY = 760.0
        handSelect = -1
        middleSelect = -1
    }
}