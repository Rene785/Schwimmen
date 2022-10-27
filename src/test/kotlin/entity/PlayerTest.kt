package entity

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


/**
 * Test cases for [Player]
 */
class PlayerTest {

    /**
     * Tests the initialization of a player with valid information
     */
    @Test
    fun createPlayerOneTest(){
        //Initialize the test data
        val name = "René"
        val hasKnocked = false
        val handArray = arrayOf(Card(CardSuit.CLUBS,CardValue.ACE,CardState.ON_PLAYER_HAND),
                Card(CardSuit.CLUBS,CardValue.KING,CardState.ON_PLAYER_HAND),
                Card(CardSuit.CLUBS,CardValue.QUEEN,CardState.ON_PLAYER_HAND))
        val handArrayWithNull = null
        //Initialize players
        val player1 = Player(name,hasKnocked,handArray)
        val player2 = Player(name,hasKnocked,handArrayWithNull)
        //Test: Is name equal
        assertEquals("René",player1.name)
        assertEquals("René",player2.name)
        //Test: Is value of hasKnocked equal
        assertEquals(false,player1.hasKnocked)
        assertEquals(false,player2.hasKnocked)
        //Test: Is handArray equal
        assertEquals(arrayOf(Card(CardSuit.CLUBS,CardValue.ACE,CardState.ON_PLAYER_HAND),
            Card(CardSuit.CLUBS,CardValue.KING,CardState.ON_PLAYER_HAND),
            Card(CardSuit.CLUBS,CardValue.QUEEN,CardState.ON_PLAYER_HAND)),player1.handArr)
        assertEquals(null,player2.handArr)
    }

}