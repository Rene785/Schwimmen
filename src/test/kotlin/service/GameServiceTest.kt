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
    private val playerList = mutableListOf(player1,player2)

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
     * Adds players to the player list
     */
    @BeforeTest
    fun addPlayersToList(){
        gameService.game.playerList.add(playerList[0])
        gameService.game.playerList.add(playerList[1])
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
        assertEquals(deck[0],gameService.game.playerList[0].handCardList!![0])
        assertEquals(deck[1],gameService.game.playerList[0].handCardList!![1])
        assertEquals(deck[2],gameService.game.playerList[0].handCardList!![2])
    }

    /**
     * Tests whether a game is beginning correctly
     */
    @Test
    fun testBeginGame(){
        gameService.beginGame()
        assertNull(gameService.game.playerList[0].handCardList)
        assertNotEquals(deck[0],gameService.game.deck[0])
    }
}