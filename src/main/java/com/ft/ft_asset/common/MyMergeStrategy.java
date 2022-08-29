package com.ft.ft_asset.common;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.merge.AbstractMergeStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class MyMergeStrategy extends AbstractMergeStrategy {

    private Sheet sheet;
    private List<Integer> countryCount;
    private List<Integer> productTypeCount;
    public MyMergeStrategy(List<Integer> countryCount,List<Integer> productTypeCount) {
        this.countryCount = countryCount;
        this.productTypeCount = productTypeCount;
    }

    // 按照分组将各种类别分别合并成一个单元格
    private void mergeCountryColumn(Integer index) {
        Integer rowCnt = 1;
        for (Integer count : countryCount) {
            CellRangeAddress cellRangeAddress = new CellRangeAddress(rowCnt, rowCnt + count - 1, index, index);
            sheet.addMergedRegionUnsafe(cellRangeAddress);
            rowCnt += count;
        }
    }
    // 按照分组将各种类别分别合并成一个单元格
    private void mergeProductTypeColumn(Integer index) {
        Integer rowCnt = 1;
        for (Integer count : productTypeCount) {
            CellRangeAddress cellRangeAddress = new CellRangeAddress(rowCnt, rowCnt + count - 1, index, index);
            sheet.addMergedRegionUnsafe(cellRangeAddress);
            rowCnt += count;
        }
    }


    @Override
    protected void merge(Sheet sheet, Cell cell, Head head, Integer integer) {
        this.sheet = sheet;
        if (cell.getRowIndex() == 1) {
            switch (cell.getColumnIndex()) {
                case 0:
                    this.mergeCountryColumn(0);
                    break;
                case 1:
                    this.mergeProductTypeColumn(1);
                    break;
                default:
                    break;
            }
        }
    }
}