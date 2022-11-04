package service

import entity.Game
import entity.Player
import java.util.LinkedList

class GameService() : RefreshingService() {


    val game = Game()
    val playerService = PlayerService(this)
    val rankingService = RankingService(this)
    fun beginGame(){

    }
    fun endGame(){

    }
    fun nextPlayer(){
        var currPlayer = game.currentPlayer
        if(currPlayer.hasNext()){
            currPlayer.next()
        }else{
            currPlayer = game.playerList.iterator()
        }
    }
    fun increasePassCounter(){
        game.passCounter++
    }
    fun setPassCounterToZero(){
        game.passCounter = 0
    }
    private fun handoutCards(){

    }
    private fun shuffleCards(){

    }
}