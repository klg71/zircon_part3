package main

import org.hexworks.zircon.api.Positions
import org.hexworks.zircon.api.data.Position

enum class Direction(val diff: Position) {
    UP(Positions.create(0, -1)),
    DOWN(Positions.create(0, 1)),
    LEFT(Positions.create(-1, 0)),
    RIGHT(Position.create(1, 0));
}