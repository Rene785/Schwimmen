package service

import entity.Card
import entity.CardState
import entity.Player
import java.util.*

class PlayerService(private val gs:GameService) : RefreshingService() {

    fun createPlayer(name:String){
        for(player in gs.game.playerList) {
            if (player.name.equals("Spieler 1") || player.name.equals("Spieler 2")){
                player.name = name
                return
            }
        }
        gs.game.playerList.add(Player(name,gs.handoutCards() as Array<Card>))
        //onAllRefreshables(refreshCreatePlayer())
    }
    fun hasKnocked(player:Player):Boolean{
        return player.hasKnocked
    }
    fun exchangeAllCards(player:Player) {
        val middleCards: LinkedList<Card> = LinkedList()
        for (card in gs.game.cardArr) {
            if (card.state == CardState.MIDDLE) {
                middleCards.add(card)
            }
        }
        for(card in player.handArr) card.state = CardState.MIDDLE
        for(card in middleCards) card.state = CardState.ON_PLAYER_HAND
        player.handArr[0] = middleCards[0]
        player.handArr[1] = middleCards[1]
        player.handArr[2] = middleCards[2]
        gs.nextPlayer()
        gs.game.passCounter = 0
        //onAllRefreshables(refreshHandCards())
        //onAllRefreshables(refreshMiddleCards())
    }
    fun exchangeOneCard(handCard: Card,tableCard: Card,player: Player){
        var i=0
        var reached = false
        for(card in player.handArr){
            if(reached) break
            else if(card == handCard){
                player.handArr[i].state = CardState.MIDDLE
                tableCard.state = CardState.ON_PLAYER_HAND
                player.handArr[i] = tableCard
                reached = true
            }else{
                i++
            }
        }
        gs.nextPlayer()
        //onAllRefreshables(refreshMiddleCards())
        //onAllRefreshables(refreshHandCards())
    }
    fun pass(){
        gs.increasePassCounter()
        if(gs.game.passCounter == gs.game.playerList.size){
            gs.setPassCounterToZero()
            var count = 0
            for(i in gs.game.cardArr.indices){
                if(gs.game.cardArr[i].state == CardState.MIDDLE){
                    gs.game.cardArr[i].state = CardState.OUT_OF_GAME
                }
            }
            for(card in gs.game.cardArr){
                if(count == 2) break
                if(card.state == CardState.DRAW_STACK){
                    card.state = CardState.MIDDLE
                    count++
                }
            }
            if(count != 2){
                gs.endGame()
                return
            }
        }
        gs.nextPlayer()
        //onAllRefreshables(refreshAfterPass())
    }
    fun knock(player: Player){
        player.hasKnocked = true
        //onAllRefreshables(refreshAfterKnocking())
    }
}