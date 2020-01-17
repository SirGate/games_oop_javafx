package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void whenFigureMoveRightWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(bishop);
        boolean result = logic.move(Cell.C1,Cell.G5);
        assertThat(result, is(true));
    }

    @Test
    public void whenFigureMoveOccupiedWay() {
        BishopBlack bishop1 = new BishopBlack(Cell.C1);
        BishopBlack bishop2 = new BishopBlack(Cell.D2);
        Logic logic = new Logic();
        logic.add(bishop1);
        logic.add(bishop2);
        boolean result = logic.move(Cell.C1,Cell.G5);
        assertThat(result, is(false));
    }

    @Test
    public void whenFigureMoveWrongWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(bishop);
        boolean result = logic.move(Cell.C1,Cell.G6);
        assertThat(result, is(false));
    }
}
