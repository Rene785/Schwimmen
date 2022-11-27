package view

/**
 * Interface for graphical updates while the game is running
 */
interface Refreshables {
    /**
     * Refreshes the Hand cards.
     */
    fun refreshHandCards(){}

    /**
     * Refreshes the middle cards.
     */
    fun refreshMiddleCards(){}

    /**
     * Refreshes the score.
     */
    fun refreshScore(){}

    /**
     * Refreshes the ui after a player has knocked
     */
    fun refreshAfterKnocking(){}

    /**
     * Refreshes the screen after a player has passed
     */
    fun refreshAfterPass(){}

    /**
     * Refreshes the screen after the game has been started
     */
    fun refreshAfterStart(){}

    /**
     * Refreshes the screen after a player has been created.
     */
    fun refreshCreatePlayer(){}

    /**
     * Updates the screen after a player has finished his turn.
     */
    fun refreshAfterNextPlayer(){}
    /**
     * Updates after the next player is at the table playing
     */
    fun refreshAfterNextPlayerScene(){}
}