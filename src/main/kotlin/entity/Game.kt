package entity

/**
 * Entity class [Game] saves the current player, the pass counter, a list of the players and a card Array where all cards are saved in.
 * @constructor [Game] initializes the [currentPlayer],[passCounter],[playerList],[cardArr].
 * @param currentPlayer resembles the current player.
 * @param passCounter represents the counter of how many times the players have pressed pass in a row. (Value: 0-4)
 * @param playerList is the list of all players participating in the round.
 * @param cardArr is an Array of all cards in the Deck.
 */
data class Game(var currentPlayer:Iterator<Player>,var passCounter: Int, val playerList:List<Player>, var cardArr:Array<Card> )