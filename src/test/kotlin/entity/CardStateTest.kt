package entity

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Test cases for [CardState]
 */
class CardStateTest {
    /**
     * Tests the toString method of CardState
     */
    @Test
    fun testToString(){
        assertEquals("middle",Card(CardSuit.SPADES,CardValue.TWO,CardState.MIDDLE).state.toString())
        assertEquals("draw-stack",Card(CardSuit.SPADES,CardValue.TWO,CardState.DRAW_STACK).state.toString())
        assertEquals("on-player-hand",Card(CardSuit.SPADES,CardValue.TWO,CardState.ON_PLAYER_HAND).state.toString())
        assertEquals("out-of-game",Card(CardSuit.SPADES,CardValue.TWO,CardState.OUT_OF_GAME).state.toString())
    }
}