package service

import entity.*
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * Test cases for [PlayerService]
 */
class PlayerServiceTest {

    private val gameService = GameService()
    private val playerService = PlayerService(gameService)

    private val player1 = Player("Sabine")
    private val player2 = Player("Thomas")
    private val playerList = LinkedList<Player>()

    private val aceOfClubs = Card(CardSuit.CLUBS, CardValue.ACE, CardState.ON_PLAYER_HAND)
    private val jackOfHearts = Card(CardSuit.HEARTS, CardValue.JACK, CardState.ON_PLAYER_HAND)
    private val queenOfSpades = Card(CardSuit.SPADES, CardValue.QUEEN, CardState.ON_PLAYER_HAND)
    private val kingOfDiamonds = Card(CardSuit.DIAMONDS, CardValue.KING, CardState.MIDDLE)
    private val sevenOfDiamonds = Card(CardSuit.DIAMONDS, CardValue.SEVEN, CardState.MIDDLE)
    private val eightOfHearts = Card(CardSuit.HEARTS, CardValue.EIGHT, CardState.MIDDLE)
    /**
     * Adds player to player list
     */
    @BeforeTest
    fun addPlayers(){
        playerList.addAll(listOf(player1,player2))
    }
    /**
     * Tests whether a player is created and added correctly
     */
    @Test
    fun testCreatePlayer(){
        assertEquals(LinkedList(), gameService.game.playerList)
        playerService.createPlayer("Christian")
        assertNotNull(gameService.game.playerList)
    }



    /**
     * Tests if the functionality of a player knocking is implemented correctly
     */
    @Test
    fun testHasKnocked(){
        for(player in gameService.game.playerList){
            assertEquals(false,playerService.hasKnocked(player))
            playerService.knock(player)
        }
        for(player in gameService.game.playerList){
            assertEquals(true,playerService.hasKnocked(player))
        }
    }

    /**
     * Tests if three hand cards and the middle cards are changed correctly
     */
    @Test
    fun testExchangeAllCards() {
        player1.handCardList = LinkedList<Card>()
        player1.handCardList!!.add(aceOfClubs)
        player1.handCardList!!.add(jackOfHearts)
        player1.handCardList!!.add(queenOfSpades)
        gameService.middleCards!!.addAll(listOf(kingOfDiamonds,sevenOfDiamonds,eightOfHearts))
        playerService.exchangeAllCards(player1)
        assertEquals(CardState.MIDDLE, aceOfClubs.state)
        assertEquals(CardState.MIDDLE, jackOfHearts.state)
        assertEquals(CardState.MIDDLE, queenOfSpades.state)
        assertEquals(CardState.ON_PLAYER_HAND, kingOfDiamonds.state)
        assertEquals(CardState.ON_PLAYER_HAND, sevenOfDiamonds.state)
        assertEquals(CardState.ON_PLAYER_HAND, eightOfHearts.state)
    }

    /**
     * Tests if one card is changed correctly
     */
    @Test
    fun testExchangeOneCard(){
        gameService.game.playerList.add(player1)
        gameService.beginGame(playerList)
        val middleCard = gameService.middleCards!![1]
        val handCard = gameService.game.playerList[0].handCardList!![1]
        playerService.exchangeOneCard(handCard,middleCard,player1)
        assertEquals(CardState.ON_PLAYER_HAND,middleCard.state)
        assertEquals(CardState.MIDDLE, handCard.state)
    }
}