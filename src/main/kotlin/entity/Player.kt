package entity

/**
 * Entity Class [Player] saves the name, the hand Cards of the player and whether the Player has knocked or not.
 * @constructor [Player] initializes a player with his name and his hand cards.
 * @param name Name of the player
 * @param handArr Array of all three hand cards of the player.
 */
data class Player(val name:String, var handArr: Array<Card>){
    var hasKnocked = false
}