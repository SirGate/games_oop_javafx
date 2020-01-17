package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenFigureCreate() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        assertThat(bishop.position(), is(Cell.F8));
    }

    @Test
    public void whenFigureCopy() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        Figure newbishop = bishop.copy(Cell.E7);
        assertThat(newbishop.position(), is(Cell.E7));
    }

    @Test
    public void whenFigureWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell [] path  = bishop.way(Cell.C1,Cell.G5);
        Cell [] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(path, expected);
    }

    @Test
    public void whenFigureWayNoDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
      boolean result = false;
       try {
           Cell[] path = bishop.way(Cell.C1, Cell.G6);
       } catch (IllegalStateException e) {
             result = true;
       }
        assertThat(result, is(true));
    }

}
