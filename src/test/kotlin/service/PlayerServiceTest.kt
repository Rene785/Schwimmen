package service

import entity.Player
import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/**
 * Test cases for [PlayerService]
 */
class PlayerServiceTest {

    private val gameService = GameService()
    private val playerService = PlayerService(gameService)

    private val player1 = Player("Sabine")
    private val player2 = Player("Thomas")

    @Test
    fun testCreatePlayer(){
        assertNull(gameService.game.playerList)
        playerService.createPlayer("Christian")
        assertNotNull(gameService.game.playerList)
    }

    @BeforeTest
    fun addPlayers(){
        gameService.game.playerList.add(player1)
        gameService.game.playerList.add(player2)
    }
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