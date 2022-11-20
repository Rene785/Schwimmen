package service

import entity.*
import java.util.*
import kotlin.test.*

/**
 * Test cases for [GameService]
 */
class GameServiceTest {

    private val deck = LinkedList<Card>()

    private val player1 = Player("Peter")
    private val player2 = Player("Christiane")
    private val playerList = LinkedList<Player>()


    private val gameService = GameService()

    /**
     * [createDeck] creates a short deck.
     */
    @BeforeTest
    fun createDeck(){
        for(color in CardSuit.values()){
            for(value in CardValue.shortDeck()){
                deck.add(Card(color,value, CardState.DRAW_STACK))
            }
        }
    }
    /**
     * Adds player to the player list
     */
    @BeforeTest
    fun addPlayers(){
        playerList.addAll(listOf(player1,player2))
    }
    /**
     * Tests whether the pass counter is increased when the method is called
     */
    @Test
    fun testIncreasePassCounter(){
        assertEquals(0,gameService.game.passCounter)
        gameService.increasePassCounter()
        assertEquals(1,gameService.game.passCounter)
        //Clean up for future tests
        gameService.setPassCounterToZero()
    }

    /**
     * Tests whether the pass counter is set to zero
     */
    @Test
    fun testSetPassCounterToZero(){
        gameService.increasePassCounter()
        assertNotEquals(0,gameService.game.passCounter)
        gameService.setPassCounterToZero()
        assertEquals(0,gameService.game.passCounter)
    }

    /**
     * Tests whether the cards are hand out correctly
     */
    @Test
    fun testHandOutCards(){
        assertNull(gameService.game.playerList[0].handCardList)
        gameService.game.playerList[0].handCardList = gameService.handoutCards()
        assertEquals(deck[3].value,gameService.game.playerList[0].handCardList!![0].value)
        assertEquals(deck[3].color,gameService.game.playerList[0].handCardList!![0].color)
    }

    /**
     * Tests whether the cards in the middle are set correctly
     */
    @Test
    fun testSetMiddleCards(){
        val oldMiddleCards = gameService.middleCards
        gameService.middleCards = gameService.setMiddleCards()
        assertNotEquals(gameService.middleCards, oldMiddleCards)
        assertEquals(deck[3].value, gameService.middleCards!![0].value)
        assertEquals(deck[3].color, gameService.middleCards!![0].color)
    }
    /**
     * Tests whether a game is beginning correctly
     */
    @Test
    fun testBeginGame(){
        gameService.beginGame(playerList)
        assertNotNull(gameService.game.playerList[0].handCardList)
        assertNotEquals(deck[0],gameService.game.deck[0])
    }

    /**
     * Tests the functionality of ending a game
     */
    @Test
    fun testEndGame(){
        gameService.beginGame(playerList)
        gameService.endGame()
        assertEquals(0,gameService.game.passCounter)
    }
}