package view

import entity.Player
import service.GameService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.components.uicomponents.TextField
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual
import java.util.*
import kotlin.system.exitProcess

class StartScene(private val gameService: GameService): MenuScene(400,1080, background = ColorVisual.LIGHT_GRAY), Refreshables {

    private val playerList = LinkedList<Player>()

    private val p1Label = Label(
        width = 100, height = 35,
        posX = 20, posY = 125,
        text = "Player 1:"
    )

    private val p1Input: TextField = TextField(
        width = 200, height = 35,
        posX = 130, posY = 125,
        text = listOf("Homer", "Marge", "Bart", "Lisa", "Maggie").random()
    ).apply {
        onKeyTyped = {
            startButton.isDisabled = this.text.isBlank() || p2Input.text.isBlank()
        }
    }

    private val p2Label = Label(
        width = 100, height = 35,
        posX = 20, posY = 170,
        text = "Player 2:"
    )

    private val p2Input: TextField = TextField(
        width = 200, height = 35,
        posX = 130, posY = 170,
        text = listOf("Fry", "Bender", "Leela", "Amy", "Zoidberg").random()
    ).apply {
        onKeyTyped = {
            startButton.isDisabled = p1Input.text.isBlank() || this.text.isBlank()
        }
    }
    private val p3Label = Label(
        width = 100, height = 35,
        posX = 20, posY = 215,
        text = "Player 3:"
    )

    private val p3Input: TextField = TextField(
        width = 200, height = 35,
        posX = 130, posY = 215,
        prompt = "Name of Player 3"
    ).apply {
        this.isDisabled = true
    }
    private val p4Label = Label(
        width = 100, height = 35,
        posX = 20, posY = 260,
        text = "Player 4:"
    )

    private val p4Input: TextField = TextField(
        width = 200, height = 35,
        posX = 130, posY = 260,
        prompt = "Name of Player 4"
    ).apply {
        this.isDisabled = true
    }

    private val plusOrMinusP3 = Button(
        posX = 350, posY = 215,
        width = 35, height = 35,
        text = "+", font = Font(size = 20,fontWeight = Font.FontWeight.SEMI_BOLD)
    ).apply {
        onMouseClicked = {
            if(this.text == "+"){
                p3Input.isDisabled = false
                this.text = "-"
                this.font = Font(size = 25,fontWeight = Font.FontWeight.SEMI_BOLD)
            }else if(this.text == "-"){
                p3Input.isDisabled = true
                if(p3Input.text.isNotBlank()) p3Input.text = ""
                this.text = "+"
                this.font = Font(size = 20,fontWeight = Font.FontWeight.SEMI_BOLD)
                plusOrMinusP4.isDisabled = true
            }
        }
    }

    private val plusOrMinusP4 = Button(
        posX = 350, posY = 260,
        width = 35, height = 35,
        text = "+", font = Font(size = 20, fontWeight = Font.FontWeight.SEMI_BOLD),
    ).apply {
        onMouseClicked = {
            if(this.text == "+"){
                p4Input.isDisabled = false
                this.text = "-"
                this.font = Font(size = 25,fontWeight = Font.FontWeight.SEMI_BOLD)
            }else if(this.text == "-"){
                p4Input.isDisabled = true
                if(p4Input.text.isNotBlank()) p4Input.text = ""
                this.text = "+"
                this.font = Font(size = 20,fontWeight = Font.FontWeight.SEMI_BOLD)
            }
        }
    }

    private val headlineLabel = Label(
        width = 300,
        height = 50,
        posX = 50,
        posY = 50,
        text = "Start New Game",
        font = Font(size = 24)
    )

    private val startButton = Button(
        posX = 80,
        posY = 350,
        width = 100,
        height = 50,
        text = "Start",
        font = Font(size = 20, fontWeight = Font.FontWeight.BOLD),
        visual = ColorVisual(0,255,0,170)
    ).apply {
        onMouseClicked = {
            check(p1Input.text.isNotBlank() || p2Input.text.isNotBlank()){"Not all players have names"}
            check(!p3Input.isDisabled && p3Input.text.isNotBlank() || p3Input.isDisabled){"Player 3 is missing a name"}
            check(!p4Input.isDisabled && p4Input.text.isNotBlank() || p4Input.isDisabled){"Player 4 is missing a name"}
            playerList += Player(p1Input.text.trim())
            playerList += Player(p2Input.text.trim())
            if(!p3Input.isDisabled) playerList += Player(p3Input.text.trim())
            if(!p4Input.isDisabled) playerList += Player(p4Input.text.trim())
            gameService.beginGame(playerList)
        }
    }
    private val endButton = Button(
        posX = 230,
        posY = 350,
        width = 100,
        height = 50,
        text = "End",
        font = Font(size = 20, fontWeight = Font.FontWeight.BOLD),
        visual = ColorVisual(255,0,0,170)
    ).apply {
        onMouseClicked = {
            exitProcess(0)
        }
    }



    init {
        addComponents(
            startButton, endButton,
            headlineLabel,
            p1Label, p1Input,
            p2Label, p2Input,
            p3Label, p3Input,
            p4Label, p4Input,
            plusOrMinusP3, plusOrMinusP4
        )
    }
}