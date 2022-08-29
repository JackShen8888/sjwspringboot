package com.ft.ft_asset.common;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.handler.WorkbookWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import java.math.BigDecimal;

public class ExcelFillCellMergeStrategy implements WorkbookWriteHandler, SheetWriteHandler {
    //需要合并的列 {0,1,2,10,11}
    private int[] mergeColumnIndex;
    private String sheetName;

    public ExcelFillCellMergeStrategy() {
    }

    public ExcelFillCellMergeStrategy(int[] mergeColumnIndex, String sheetName) {
        this.mergeColumnIndex = mergeColumnIndex;
        this.sheetName = sheetName;
    }

    @Override
    public void beforeWorkbookCreate() {
    }

    @Override
    public void afterWorkbookCreate(WriteWorkbookHolder writeWorkbookHolder) {
    }

    @Override
    public void afterWorkbookDispose(WriteWorkbookHolder writeWorkbookHolder) {
        Sheet sheet=writeWorkbookHolder.getWorkbook().getSheet(sheetName);
        int rows = sheet.getPhysicalNumberOfRows();

        Integer startRow = null;
        Integer endedRow = null;
        Object preData = getCellValue(sheet.getRow(0).getCell(0));
        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            String data = getCellValue(row.getCell(0));
            if (preData.equals(data)) {
                if (startRow == null) {
                    startRow = i - 1;
                }
                endedRow = i;
            } else {
                if(startRow!=null){
                    for (int columnIndex : mergeColumnIndex) {
                        sheet.addMergedRegion(new CellRangeAddress(startRow, endedRow, columnIndex, columnIndex));
                    }
                }
                startRow = null;
                endedRow = null;
            }
            preData = data;
        }
        if(startRow!=null){
            for (int columnIndex : mergeColumnIndex) {
                sheet.addMergedRegion(new CellRangeAddress(startRow, endedRow, columnIndex, columnIndex));
            }
        }

    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellTypeEnum() == CellType.NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                return HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
            } else {
                return new BigDecimal(cell.getNumericCellValue()).toString();
            }
        } else if (cell.getCellTypeEnum() == CellType.STRING) {
            return StringUtils.trimToEmpty(cell.getStringCellValue());
        } else if (cell.getCellTypeEnum() == CellType.FORMULA) {
            return StringUtils.trimToEmpty(cell.getCellFormula());
        } else if (cell.getCellTypeEnum() == CellType.BLANK) {
            return "";
        } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellTypeEnum() == CellType.ERROR) {
            return "ERROR";
        } else {
            return cell.toString().trim();
        }

    }

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        Sheet sheet = writeWorkbookHolder.getWorkbook().getSheet(sheetName);
        ((SXSSFSheet) sheet).setRandomAccessWindowSize(-1);
    }
}
