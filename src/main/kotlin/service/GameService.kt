package service

import entity.*
import java.util.LinkedList

/**
 * Service Class [GameService] provides logic for all functionalities
 * considering the flow of the game.
 */
class GameService : RefreshingService() {
    var game = Game(createDeck())
    val playerService = PlayerService(this)

    var middleCards = LinkedList<Card>()

    /**
     * Starts the game
     */
    fun beginGame(playerList: LinkedList<Player>){
        game.playerList = playerList
        game.deck.shuffle()
        for(player in playerList) player.handCardList = handoutCards()
        middleCards = setMiddleCards()!!
        onAllRefreshables{
            refreshAfterStart()
        }
    }

    /**
     * Starts the end Scene after the game has finished
     */
    fun endGame(){
        setPassCounterToZero()
        showResult()
        onAllRefreshables {
            refreshScore()
        }
    }

    /**
     * Selects the next player in the player list
     */
    fun nextPlayer(){
        game.currentPlayerIndex++
        if(game.currentPlayerIndex >= game.playerList.size) game.currentPlayerIndex = 0
        if(game.currentPlayer().hasKnocked) {
            endGame()
            return
        }
        onAllRefreshables { refreshAfterNextPlayer() }
    }

    /**
     * Increases the pass counter
     */
    fun increasePassCounter(){
        game.passCounter++
    }

    /**
     * Sets the pass counter on zero
     */
    fun setPassCounterToZero(){
        game.passCounter = 0
    }

    /**
     * Returns the first three cards of the draw Stack
     */
    fun handoutCards():LinkedList<Card>?{
        val handCards = LinkedList<Card>()
        var i = 0
        for(card in game.deck){
            if(card.state == CardState.DRAW_STACK){
                handCards.add(card)
                card.state = CardState.ON_PLAYER_HAND
                i++
            }
            if(i == 3){
                break
            }
        }
        if(i<3){
            return null
        }
        return handCards
    }

    /**
     * Sets the middle cards. Like handoutCards() draws the first three cards from the
     * draw stack.
     */
    fun setMiddleCards():LinkedList<Card>? {
        val middle = LinkedList<Card>()
        var i = 0
        for(card in game.deck){
            if(card.state == CardState.DRAW_STACK){
                middle.add(card)
                card.state = CardState.MIDDLE
                i++
            }
            if(i == 3){
                break
            }
        }
        //If there are not enough cards on the draw stack
        if(i<3){
            return null
        }
        return middle
    }

    /**
     * Shuffles the card list
     */
    private fun shuffleCards(){
        game.deck.shuffle()
    }

    /**
     * Creates the deck of cards
     */
    private fun createDeck():LinkedList<Card>{
        val deck = LinkedList<Card>()
        for(color in CardSuit.values()){
            for(value in CardValue.shortDeck()){
                deck.add(Card(color,value,CardState.DRAW_STACK))
            }
        }
        return deck
    }

    /**
     * Shows the results of each player's points
     */
    private fun showResult(){
        for(player in game.playerList){
            player.calculatePoints()
        }
        onAllRefreshables {
            refreshScore()
        }
    }
    fun startNextRound(){
        onAllRefreshables { refreshAfterNextPlayerScene() }
    }
}