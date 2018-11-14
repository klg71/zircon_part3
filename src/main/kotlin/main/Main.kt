package main

import org.hexworks.zircon.api.AppConfigs
import org.hexworks.zircon.api.Positions
import org.hexworks.zircon.api.Sizes
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.builder.application.AppConfigBuilder

fun main(args: Array<String>) {

    val grid = SwingApplications.startTileGrid(
            tileConfig {
                withSize(Sizes.create(30, 20))
            }
    )

    val startPosition = Positions.create(2, 3)

    DisplayController(grid, startPosition).apply {

        GameController(this, startPosition).apply {
            grid.onKeyStroke(GameInputListener(this::directionChanged))
        }
    }

}

fun tileConfig(lambda: AppConfigBuilder.() -> Unit) =
        AppConfigs.newConfig().apply(lambda).build()



