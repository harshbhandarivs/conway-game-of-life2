package conway.game_of_life

import java.util.*

class Game(private var state: Set<Cell>) {

    fun getCurrentState(): Set<Cell> {
        return Collections.unmodifiableSet(state)
    }

    fun updateState() {
        val neighbourCountForEachCell = getNeighbourCountForEachCell()
        state = computeNewState(neighbourCountForEachCell)
    }

    private fun computeNewState(neighbourCountForEachCell: MutableMap<Cell, Int>): Set<Cell> {
        val newState = mutableSetOf<Cell>()
        for ((cell, count) in neighbourCountForEachCell) {
            if (liveCellWithTwoOrThreeNeighbours(cell, count)) {
                newState.add(cell)
            }
            if (deadCellWithThreeNeighbours(cell, count)) {
                newState.add(cell)
            }
        }
        return newState
    }

    private fun deadCellWithThreeNeighbours(cell: Cell, count: Int) = !isCellAlive(cell) && (count == 3)

    private fun liveCellWithTwoOrThreeNeighbours(cell: Cell, count: Int) =
        isCellAlive(cell) && (count == 3 || count == 2)

    private fun isCellAlive(cell: Cell) = state.contains(cell)

    private fun getNeighbourCountForEachCell(): MutableMap<Cell, Int> {
        val neighboursForParticularCell = mutableMapOf<Cell, Int>()
        for (cell in state) {
            val neighbours = cell.getNeighbours()
            for (neighbour in neighbours) {
                neighboursForParticularCell[neighbour] = (neighboursForParticularCell[neighbour] ?: 0) + 1
            }
        }
        return neighboursForParticularCell
    }

}
