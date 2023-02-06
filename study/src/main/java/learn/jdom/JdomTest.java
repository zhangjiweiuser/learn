package learn.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JdomTest {

    public static void main(String[] args) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        InputStream in = JdomTest.class.getClassLoader().getResourceAsStream("books.xml");
        Document document = builder.build(in);
        Element element = document.getRootElement();
        List<Element> childElements = element.getChildren();
        for (Element book : childElements) {
            String id = book.getAttributeValue("id");
            System.out.println(id);
            List<Element> bookChilds = book.getChildren();
            for (Element child : bookChilds) {
                System.out.println(child.getText());
                System.out.print("属性名：" + child.getName());
                System.out.println("---属性值：" + child.getValue());
            }
        }
    }
}
