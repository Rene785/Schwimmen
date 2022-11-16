package service

import entity.*
import java.util.LinkedList

/**
 * Service Class [GameService] provides logic for all functionalities
 * considering the flow of the game.
 */
class GameService() : RefreshingService() {


    val game = Game(createDeck())
    val playerService = PlayerService(this)

    /**
     * Starts the game
     */
    fun beginGame(){
        shuffleCards()
        for(player in game.playerList) handoutCards()
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
    }

    /**
     * Selects the next player in the player list
     */
    fun nextPlayer(){
        if(game.currentPlayer.hasNext()){
            game.currentPlayer.next()
        }else{
            game.currentPlayer = game.playerList.iterator()
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
    fun handoutCards():LinkedList<Card>{
        val handCards = LinkedList<Card>()
        var i = 0
        for(card in game.cardList){
            if(i == 2){
                break
            }
            if(card.state == CardState.DRAW_STACK){
                handCards.add(card)
                i++
            }
        }
        return handCards
    }

    /**
     * Shuffles the card list
     */
    private fun shuffleCards(){
        game.cardList.shuffle()
    }

    /**
     * Creates the deck of cards
     */
    private fun createDeck():MutableList<Card>{
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
}