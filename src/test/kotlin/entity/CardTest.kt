package entity

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Test cases for [Card]
 */
class CardTest {

    /**
     * Tests the initialization for a card with valid information
     */
    @Test
    fun createCardOneTest(){
        //Initialize the test data
        val color = CardSuit.CLUBS
        val value = CardValue.ACE
        val state = CardState.DRAW_STACK
        //Initialize the card which is to be tested
        val card = Card(color,value,state)
        //Test: Is the color equal
        assertEquals(CardSuit.CLUBS,card.color)
        //Test: Is the value equal and is it numerically correct
        assertEquals(CardValue.ACE,card.value)
        assertEquals("A",card.value.toString())
        //Test: Is the state correct
        assertEquals(CardState.DRAW_STACK,card.state)
    }
}