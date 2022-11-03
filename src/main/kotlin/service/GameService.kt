package service

import entity.Player

class GameService() : RefreshingService() {

    fun beginGame(){

    }
    fun endGame(){

    }
    fun nextPlayer(currentPlayer:Iterator<Player>) : Player{
        return currentPlayer.next()
    }
    fun increasePassCounter(){

    }
    fun setPassCounterToZero(){

    }
    private fun handoutCards(){

    }
    private fun shuffleCards(){

    }
}