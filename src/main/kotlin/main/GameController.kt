package main

import org.hexworks.zircon.api.data.Position
import java.util.*
import kotlin.concurrent.schedule

class GameController(private val displayController: DisplayController, private var snakePosition: Position) {

    var currentDirection = Direction.DOWN
    var snakePositions = ArrayList(listOf(snakePosition))
    private var length = 3

    init {
        Timer().schedule(1000, 300) {
            move()
            displayController.draw()
        }
    }

    private fun move() {
        snakePositions.add(snakePositions.last() + currentDirection.diff)
        displayController.snakePositions = snakePositions

        shortenSnake()
    }

    private fun shortenSnake() {
        if (snakePositions.size > length) {
            snakePositions.removeAt(0).let {
                displayController.oldSnakePosition = Optional.of(it)
            }
        }
    }

    fun directionChanged(direction: Direction) {
        currentDirection = direction
    }
}