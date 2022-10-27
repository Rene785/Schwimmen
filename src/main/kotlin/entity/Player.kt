package entity

data class Player(val name:String, val hasKnocked:Boolean) {

    var handArr = arrayOfNulls<Card>(3)
}