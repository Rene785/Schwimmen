package entity

/**
 * Entity class [Card] is a card with a color, a numeric value and a state.
 * @constructor [Card] initializes the color, the value, and the state
 * @param color represents the color of the card(CLUBS,SPADES,HEARTS,DIAMONDS)
 * @param value represents the value of the card(2-10,JACK,QUEEN,KING,ACE)
 * @param state represents the state of the card(MIDDLE,DRAW_STACK,ON_PLAYER_HAND,OUT_OF_GAME)
 */
data class Card(val color:CardSuit,val value: CardValue,var state:CardState){

    /**
     * @return Returns every information of a Card: Color, Value and State
     */
    override fun toString() = "$color$value$state"
}