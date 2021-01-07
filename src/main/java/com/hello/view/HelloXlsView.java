package com.hello.view;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class HelloXlsView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //데이터 가져오기
        List<String> list = (List<String>)model.get("oop");

        //시트 만들기
        Sheet sheet = workbook.createSheet();

        //시트이름 만들기
        workbook.setSheetName(0, "객체 지향");
        
        //컬럼 너비 설정
        sheet.setColumnWidth(0, 256*20);

        //제목 셀 만들기
        Row firstRow = sheet.createRow(0);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("객체 지향 언어의 3대 특징");

        //데이터 출력
        int rowIdx = 1;
        for(String str : list) {
            Row row = sheet.createRow(rowIdx++);
            Cell cell = row.createCell(0);
            cell.setCellValue(str);
        }
    }
}