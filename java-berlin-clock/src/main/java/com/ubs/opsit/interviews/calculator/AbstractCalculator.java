package com.ubs.opsit.interviews.calculator;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.constants.BerlinConstants;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCalculator implements IBaseCalculator {

    private LightColor lightColor;

    private CellCountInRow cellCountInRow;

    private Integer inputValue;

    private List<Integer> specialCells = new ArrayList<>();

    private Integer result;

    private Boolean shouldAttachNewLine = true;

    public LightColor getLightColor() {
        return lightColor;
    }

    public void setLightColor(LightColor lightColor) {
        this.lightColor = lightColor;
    }

    public CellCountInRow getCellCountInRow() {
        return cellCountInRow;
    }

    public void setCellCountInRow(CellCountInRow cellCountInRow) {
        this.cellCountInRow = cellCountInRow;
    }

    public Boolean shouldAttachNewLine() {
        return shouldAttachNewLine;
    }

    public void setShouldAttachNewLine(Boolean shouldAttachNewLine) {
        this.shouldAttachNewLine = shouldAttachNewLine;
    }

    public List<Integer> getSpecialCells() {
        return specialCells;
    }

    public AbstractCalculator() {
    }

    public Integer getInputValue() {
        return inputValue;
    }

    public AbstractCalculator(LightColor lightColor, CellCountInRow cellCountInRow, String inputValue) {
        this.lightColor = lightColor;
        this.cellCountInRow = cellCountInRow;
        this.inputValue =  Integer.parseInt(inputValue);
    }

    protected abstract Integer getDivisionOrModuloResult();

    @Override
    public StringBuilder convertValue() {
        this.result = this.getDivisionOrModuloResult();
        if(shouldAttachNewLine()){
            return attachNewLineIfRequired(padDataIfRequired(setValueOfLights()));
        }else{
            return padDataIfRequired(setValueOfLights());
        }
    }

    protected StringBuilder setValueOfLights(){
        this.specialCells = getSpecialCells();
        StringBuilder lightRepresentation = new StringBuilder();
        for(int index =0 ; index <this.result; index++){
            if(this.cellCountInRow==CellCountInRow.TOP_MINUTE_CELL_COUNT){
                if(this.specialCells.contains(index+1)){
                    lightRepresentation.append(LightColor.RED.getColorCode());
                }else{
                    lightRepresentation.append(this.lightColor.getColorCode());
                }
            }else{
                lightRepresentation.append(this.lightColor.getColorCode());
            }
        }
        return lightRepresentation;
    }

    protected StringBuilder padDataIfRequired(StringBuilder inputString){
        if(this.result < this.cellCountInRow.getCellCount()){
            for(int index = 0 ; index < (this.cellCountInRow.getCellCount()-this.result) ; index++){
                inputString.append(BerlinConstants.CELL_STATE_OFF);
            }
        }
        return  inputString;
    }

    protected StringBuilder attachNewLineIfRequired(StringBuilder inputString){
        return inputString.append(this.newLine);
    }
}
