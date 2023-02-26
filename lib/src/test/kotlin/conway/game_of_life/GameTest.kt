package conway.game_of_life

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun `Should any live cell with fewer than two live neighbours dies, as if by underpopulation`() {
        val state = setOf(Cell(0, 0))
        val game = Game(state)

        game.updateState()

        assertEquals(setOf(), game.getCurrentState())
    }

    @Test
    fun `Should any live cell with two or three live neighbours lives on to the next generation`() {
        val state = setOf(Cell(0, 0), Cell(0, 1), Cell(1, 0))
        val game = Game(state)

        game.updateState()

        assertEquals(
            setOf(
                Cell(1, 0),
                Cell(0, 1),
                Cell(1, 1),
                Cell(0, 0)
            ), game.getCurrentState()
        )
    }

    @Test
    fun `Should any live cell with more than three live neighbours dies, as if by overpopulation`() {
        val state = setOf(Cell(0, 0), Cell(0, 1), Cell(1, 0), Cell(-1, -1), Cell(1, 1))
        val game = Game(state)

        game.updateState()

        assertEquals(
            setOf(
                Cell(-1, 0),
                Cell(1, 0),
                Cell(0, -1),
                Cell(0, 1),
                Cell(1, 1)
            ), game.getCurrentState()
        )
    }

    @Test
    fun `Should work for still life block pattern`() {
        val state = setOf(Cell(0, 0), Cell(0, 1), Cell(1, 0), Cell(1, 1))
        val game = Game(state)

        game.updateState()

        assertEquals(
            setOf(
                Cell(0, 0),
                Cell(1, 0),
                Cell(0, 1),
                Cell(1, 1)
            ), game.getCurrentState()
        )
    }

    @Test
    fun `Should work for still life tub pattern`() {
        val state = setOf(Cell(0, -1), Cell(0, 1), Cell(1, 0), Cell(-1, 0))
        val game = Game(state)

        game.updateState()

        assertEquals(
            setOf(
                Cell(0, -1),
                Cell(0, 1),
                Cell(1, 0),
                Cell(-1, 0)
            ), game.getCurrentState()
        )
    }

    @Test
    fun `Should work for still life boat pattern`() {
        val state = setOf(Cell(-1, 1), Cell(-1, 0), Cell(0, 1), Cell(0, -1), Cell(1, 0))
        val game = Game(state)

        game.updateState()

        assertEquals(
            setOf(
                Cell(-1, 1),
                Cell(-1, 0),
                Cell(0, 1),
                Cell(0, -1),
                Cell(1, 0)
            ), game.getCurrentState()
        )
    }

    @Test
    fun `Should work for oscillator blink pattern`() {
        val state = setOf(Cell(0, 0), Cell(-1, 0), Cell(1, 0))
        val game = Game(state)

        game.updateState()

        assertEquals(
            setOf(
                Cell(0, 0),
                Cell(0, 1),
                Cell(0, -1)
            ), game.getCurrentState()
        )
    }

    @Test
    fun `Should work for oscillator blink pattern in second update come back to original state`() {
        val state = setOf(Cell(0, 0), Cell(-1, 0), Cell(1, 0))
        val game = Game(state)

        game.updateState()
        game.updateState()

        assertEquals(
            setOf(
                Cell(0, 0),
                Cell(-1, 0),
                Cell(1, 0)
            ), game.getCurrentState()
        )
    }
}
