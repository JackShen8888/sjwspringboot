package com.ft.ft_asset.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONObject;
import com.ft.ft_asset.common.EasyExcelCustemhandlerConfig;
import com.ft.ft_asset.entity.easyExcelEntity.Score;
import com.ft.ft_asset.entity.easyExcelEntity.User;
import com.ft.ft_asset.entity.easyExcelEntity.UserExcel;
import com.ft.ft_asset.service.EasyExcelService;
import com.ft.ft_asset.util.EasyExcelUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EasyExcelServiceImpl implements EasyExcelService {
    @Override
    public void exportScoreTemplate1(HttpServletResponse response)throws IOException {
        List<UserExcel> excels = getUserExcels();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = "采购统计" + sdf.format(new Date());
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), StandardCharsets.ISO_8859_1) + ".xlsx");

        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                .head(UserExcel.class)
                .registerWriteHandler(new EasyExcelCustemhandlerConfig())
                .registerWriteHandler(EasyExcelUtil.getStyleStrategy())
                .build();
        WriteSheet writeSheet1 = EasyExcel.writerSheet(0, "sheet1").head(UserExcel.class).build();
        excelWriter.write(excels, writeSheet1);
        excelWriter.finish();
    }

    private List<UserExcel> getUserExcels() {
        String json = "[{\"age\":\"20\",\"id\":1,\"list\":[{\"avgScore\":80.0,\"id\":1,\"name\":\"语文\",\"score\":97.4},{\"avgScore\":67.0,\"id\":2,\"name\":\"数学\",\"score\":89.2}],\"name\":\"张三\"},{\"age\":\"22\",\"id\":2,\"list\":[{\"avgScore\":80.0,\"id\":1,\"name\":\"语文\",\"score\":97.4},{\"avgScore\":0.0,\"id\":2,\"name\":\"数学\",\"score\":89.2},{\"avgScore\":70.0,\"id\":3,\"name\":\"英语\",\"score\":78.2}],\"name\":\"李四\"},{\"age\":\"19\",\"id\":3,\"list\":[{\"avgScore\":80.0,\"id\":1,\"name\":\"语文\",\"score\":97.4},{\"avgScore\":0.0,\"id\":2,\"name\":\"数学\",\"score\":89.2},{\"avgScore\":70.0,\"id\":3,\"name\":\"英语\",\"score\":78.2},{\"avgScore\":71.0,\"id\":4,\"name\":\"政治\",\"score\":74.2}],\"name\":\"王五\"}]";
        List<User> users = JSONObject.parseArray(json,User.class);
        List<UserExcel> excels = new ArrayList<>();
        for(User user : users ){
            for(Score score : user.getList()){
                UserExcel excel = new UserExcel();
                excel.setId(user.getId());
                excel.setName(user.getName());
                excel.setAge(user.getAge());
                excel.setScoreName(score.getName());
                excel.setScore(score.getScore());
                excel.setAvgScore(score.getAvgScore());
                excels.add(excel);
            }
        }
        return excels;
    }

    @Override
    public void exportScoreTemplate2(HttpServletResponse response)throws IOException{
        ClassPathResource classPathResource = new ClassPathResource("test.xlsx");
        InputStream inputStream = classPathResource.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        List<UserExcel> excels = getUserExcels();
//        String json = "[{\"age\":\"20\",\"id\":1,\"list\":[{\"avgScore\":80.0,\"id\":1,\"name\":\"语文\",\"score\":97.4},{\"avgScore\":67.0,\"id\":2,\"name\":\"数学\",\"score\":89.2}],\"name\":\"张三\"},{\"age\":\"22\",\"id\":2,\"list\":[{\"avgScore\":80.0,\"id\":1,\"name\":\"语文\",\"score\":97.4},{\"avgScore\":0.0,\"id\":2,\"name\":\"数学\",\"score\":89.2},{\"avgScore\":70.0,\"id\":3,\"name\":\"英语\",\"score\":78.2}],\"name\":\"李四\"},{\"age\":\"19\",\"id\":3,\"list\":[{\"avgScore\":80.0,\"id\":1,\"name\":\"语文\",\"score\":97.4},{\"avgScore\":0.0,\"id\":2,\"name\":\"数学\",\"score\":89.2},{\"avgScore\":70.0,\"id\":3,\"name\":\"英语\",\"score\":78.2},{\"avgScore\":71.0,\"id\":4,\"name\":\"政治\",\"score\":74.2}],\"name\":\"王五\"}]";
//        List<User> users = JSONObject.parseArray(json,User.class);
        getScores(excels, workbook);//渲染第一页sheet

        String fileName = "成绩列表" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".xlsx";
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        OutputStream output = response.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(output);
        bufferedOutputStream.flush();
        workbook.write(bufferedOutputStream);
        bufferedOutputStream.close();
        workbook.close();
        output.close();
    }
    private void getScores(List<UserExcel> excels, XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        if (sheet != null) {
            if (CollectionUtils.isNotEmpty(excels)) {
                for (int i = 0; i < excels.size(); i++) {
                    XSSFRow row = sheet.createRow(i + 3);
                    row.createCell(0).setCellValue(excels.get(i).getId());
                    row.createCell(1).setCellValue(excels.get(i).getName());
                    row.createCell(2).setCellValue(excels.get(i).getAge());
                    row.createCell(3).setCellValue(excels.get(i).getScoreName());
                    row.createCell(4).setCellValue(excels.get(i).getScore());
                    row.createCell(5).setCellValue(excels.get(i).getAvgScore());
                }
            }
        }
        sheet.addMergedRegion(new CellRangeAddress(3,4,0,0));
        sheet.addMergedRegion(new CellRangeAddress(3,4,1,1));
        sheet.addMergedRegion(new CellRangeAddress(3,4,2,2));
        sheet.addMergedRegion(new CellRangeAddress(5,7,0,0));
        sheet.addMergedRegion(new CellRangeAddress(5,7,1,1));
        sheet.addMergedRegion(new CellRangeAddress(5,7,2,2));
        sheet.addMergedRegion(new CellRangeAddress(8,11,0,0));
        sheet.addMergedRegion(new CellRangeAddress(8,11,1,1));
        sheet.addMergedRegion(new CellRangeAddress(8,11,2,2));
    }
}
