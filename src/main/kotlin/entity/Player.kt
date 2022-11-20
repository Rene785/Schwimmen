package entity

/**
 * Entity Class [Player] saves the name, the hand Cards of the player and whether the Player has knocked or not.
 * @constructor [Player] initializes a player with his name and his hand cards.
 * @param name Name of the player
 * @param handCardList Mutable list of all three hand cards of the player.
 */
data class Player(var name:String, var handCardList: MutableList<Card>? = null){
    var hasKnocked = false
    var points = 0
    //TODO Methode hängt noch nicht von Farben ab und hat irgendwie mit String ein Problem
    fun calculatePoints(){
        for(card in handCardList!!) {
            points += Integer.parseInt(card.value.toString().lowercase())
        }
    }
}