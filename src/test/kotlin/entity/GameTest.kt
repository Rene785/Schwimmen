package entity

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/**
 * Test cases for [Game]
 */
class GameTest {
    //Initialize values to test with

    //Initialize hearts
    private var sevenOfHearts = Card(CardSuit.HEARTS,CardValue.SEVEN,CardState.DRAW_STACK)
    private var eightOfHearts = Card(CardSuit.HEARTS,CardValue.EIGHT,CardState.DRAW_STACK)
    private var nineOfHearts = Card(CardSuit.HEARTS,CardValue.NINE,CardState.DRAW_STACK)
    private var tenOfHearts = Card(CardSuit.HEARTS,CardValue.TEN,CardState.DRAW_STACK)
    private var jackOfHearts = Card(CardSuit.HEARTS,CardValue.JACK,CardState.DRAW_STACK)
    private var queenOfHearts = Card(CardSuit.HEARTS,CardValue.QUEEN,CardState.DRAW_STACK)
    private var kingOfHearts = Card(CardSuit.HEARTS,CardValue.KING,CardState.DRAW_STACK)
    private var aceOfHearts = Card(CardSuit.HEARTS,CardValue.ACE,CardState.DRAW_STACK)
    //Initialize diamonds
    private var sevenOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.SEVEN,CardState.DRAW_STACK)
    private var eightOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.EIGHT,CardState.DRAW_STACK)
    private var nineOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.NINE,CardState.DRAW_STACK)
    private var tenOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.TEN,CardState.DRAW_STACK)
    private var jackOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.JACK,CardState.DRAW_STACK)
    private var queenOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.QUEEN,CardState.DRAW_STACK)
    private var kingOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.KING,CardState.DRAW_STACK)
    private var aceOfDiamonds = Card(CardSuit.DIAMONDS,CardValue.ACE,CardState.DRAW_STACK)
    //Initialize spades
    private var sevenOfSpades = Card(CardSuit.SPADES,CardValue.SEVEN,CardState.DRAW_STACK)
    private var eightOfSpades = Card(CardSuit.SPADES,CardValue.EIGHT,CardState.DRAW_STACK)
    private var nineOfSpades = Card(CardSuit.SPADES,CardValue.NINE,CardState.DRAW_STACK)
    private var tenOfSpades = Card(CardSuit.SPADES,CardValue.TEN,CardState.DRAW_STACK)
    private var jackOfSpades = Card(CardSuit.SPADES,CardValue.JACK,CardState.DRAW_STACK)
    private var queenOfSpades = Card(CardSuit.SPADES,CardValue.QUEEN,CardState.DRAW_STACK)
    private var kingOfSpades = Card(CardSuit.SPADES,CardValue.KING,CardState.DRAW_STACK)
    private var aceOfSpades = Card(CardSuit.SPADES,CardValue.ACE,CardState.DRAW_STACK)
    //Initialize clubs
    private var sevenOfClubs = Card(CardSuit.CLUBS,CardValue.SEVEN,CardState.DRAW_STACK)
    private var eightOfClubs = Card(CardSuit.CLUBS,CardValue.EIGHT,CardState.DRAW_STACK)
    private var nineOfClubs = Card(CardSuit.CLUBS,CardValue.NINE,CardState.DRAW_STACK)
    private var tenOfClubs = Card(CardSuit.CLUBS,CardValue.TEN,CardState.DRAW_STACK)
    private var jackOfClubs = Card(CardSuit.CLUBS,CardValue.JACK,CardState.DRAW_STACK)
    private var queenOfClubs = Card(CardSuit.CLUBS,CardValue.QUEEN,CardState.DRAW_STACK)
    private var kingOfClubs = Card(CardSuit.CLUBS,CardValue.KING,CardState.DRAW_STACK)
    private var aceOfClubs = Card(CardSuit.CLUBS,CardValue.ACE,CardState.DRAW_STACK)
    //Initialize deck
    private val deck = arrayOf(sevenOfHearts,eightOfHearts,nineOfHearts,tenOfHearts,jackOfHearts,queenOfHearts,kingOfHearts,aceOfHearts,
        sevenOfDiamonds,eightOfDiamonds,nineOfDiamonds,tenOfDiamonds,jackOfDiamonds,queenOfDiamonds,kingOfDiamonds,aceOfDiamonds,
        sevenOfSpades,eightOfSpades,nineOfSpades,tenOfSpades,jackOfSpades,queenOfSpades,kingOfSpades,aceOfSpades,
        sevenOfClubs,eightOfClubs,nineOfClubs,tenOfClubs,jackOfClubs,queenOfClubs,kingOfClubs,aceOfClubs)
    //Initialize players
    private val player1 = Player("Peter",arrayOf(deck[0],deck[1],deck[2]))
    private val player2 = Player("Olivia", arrayOf(deck[29],deck[30],deck[31]))
    private val player3 = Player("Klaus", arrayOf(deck[14],deck[15],deck[16]))
    //Initialize game
    private val game = Game(listOf(player1,player2) as LinkedList<Player>,deck)

    /**
     * Tests the initialization for a game
     */
    @Test
    fun createGameTest(){
        assertEquals(game, Game(listOf(player1,player2) as LinkedList<Player>,deck))
        assertNotEquals(game, Game(listOf(player2,player1) as LinkedList<Player>,deck))
    }

    /**
     * Tests the get and set for a game
     */
    @Test
    fun getAndSetTest(){
        assertEquals(Game(listOf(player1,player2) as LinkedList<Player>,deck),game)
        game.playerList.add(player3)
        assertEquals(Game(listOf(player1,player2,player3) as LinkedList<Player>, deck),game)
    }
}