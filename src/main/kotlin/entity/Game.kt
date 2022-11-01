package entity

/**
 * Entity class [Game] saves the current player, the pass counter, a list of the players and a card Array where all cards are saved in.
 * @constructor [Game] initializes the [playerList],[cardArr].
 * @param playerList is the list of all players participating in the round.
 * @param cardArr is an Array of all cards in the Deck.
 */
data class Game(val playerList:List<Player>, var cardArr:Array<Card> ){
    /**
     * Counter to count how many times the players have passed in a row
     */
    var passCounter = 0
    /**
     * Iterator to iterate over the player list to determine the current player
     */
    var currentPlayer = playerList.listIterator()
}

