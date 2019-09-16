package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {
    @Test
    public void whenPositionSameInitialPosition() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        assertThat(figure.position(), is(Cell.C1));
    }

    @Test
    public void whenCopyThenOldPosition() {
        BishopBlack figure = (BishopBlack) new BishopBlack(Cell.C1).copy(Cell.A1);
        assertThat(figure.position(), is(Cell.A1));
    }

    @Test
    public void whenWayReturnArray() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell[] array = figure.way(Cell.C1, Cell.G5);
        assertThat(array, is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void whenIsDiagonalThenReturnTrue() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertThat(bishop.isDiagonal(Cell.A3, Cell.C1), is(true));
    }

    @Test
    public void whenIsNotDiagonalThenReturnFalse() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertThat(bishop.isDiagonal(Cell.A1, Cell.B3), is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void whenInWayIsNotDiagonalThenThrowException() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertThat(bishop.way(Cell.C1, Cell.G3), is(new IllegalStateException()));
    }
}
