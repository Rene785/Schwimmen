package entity

import java.util.LinkedList

/**
 * Entity class [Game] saves the current player, the pass counter, a list of the players and a card Array where all cards are saved in.
 * @constructor [Game] initializes the [cardList].
 * @param cardList A Mutable List of all cards in the Deck.
 */
data class Game(var cardList:MutableList<Card>){
    /**
     * List of all players
     */
    var playerList = LinkedList<Player>()
    /**
     * Counter to count how many times the players have passed in a row
     */
    var passCounter = 0
    /**
     * Iterator to iterate over the player list to determine the current player
     */
    var currentPlayer = playerList.iterator()
}

