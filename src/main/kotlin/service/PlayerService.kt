package service

import entity.Card
import entity.Game
import entity.Player

class PlayerService(gs:GameService) : RefreshingService() {

    fun createPlayer(name:String){

    }
    fun hasKnocked(player:Player):Boolean{
        return player.hasKnocked
    }
    fun exchangeAllCards(handCards: Card,player:Player){}
    fun exchangeOneCard(handCards: Card,tableCard: Card,player: Player){}
    fun pass(player: Player){

    }
    fun knock(player: Player){
        player.hasKnocked = true
    }
}