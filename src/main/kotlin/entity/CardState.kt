package entity

/**
 * Enum to distinguish the 4 possible states of a card.
 */
enum class CardState {
    MIDDLE,
    DRAW_STACK,
    ON_PLAYER_HAND,
    OUT_OF_GAME,
    ;

    /**
     * Provides a lowercase String to represent the state.
     * @return Either of middle/draw-stack/on-player-hand/out-of-game
     */
    override fun toString() = when(this) {
        MIDDLE -> "middle"
        DRAW_STACK -> "draw-stack"
        ON_PLAYER_HAND -> "on-player-hand"
        OUT_OF_GAME -> "out-of-game"
    }
}