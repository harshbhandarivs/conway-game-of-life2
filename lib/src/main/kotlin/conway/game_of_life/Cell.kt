package conway.game_of_life

data class Cell(val row: Int, val col: Int) {
    fun getNeighbours(): List<Cell> {
        return listOf(
            Cell(row - 1, col),
            Cell(row + 1, col),
            Cell(row, col - 1),
            Cell(row, col + 1),
            Cell(row + 1, col + 1),
            Cell(row + 1, col - 1),
            Cell(row - 1, col - 1),
            Cell(row - 1, col + 1),
        )
    }
}
