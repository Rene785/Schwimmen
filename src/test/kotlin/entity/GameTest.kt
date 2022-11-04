package entity

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/**
* Test cases for [Game]
*/
class GameTest {

    //Initialize the test cards
    private val aceOfClubs = Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)
    private val jackOfHearts = Card(CardSuit.HEARTS,CardValue.JACK,CardState.DRAW_STACK)
    private val queenOfSpades = Card(CardSuit.SPADES,CardValue.QUEEN,CardState.DRAW_STACK)
    private val kingOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.KING,CardState.DRAW_STACK)
    private val sevenOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.SEVEN,CardState.DRAW_STACK)
    private val eightOfHearts = Card(CardSuit.HEARTS,CardValue.EIGHT,CardState.DRAW_STACK)
    //Initialize the test players
    private val player1 = Player("Dieter", arrayOf(aceOfClubs,jackOfHearts,queenOfSpades))
    private val player2 = Player("Sabrina", arrayOf(kingOfDiamonds,sevenOfDiamonds,eightOfHearts))
    /**
     * Tests the initialization of a player with valid information
     */
    @Test
    fun createPlayerTest(){
        assertEquals(player1,Player("Dieter", arrayOf(aceOfClubs,jackOfHearts,queenOfSpades)))
        assertEquals(player2,Player("Sabrina", arrayOf(kingOfDiamonds,sevenOfDiamonds,eightOfHearts)))
        assertNotEquals(player1,Player("Sabrina",arrayOf(aceOfClubs,jackOfHearts,queenOfSpades)))
        assertNotEquals(player2,Player("Sabrina",arrayOf(aceOfClubs,jackOfHearts,queenOfSpades)))
    }

    /**
     *
     */

}