package main

import org.hexworks.zircon.api.data.Position

class GameController(private val displayController: DisplayController, private var snakePosition: Position) {
    fun move(direction: Direction) {
        snakePosition += direction.diff
        displayController.snakePosition = snakePosition
    }
}