package service

import entity.Player
import org.junit.jupiter.api.Test
import java.util.*
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
            assertEquals(false,player.hasKnocked)
            playerService.knock(player)
        }
        for(player in gameService.game.playerList){
            assertEquals(true,player.hasKnocked)
        }
    }
}