package entity

/**
 * Entity Class [Player] saves the name, the hand Cards of the player and whether the Player has knocked or not.
 * @constructor [Player] initializes a player with his name whether he has knocked and his hand cards.
 * @param name Represents the name of the player
 * @param hasKnocked Represents if the player has knocked
 * @param handArr Array of all three hand cards of the player.
 */
data class Player(val name:String, var hasKnocked:Boolean, var handArr: Array<Card>? = null)