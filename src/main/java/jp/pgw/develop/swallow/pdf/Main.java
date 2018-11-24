package jp.pgw.develop.swallow.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class Main {
    public static void main(String[] args) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            PDFont font = PDType0Font.load(document, ClassLoader
                    .getSystemResourceAsStream("ipag.ttf"));
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(0f, 0f);
            contentStream.showText("秋刀魚");
            contentStream.endText();
            contentStream.close();
            document.save("/tmp/test.pdf");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
