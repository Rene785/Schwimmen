package entity

import java.util.LinkedList

/**
 * Entity class [Game] saves the current player, the pass counter, a list of the players and a card Array where all cards are saved in.
 * @constructor [Game] initializes the [deck].
 */
data class Game(var deck:MutableList<Card>){

    /**
     * List of all players
     */
    var playerList = LinkedList<Player>()
    /**
     * Counter to count how many times the players have passed in a row
     */
    var passCounter = 0
    /**
     * Integer to iterate over the player list to determine the current player
     */
    var currentPlayerIndex = 0

    /**
     * Method to get the current player
     */
    fun currentPlayer():Player{
        if(currentPlayerIndex >= playerList.size) currentPlayerIndex = 0
        return playerList[currentPlayerIndex]
    }
}

