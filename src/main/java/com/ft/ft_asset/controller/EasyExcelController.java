package com.ft.ft_asset.controller;

import com.ft.ft_asset.service.EasyExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(value = "/api/easyExcel")
public class EasyExcelController {
    @Autowired
    EasyExcelService easyExcelService;
    @GetMapping(value = "/export1")
    public void export1( HttpServletResponse response) throws IOException {
        easyExcelService.exportScoreTemplate1(response);
    }
    @GetMapping(value = "/export2")
    public void export2( HttpServletResponse response) throws IOException {
        easyExcelService.exportScoreTemplate2(response);
    }
}
