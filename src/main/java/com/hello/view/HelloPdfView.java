package com.hello.view;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class HelloPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Chapter chapter1 = new Chapter(new Paragraph("Spring Message"), 1);
        chapter1.add(new Paragraph((String)model.get("message")));
        chapter1.add(new Paragraph("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        chapter1.add(new Paragraph("bbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        chapter1.add(new Paragraph("c"));
        chapter1.add(new Paragraph("d"));
        chapter1.add(new Paragraph("e"));
        chapter1.add(new Paragraph("f"));
        chapter1.add(new Paragraph("g"));
        chapter1.add(new Paragraph("h"));

        document.add(chapter1);

        Chapter chapter2 = new Chapter(new Paragraph("Spring Message Two"), 1);
        chapter2.add(new Paragraph("Second Gooooooooooooooooooooooooooooooood"));
        
        document.add(chapter2);
        
        //문서 속성
        //설명 탭
        document.addTitle("Title!!!!!!!!!!!!!!!!");	// 제목
        document.addAuthor("Hyoks");				// 작성자
        document.addSubject("Subject!!!!!!!!!!!!");	// 주제
        document.addKeywords("keywords");			// 키워드
        document.addCreationDate();					// 작성 날짜&수정 날짜
        document.addCreator("Hyooooks");			// 응용 프로그램

        //사용자 정의 탭
        document.addHeader("header1", "header2");	//사용자 정의
    }
}