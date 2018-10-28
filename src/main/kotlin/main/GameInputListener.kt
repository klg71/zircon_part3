package main

import org.hexworks.zircon.api.input.KeyStroke
import org.hexworks.zircon.api.listener.KeyStrokeListener

class GameInputListener(val callback: (Direction) -> Unit) : KeyStrokeListener {

    override fun keyStroked(keyStroke: KeyStroke) {
        when (keyStroke.getCharacter()) {
            'w' -> callback(Direction.UP)
            'a' -> callback(Direction.LEFT)
            's' -> callback(Direction.DOWN)
            'd' -> callback(Direction.RIGHT)
        }
    }
}