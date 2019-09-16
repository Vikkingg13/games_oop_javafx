package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {
    @Test
    public void whenCanMoveThenReturnTrue() {
        Logic logic = new Logic();
        assertThat(logic.move(Cell.A1, Cell.C3), is(true));
    }

    @Test
    public void whenNotCanMoveThenFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack((Cell.A1)));
        logic.add(new BishopBlack(Cell.B2));
        assertThat(logic.move(Cell.A1, Cell.C3), is(false));
    }
}
