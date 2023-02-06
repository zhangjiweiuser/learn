package learn.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:/aa.txt"));
        Element element = document.getRootElement();
        String rootName = element.getName();
        List<Attribute> attributeIterator = element.attributes();
        for (Attribute attribute : attributeIterator) {
            String attr = attribute.getName();
//            System.out.println("@XStreamAsAttribute");
//            System.out.println("@XStreamAlias(\""+attr+"\")");
            System.out.println("private String " + toLowerCaseFirstOne(attr) + ";");
            System.out.println();
        }
        System.out.println("private String value;");

        System.out.println("================");
        System.out.println("@Override");
        System.out.println("public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {");
        System.out.println(rootName + " " + toLowerCaseFirstOne(rootName) + "=" + "(" + rootName + ") source;");
        for (Attribute attribute : attributeIterator) {
            String attr = attribute.getName();
            System.out.println("writer.addAttribute(\"" + attr + "\", " + toLowerCaseFirstOne(rootName) + ".get" + attr + "());");
        }
        System.out.println("writer.setValue(" + toLowerCaseFirstOne(rootName) + ".getValue());");
        System.out.println("}");
        System.out.println("@Override");
        System.out.println("public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {");
        System.out.println(rootName + " " + toLowerCaseFirstOne(rootName) + "=" + "new " + rootName + "();");
        for (Attribute attribute : attributeIterator) {
            String attr = attribute.getName();
            System.out.println(toLowerCaseFirstOne(rootName) + ".set" + attr + "(reader.getAttribute(\"" + attr + "\"));");
        }
        System.out.println(toLowerCaseFirstOne(rootName) + ".setValue(reader.getValue());");
        System.out.println("return " + toLowerCaseFirstOne(rootName) + ";");
        System.out.println("}");
        System.out.println("@Override");
        System.out.println("public boolean canConvert(Class aClass) {");
        System.out.println("return aClass.equals(" + rootName + ".class);");
        System.out.println("}");
    }

    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return Character.toLowerCase(s.charAt(0)) + s.substring(1);
        }
    }
}
