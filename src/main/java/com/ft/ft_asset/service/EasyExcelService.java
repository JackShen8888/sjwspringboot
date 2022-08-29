package com.ft.ft_asset.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface EasyExcelService {
    //正常导出
    void exportScoreTemplate1(HttpServletResponse response)throws IOException;
    //自定义模板导出
    void exportScoreTemplate2(HttpServletResponse response)throws IOException;
}
