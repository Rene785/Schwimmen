package entity

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Test cases for [CardValue]
 */
class CardValueTest{
    /**
     * Tests the toString method of CardValue
     */
    @Test
    fun testToString(){
        assertEquals("2",Card(CardSuit.SPADES,CardValue.TWO,CardState.DRAW_STACK).value.toString())
        assertEquals("3",Card(CardSuit.SPADES,CardValue.THREE,CardState.DRAW_STACK).value.toString())
        assertEquals("4",Card(CardSuit.SPADES,CardValue.FOUR,CardState.DRAW_STACK).value.toString())
        assertEquals("5",Card(CardSuit.SPADES,CardValue.FIVE,CardState.DRAW_STACK).value.toString())
        assertEquals("6",Card(CardSuit.SPADES,CardValue.SIX,CardState.DRAW_STACK).value.toString())
        assertEquals("7",Card(CardSuit.SPADES,CardValue.SEVEN,CardState.DRAW_STACK).value.toString())
        assertEquals("8",Card(CardSuit.SPADES,CardValue.EIGHT,CardState.DRAW_STACK).value.toString())
        assertEquals("9",Card(CardSuit.SPADES,CardValue.NINE,CardState.DRAW_STACK).value.toString())
        assertEquals("10",Card(CardSuit.SPADES,CardValue.TEN,CardState.DRAW_STACK).value.toString())
        assertEquals("J",Card(CardSuit.SPADES,CardValue.JACK,CardState.DRAW_STACK).value.toString())
        assertEquals("Q",Card(CardSuit.SPADES,CardValue.QUEEN,CardState.DRAW_STACK).value.toString())
        assertEquals("K",Card(CardSuit.SPADES,CardValue.KING,CardState.DRAW_STACK).value.toString())
        assertEquals("A",Card(CardSuit.SPADES,CardValue.ACE,CardState.DRAW_STACK).value.toString())
    }
    /**
     * Tests the toInt method of CardValue
     */
    @Test
    fun testToInt(){
        assertEquals(2,Card(CardSuit.SPADES,CardValue.TWO,CardState.DRAW_STACK).value.toInt())
        assertEquals(3,Card(CardSuit.SPADES,CardValue.THREE,CardState.DRAW_STACK).value.toInt())
        assertEquals(4,Card(CardSuit.SPADES,CardValue.FOUR,CardState.DRAW_STACK).value.toInt())
        assertEquals(5,Card(CardSuit.SPADES,CardValue.FIVE,CardState.DRAW_STACK).value.toInt())
        assertEquals(6,Card(CardSuit.SPADES,CardValue.SIX,CardState.DRAW_STACK).value.toInt())
        assertEquals(7,Card(CardSuit.SPADES,CardValue.SEVEN,CardState.DRAW_STACK).value.toInt())
        assertEquals(8,Card(CardSuit.SPADES,CardValue.EIGHT,CardState.DRAW_STACK).value.toInt())
        assertEquals(9,Card(CardSuit.SPADES,CardValue.NINE,CardState.DRAW_STACK).value.toInt())
        assertEquals(10,Card(CardSuit.SPADES,CardValue.TEN,CardState.DRAW_STACK).value.toInt())
        assertEquals(10,Card(CardSuit.SPADES,CardValue.JACK,CardState.DRAW_STACK).value.toInt())
        assertEquals(10,Card(CardSuit.SPADES,CardValue.QUEEN,CardState.DRAW_STACK).value.toInt())
        assertEquals(10,Card(CardSuit.SPADES,CardValue.KING,CardState.DRAW_STACK).value.toInt())
        assertEquals(11,Card(CardSuit.SPADES,CardValue.ACE,CardState.DRAW_STACK).value.toInt())
    }
}