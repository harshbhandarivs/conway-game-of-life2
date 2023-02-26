package conway.game_of_life

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class CellTest {

    @ParameterizedTest
    @MethodSource("inputsAndNeighbours")
    fun `Should generate expected neighbours`(cell: Cell, expectedNeighbours: List<Cell>) {
        assertEquals(expectedNeighbours.toSet(), cell.getNeighbours().toSet())
    }

    companion object {
        @JvmStatic
        fun inputsAndNeighbours(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Cell(0, 0),
                    listOf(
                        Cell(1, 0),
                        Cell(0, 1),
                        Cell(1, 1),
                        Cell(-1, -1),
                        Cell(-1, 0),
                        Cell(0, -1),
                        Cell(-1, 1),
                        Cell(1, -1)
                    )
                ),
                Arguments.of(
                    Cell(5, 5),
                    listOf(
                        Cell(6, 5),
                        Cell(5, 6),
                        Cell(6, 6),
                        Cell(4, 4),
                        Cell(4, 5),
                        Cell(5, 4),
                        Cell(4, 6),
                        Cell(6, 4)
                    )
                ),
            )
        }
    }
}