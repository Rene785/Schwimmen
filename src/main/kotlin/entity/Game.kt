package entity

data class Game(var currentPlayer:Iterator<Player>,var passCounter: Int, val playerList:List<Player>, var cardArr:Array<Card> ) {

}