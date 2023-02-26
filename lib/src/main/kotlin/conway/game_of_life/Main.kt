package conway.game_of_life

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File


fun main() {
    val file = File("data.csv")
    println(file.absolutePath + " dreamers")
    val state = mutableSetOf<Cell>()
    csvReader().open(file) {
        readAllWithHeaderAsSequence().forEach { row: Map<String, String> ->
            state.add(Cell(row["0"]!!.toInt(), row["1"]!!.toInt()))
        }
    }
    println(state.size)
    val game = Game(state)
    val start = System.nanoTime()
    game.updateState()
    println("Time taken to update 1 state: ${(System.nanoTime() - start).toDouble()/1_000_000_000}")
}