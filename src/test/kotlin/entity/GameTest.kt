package entity

import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
/**
 * Test cases for [Game]
 */
class GameTest {
    //Initialize values to test with
    //Initialize deck
    private var deck = mutableListOf<Card>()
    //Initialize game
    private val game = Game(deck)

    /**
     * Initializes deck
     */
    @BeforeTest
    fun initDeck(){
        for(color in CardSuit.values()){
            for(value in CardValue.shortDeck()){
                deck.add(Card(color,value,CardState.DRAW_STACK))
            }
        }
    }
    /**
     * Tests whether the passCounter is set correctly
     */
    @Test
    fun testPassCounter(){
        assertEquals(0,game.passCounter)
        game.passCounter++
        assertEquals(1,game.passCounter)
    }
    /**
     * Tests whether the currentPlayerIndex is set correctly
     */
    @Test
    fun testCurrentPlayerIndex(){
        assertEquals(0,game.currentPlayerIndex)
        game.currentPlayerIndex++
        assertEquals(1,game.currentPlayerIndex)
    }
    /**
     * Tests whether the currentPlayer is set correctly
     */
    @Test
    fun testCurrentPlayer(){
        val player1 = Player("Peter", mutableListOf(deck[0],deck[1],deck[2]))
        game.playerList.add(player1)
        assertEquals(player1,game.currentPlayer())
    }
    /**
     * Tests the get and set for a game
     */
    @Test
    fun getAndSetTest(){
        val player1 = Player("Peter", mutableListOf(deck[0],deck[1],deck[2]))
        assertEquals(Game(deck),game)
        game.playerList.add(player1)
        assertEquals(Game(deck),game)
    }
}