package service

import entity.*
import java.util.*
import kotlin.test.*

/**
 * Test cases for [GameService]
 */
class GameServiceTest {

    private val deck = createDeck()

    private val player1 = Player("Peter")
    private val player2 = Player("Christiane")
    private val playerList = mutableListOf(player1,player2)

    private val gameService = GameService()

    @BeforeTest
    fun createDeck():MutableList<Card>{
        val deck = LinkedList<Card>()
        for(color in CardSuit.values()){
            for(value in CardValue.shortDeck()){
                deck.add(Card(color,value, CardState.DRAW_STACK))
            }
        }
        return deck
    }
    @BeforeTest
    fun addPlayersToList(){
        gameService.game.playerList.add(playerList[0])
        gameService.game.playerList.add(playerList[1])
    }

    @Test
    fun testIncreasePassCounter(){
        assertEquals(0,gameService.game.passCounter)
        gameService.increasePassCounter()
        assertEquals(1,gameService.game.passCounter)
        //Clean up for future tests
        gameService.setPassCounterToZero()
    }
    @Test
    fun testSetPassCounterToZero(){
        gameService.increasePassCounter()
        assertNotEquals(0,gameService.game.passCounter)
        gameService.setPassCounterToZero()
        assertEquals(0,gameService.game.passCounter)
    }

    @Test
    fun testHandOutCards(){
        assertNull(gameService.game.playerList[0])
        gameService.game.playerList[0].handCardList = gameService.handoutCards()
        assertEquals(deck[0],gameService.game.playerList[0].handCardList!![0])
        assertEquals(deck[1],gameService.game.playerList[0].handCardList!![1])
        assertEquals(deck[2],gameService.game.playerList[0].handCardList!![2])
    }


    @Test
    fun testBeginGame(){
        gameService.beginGame()
        assertEquals(gameService.game.playerList[0].handCardList,mutableListOf())

    }
}