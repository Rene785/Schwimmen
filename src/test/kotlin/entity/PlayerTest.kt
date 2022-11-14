package entity

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


/**
 * Test cases for [Player]
 */
class PlayerTest {

    //Initialize the test cards
    private val aceOfClubs = Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)
    private val jackOfHearts = Card(CardSuit.HEARTS,CardValue.JACK,CardState.DRAW_STACK)
    private val queenOfSpades = Card(CardSuit.SPADES,CardValue.QUEEN,CardState.DRAW_STACK)
    private val kingOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.KING,CardState.DRAW_STACK)
    private val sevenOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.SEVEN,CardState.DRAW_STACK)
    private val eightOfHearts = Card(CardSuit.HEARTS,CardValue.EIGHT,CardState.DRAW_STACK)
    //Initialize the test players
    private val player1 = Player("Dieter", mutableListOf(aceOfClubs,jackOfHearts,queenOfSpades))
    private val player2 = Player("Sabrina", mutableListOf(kingOfDiamonds,sevenOfDiamonds,eightOfHearts))

    /**
     * Tests the initialization and the equals() function of a player
     */
    @Test
    fun createPlayerTest(){
        assertNotEquals(player1,Player("Sabrina",mutableListOf(aceOfClubs,jackOfHearts,queenOfSpades)))
        assertNotEquals(player2,Player("Sabrina",mutableListOf(aceOfClubs,jackOfHearts,queenOfSpades)))
    }

    /**
     * Tests the Get and Set method for hasKnocked
     */
    @Test
    fun getAndSetTest(){
        assertEquals(false,player1.hasKnocked)
        player1.hasKnocked = true
        assertNotEquals(false,player1.hasKnocked)
    }
}