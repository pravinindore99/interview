package com.ubs.opsit.interviews.enums;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CellCountInRowEnumTest {

    @Test
    public void testTopHourCellCount(){
        Assertions.assertThat(CellCountInRow.TOP_HOUR_CELL_COUNT.getCellCount()).isEqualTo(4);
    }

    @Test
    public void testBottomHourCellCount(){
        Assertions.assertThat(CellCountInRow.BOTTOM_HOUR_CELL_COUNT.getCellCount()).isEqualTo(4);
    }

    @Test
    public void testTopMinuteCellCount(){
        Assertions.assertThat(CellCountInRow.TOP_MINUTE_CELL_COUNT.getCellCount()).isEqualTo(11);
    }

    @Test
    public void testBottomMinuteCellCount(){
        Assertions.assertThat(CellCountInRow.BOTTOM_MINUTE_CELL_COUNT.getCellCount()).isEqualTo(4);
    }

}
