package entity

data class Player(val name:String, var hasKnocked:Boolean) {

    var handArr = arrayOfNulls<Card>(3)
}