package main

import org.hexworks.zircon.api.Positions
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.data.Size
import java.util.*
import kotlin.concurrent.schedule

class GameController(private val displayController: DisplayController,
                     private var snakePosition: Position,
                     private val size: Size) {

    var currentDirection = Direction.DOWN
    var snakePositions = ArrayList(listOf(snakePosition))
    var cherryPosition: Position

    private val random = Random()
    private var length = 3

    init {
        cherryPosition = randomPosition()

        Timer().schedule(1000, 300) {
            move()
            displayController.draw()
        }
    }

    private fun move() {
        snakePositions.add(snakePositions.last() + currentDirection.diff)
        displayController.snakePositions = snakePositions

        checkCherry()

        displayController.cherryPosition = Optional.of(cherryPosition)

        shortenSnake()
    }

    private fun checkCherry() {
        if (snakePositions.last() == cherryPosition) {
            displayController.oldCherryPosition = Optional.of(cherryPosition)
            cherryPosition = randomPosition()
            length++
        }
    }

    private fun shortenSnake() {
        if (snakePositions.size > length) {
            snakePositions.removeAt(0).let {
                displayController.oldSnakePosition = Optional.of(it)
            }
        }
    }

    private fun randomPosition() = Positions.create(random.nextInt(size.width), random.nextInt(size.height))

    fun directionChanged(direction: Direction) {
        currentDirection = direction
    }
}