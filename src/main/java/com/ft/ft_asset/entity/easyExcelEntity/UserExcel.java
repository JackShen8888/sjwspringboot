package com.ft.ft_asset.entity.easyExcelEntity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
@ExcelIgnoreUnannotated
public class UserExcel {
    @ExcelProperty(value = {"人员ID"}, index = 0)
    private Long id;
    @ExcelProperty(value = {"人员姓名"}, index = 1)
    private String name;
    @ExcelProperty(value = {"人员年龄"}, index = 2)
    private String age;
    @ExcelProperty(value = {"科目"}, index = 3)
    private String scoreName;
    @ExcelProperty(value = {"分数"}, index = 4)
    private Double score;
    @ExcelProperty(value = {"平均分"}, index = 5)
    private Double avgScore;

}
