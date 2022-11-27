package service

import entity.Card
import entity.CardState
import entity.Player
/**
 * Service class [PlayerService] provides logic for all functionalities
 * considering the player.
 * @param gs GameService is the main service of the service package.
 */
class PlayerService(private val gs:GameService) : RefreshingService() {

    /**
     * Creates a player and adds it to the player list.
     * @param name The name with which the player will be initialized
     */
    //TODO Randfälle implementieren für zwei Spieler und wenn über 4 Spieler geht.
    fun createPlayer(name:String){
        gs.game.playerList.add(Player(name,gs.handoutCards()))
        onAllRefreshables{
            refreshCreatePlayer()
        }
    }

    /**
     * Checks whether a player has knocked.
     * @param player The player for who is checked whether he has knocked
     * @return Boolean value: True, if player has knocked. False, if he has not.
     */
    fun hasKnocked(player:Player):Boolean{
        return player.hasKnocked
    }

    /**
     * Changes all cards of the player with the cards in the middle
     * @param player The player who changes his cards
     */
    fun exchangeAllCards(player:Player) {
        for(card in player.handCardList!!) card.state = CardState.MIDDLE
        for(card in gs.middleCards) card.state = CardState.ON_PLAYER_HAND
        val tmpCard1 = player.handCardList!![0]
        val tmpCard2 = player.handCardList!![1]
        val tmpCard3 = player.handCardList!![2]
        player.handCardList!![0] = gs.middleCards[0]
        player.handCardList!![1] = gs.middleCards[1]
        player.handCardList!![2] = gs.middleCards[2]
        gs.middleCards[0] = tmpCard1
        gs.middleCards[1] = tmpCard2
        gs.middleCards[2] = tmpCard3
        gs.nextPlayer()
        gs.game.passCounter = 0
        onAllRefreshables{
            refreshHandCards()
            refreshMiddleCards()
            refreshAfterNextPlayer()
        }
    }

    /**
     * Changes one card of the player's hand with one card in the middle
     * @param handCard The selected card of the player
     * @param tableCard The selected card in the middle
     * @param player The player who is changing his cards
     */
    fun exchangeOneCard(handCard: Card,tableCard: Card,player: Player){
        val middleExists = gs.middleCards.contains(tableCard)
        val handExists = player.handCardList!!.contains(handCard)
        if(middleExists && handExists){
            handCard.state = CardState.MIDDLE
            tableCard.state = CardState.ON_PLAYER_HAND
            for(i in 0..2){
                if(handCard.color == player.handCardList!![i].color && handCard.value == player.handCardList!![i].value){
                    player.handCardList!!.removeAt(i)
                    player.handCardList!!.add(i, tableCard)
                }
                if(tableCard.color == gs.middleCards[i].color && tableCard.value == gs.middleCards[i].value){
                    gs.middleCards.removeAt(i)
                    gs.middleCards.add(i,handCard)
                }
            }
        }
        gs.nextPlayer()
        onAllRefreshables{
            refreshHandCards()
            refreshMiddleCards()
            refreshAfterNextPlayer()
        }
    }

    /**
     * Increases the pass counter and changes the cards in the middle if every participant
     * has passed in their last round. Ends the game if not enough cards are left on the draw
     * stack.
     */
    fun pass(){
        gs.increasePassCounter()
        if(gs.game.passCounter == gs.game.playerList.size){
            gs.setPassCounterToZero()
            var count = 0
            for(i in gs.game.deck.indices){
                if(gs.game.deck[i].state == CardState.MIDDLE){
                    gs.game.deck[i].state = CardState.OUT_OF_GAME
                }
            }
            for(card in gs.game.deck){
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
        onAllRefreshables {
            refreshAfterPass()
            refreshAfterNextPlayer()
        }
    }

    /**
     * If a player knocks the value is set true.
     */
    fun knock(){
        gs.game.currentPlayer().hasKnocked = true
        gs.nextPlayer()
        onAllRefreshables {
            refreshAfterKnocking()
            refreshAfterNextPlayer()
        }
    }
}