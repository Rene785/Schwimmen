package entity

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/**
 * Test cases for [Card]
 */
class CardTest {
    //Initialize cards which is to be tested with
    private val aceOfClubs = Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)
    private val jackOfHearts = Card(CardSuit.HEARTS,CardValue.JACK,CardState.ON_PLAYER_HAND)
    private val queenOfSpades = Card(CardSuit.SPADES,CardValue.QUEEN,CardState.OUT_OF_GAME)
    private val kingOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.KING,CardState.MIDDLE)

    /**
     * Tests the initialization for a card with valid information
     */
    @Test
    fun createCardTest(){
        assertEquals(Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK),aceOfClubs)
        assertEquals(Card(CardSuit.HEARTS,CardValue.JACK,CardState.ON_PLAYER_HAND),jackOfHearts)
        assertEquals(Card(CardSuit.SPADES,CardValue.QUEEN,CardState.OUT_OF_GAME),queenOfSpades)
        assertEquals(Card(CardSuit.DIAMONDS,CardValue.KING,CardState.MIDDLE),kingOfDiamonds)
        assertNotEquals(Card(CardSuit.CLUBS,CardValue.ACE,CardState.ON_PLAYER_HAND),aceOfClubs)
        assertNotEquals(Card(CardSuit.CLUBS,CardValue.JACK,CardState.ON_PLAYER_HAND),jackOfHearts)
        assertNotEquals(Card(CardSuit.SPADES,CardValue.SEVEN,CardState.OUT_OF_GAME),queenOfSpades)
        assertNotEquals(Card(CardSuit.CLUBS,CardValue.KING,CardState.MIDDLE),kingOfDiamonds)
    }
    /**
     * Tests the equals() function
     */
    @Test
    fun equalsTest(){
        assert(aceOfClubs.equals(Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)))
        assert(aceOfClubs.equals(Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)))
        assert(aceOfClubs.equals(Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)))
        assert(aceOfClubs.equals(Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)))
    }

    /**
     * Tests the toString method of Card
     */
    @Test
    fun testToString(){
        assertEquals("♣10on-player-hand",Card(CardSuit.CLUBS,CardValue.TEN,CardState.ON_PLAYER_HAND).toString())
    }

}