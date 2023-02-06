package learn.chapter2021.chapter03.chapter0317;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/17 17:06
 */
public class PdfReport {
    public static void main(String[] args) throws IOException, DocumentException {
        // 1. 新建document对象
        Document document = new Document(PageSize.A4);
        // 2. 建立一个书写器(Writer)与document对象关联
        File file = new File("D:/pdfdemo.pdf");
        boolean createNewFileSuccess = file.createNewFile();
        if (!createNewFileSuccess) {
            return;
        }
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        WaterMark watermark = new WaterMark("AUTO HOME");
        writer.setPageEvent(watermark);
        writer.setPageEvent(new MyHeaderFooter());
        // 3. 打开文档
        document.open();
        document.addTitle("Title@Pdf-Java");
        document.addAuthor("author@pdf");
        document.addSubject("subject@itext5");
        document.addKeywords("keywords@itext5");
        document.addCreator("creator@itext5");
        // 4. 像文档中添加内容
        new PdfReport().generatePDF(document);
        // 5. 关闭文档
        document.close();
        watermark.onEndPage(writer, document);
    }

    private static Font titleFont;
    private static Font headFont;
    private static Font keyFont;
    private static Font textFont;
    // 最大宽度
    private static int maxWidth = 520;

    static {
        BaseFont bfChinese = null;
        try {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            titleFont = new Font(bfChinese, 16, Font.BOLD);
            headFont = new Font(bfChinese, 14, Font.BOLD);
            keyFont = new Font(bfChinese, 10, Font.BOLD);
            textFont = new Font(bfChinese, 10, Font.NORMAL);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 生成pdf文件
    public void generatePDF(Document document) throws IOException, DocumentException {
        // 段落
        Paragraph paragraph = new Paragraph("美好的一天从早起开始！", titleFont);
        paragraph.setAlignment(1);// 设置文字居中 0:靠左，1：居中，2：靠右
        paragraph.setIndentationLeft(12);// 设置左缩进
        paragraph.setIndentationRight(12); // 设置右缩进
        paragraph.setFirstLineIndent(24);// 设置首行缩进
        paragraph.setLeading(20f); // 行间距
        paragraph.setSpacingBefore(5f); // 设置段落上空白
        paragraph.setSpacingAfter(10f); // 设置段落下空白
        // 直线
        Paragraph p1 = new Paragraph();
        p1.add(new Chunk(new LineSeparator()));
        // 点线
        Paragraph p2 = new Paragraph();
        p2.add(new Chunk(new DottedLineSeparator()));
        // 超链接
        Anchor anchor = new Anchor("baidu");
        anchor.setReference("http://www.baidu.com");
        // 定位
        Anchor gotoP = new Anchor("goto");
        gotoP.setReference("#top");
        // 添加图片
        Image image = Image.getInstance("https://img-blog.csdn.net/20180801174617455?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNzg0ODcxMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
        image.setAlignment(Image.ALIGN_CENTER);
        image.scalePercent(40);
        // 表格
        PdfPTable table = createTable(new float[]{40, 120, 120, 120, 80, 80});
        table.addCell(createCell("美好的一天", headFont, Element.ALIGN_LEFT, 6, false));
        table.addCell(createCell("早上9:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("中午11:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("中午13:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("下午15:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("下午17:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("下午19:00", keyFont, Element.ALIGN_CENTER));
        int totalQuantity = 0;
        for (int i = 0; i < 5; i++) {
            table.addCell(createCell("起床", textFont));
            table.addCell(createCell("吃午饭", textFont));
            table.addCell(createCell("午休", textFont));
            table.addCell(createCell("下午茶", textFont));
            table.addCell(createCell("回家", textFont));
            table.addCell(createCell("吃晚饭", textFont));
            totalQuantity++;
        }
        table.addCell(createCell("总计", keyFont));
        table.addCell(createCell("", keyFont));
        table.addCell(createCell("", keyFont));
        table.addCell(createCell("", keyFont));
        table.addCell(createCell(totalQuantity + "件事", keyFont));
        table.addCell(createCell("", keyFont));

        document.add(paragraph);
        document.add(anchor);
        document.add(p2);
        document.add(gotoP);
        document.add(p1);
        document.add(table);
        document.add(image);

    }

    public PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public PdfPCell createCell(String value, Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public PdfPCell createCell(String value, Font font, int align, int colspan) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public PdfPCell createCell(String value, Font font, int align, int colspan, boolean boderFlag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        cell.setPadding(3.0f);
        if (boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(0.0f);
            cell.setPaddingBottom(15.0f);
        } else {
            cell.setBorder(0);
            cell.setPaddingTop(15.0f);
            cell.setPaddingBottom(8.0f);
        }
        return cell;
    }

    public PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        table.setTotalWidth(maxWidth);
        table.setLockedWidth(true);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(1);
        return table;
    }
}
