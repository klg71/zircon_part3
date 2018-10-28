package main

import org.hexworks.zircon.api.Screens
import org.hexworks.zircon.api.Tiles
import org.hexworks.zircon.api.builder.data.TileBuilder
import org.hexworks.zircon.api.color.ANSITileColor
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.grid.TileGrid
import java.util.*

class DisplayController(tileGrid: TileGrid, startPosition: Position) {
    private val gameScreen = Screens.createScreenFor(tileGrid)

    private val gameLayer = gameScreen.layers.first()

    private val snakeTile = snakeTile()
    private val blackTile = blackTile()

    var snakePosition = startPosition
        set(value) {
            oldSnakePosition = Optional.of(snakePosition)
            field = value
        }

    private var oldSnakePosition = Optional.empty<Position>()

    fun draw() {
        oldSnakePosition.ifPresent {
            gameLayer.setTileAt(it, blackTile)
        }
        gameLayer.setTileAt(snakePosition, snakeTile)
        gameScreen.display()
    }

    private fun snakeTile() = tileBuilder {
        withBackgroundColor(ANSITileColor.GREEN)
        withForegroundColor(ANSITileColor.WHITE)
        withCharacter('o')
    }

    private fun blackTile() = tileBuilder {
        withBackgroundColor(ANSITileColor.BLACK)
        withForegroundColor(ANSITileColor.BLACK)
        withCharacter(' ')
    }
}

fun tileBuilder(lambda: TileBuilder.() -> Unit): Tile {
    return Tiles.newBuilder().apply(lambda).build()
}

