package service

import entity.*
import java.util.LinkedList

class GameService() : RefreshingService() {


    val game = Game(createDeck() as Array<Card>)
    val playerService = PlayerService(this)
    fun beginGame(){
        createDeck()
        shuffleCards()
        for(player in game.playerList) handoutCards()
        onAllRefreshables{
            refreshAfterStart()
        }
    }

    fun endGame(){
        setPassCounterToZero()
        showResult()
    }
    fun nextPlayer(){
        if(game.currentPlayer.hasNext()){
            game.currentPlayer.next()
        }else{
            game.currentPlayer = game.playerList.iterator()
        }
    }
    fun increasePassCounter(){
        game.passCounter++
    }
    fun setPassCounterToZero(){
        game.passCounter = 0
    }

    /**
     * Returns the first three cards of the draw Stack
     */
    fun handoutCards():LinkedList<Card>{
        val handCards = LinkedList<Card>()
        var i = 0
        for(card in game.cardArr){
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
    private fun shuffleCards(){
        game.cardArr.shuffle()
    }
    private fun createDeck():LinkedList<Card>{
        val deck = LinkedList<Card>()
        for(color in CardSuit.values()){
            for(value in CardValue.values()){
                deck.add(Card(color,value,CardState.DRAW_STACK))
            }
        }
        return deck
    }
    private fun showResult(){
        for(player in game.playerList){
            player.calculatePoints()
        }
        onAllRefreshables {
            refreshScore()
        }
    }
}