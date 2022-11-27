package entity

import java.util.LinkedList

/**
 * Entity class [Game] saves the current player, the pass counter, a list of the players and a card Array where all cards are saved in.
 * @constructor [Game] initializes the [deck].
 */
class Game(var deck:LinkedList<Card>){

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
     * Integer to save the remaining amount of cards in the deck
     */
    var deckSize = deck.size

    /**
     * Method to calculate all remaining cards in the deck
     */
    fun calculateDeckSize(){
        for(card in deck){
            if(card.state == CardState.DRAW_STACK) deckSize++
        }
    }

    /**
     * Method to get the current player
     */
    fun currentPlayer():Player{
        if(currentPlayerIndex >= playerList.size) currentPlayerIndex = 0
        return playerList[currentPlayerIndex]
    }
}

