package com.ubs.opsit.interviews.enums;

public enum CellCountInRow {

    TOP_HOUR_CELL_COUNT(4),
    BOTTOM_HOUR_CELL_COUNT(4),
    TOP_MINUTE_CELL_COUNT(11),
    BOTTOM_MINUTE_CELL_COUNT(4);

    private int cellCount;

    private CellCountInRow(int cellCount){
        this.cellCount=cellCount;
    }

    public int getCellCount() {
        return cellCount;
    }
}

