package entity

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
/**
 * Test cases for [Game]
 */
class GameTest {
    //Initialize values to test with
    //Initialize deck
    private val deck = LinkedList<Card>()
    //Initialize players
    private val player1 = Player("Peter",mutableListOf(deck[0],deck[1],deck[2]))
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
     * Tests the get and set for a game
     */
    @Test
    fun getAndSetTest(){
        assertEquals(Game(deck),game)
        game.playerList.add(player1)
        assertEquals(Game(deck),game)
    }
}