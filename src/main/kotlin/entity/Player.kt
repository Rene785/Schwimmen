package entity

import java.util.*

/**
 * Entity Class [Player] saves the name, the hand Cards of the player and whether the Player has knocked or not.
 * @constructor [Player] initializes a player with his name and his hand cards.
 * @param name Name of the player
 * @param handCardList Mutable list of all three hand cards of the player.
 */
data class Player(var name:String, var handCardList: MutableList<Card>? = null){
    var hasKnocked = false
    var points = 0.0
    fun calculatePoints(){
        var heartScore = 0.0
        var spadeScore = 0.0
        var diamondScore = 0.0
        var clubScore = 0.0
        var valueScore = 0.0
        val valueList = LinkedList<CardValue>()
        for(card in handCardList!!) {
            if(card.color.toString() == "♥") heartScore += card.value.toInt().toDouble()
            if(card.color.toString() == "♦") spadeScore += card.value.toInt().toDouble()
            if(card.color.toString() == "♣") diamondScore += card.value.toInt().toDouble()
            if(card.color.toString() == "♠") clubScore += card.value.toInt().toDouble()
            valueList.add(card.value)
        }
        if(valueList[0].equals(valueList[1]) && valueList[0].equals(valueList[2])){
               valueScore = 30.5
        }
        if(valueList[0].equals(valueList[1]) && valueScore == 0.0){
            valueScore = valueList[0].toInt().toDouble() + valueList[1].toInt().toDouble()
        }
        if(valueList[0].equals(valueList[2]) && valueScore == 0.0){
            valueScore = valueList[0].toInt().toDouble() + valueList[2].toInt().toDouble()
        }
        if(valueList[1].equals(valueList[2]) && valueScore == 0.0){
            valueScore = valueList[1].toInt().toDouble() + valueList[2].toInt().toDouble()
        }
        points = maxOf(heartScore,spadeScore,diamondScore,clubScore,valueScore)
    }
}