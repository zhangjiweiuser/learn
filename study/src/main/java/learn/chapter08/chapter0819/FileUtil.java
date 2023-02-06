package learn.chapter08.chapter0819;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/19 10:49
 */
public class FileUtil {
    public static void main(String[] args) throws IOException {
        List<String> result = FileUtils.readLines(new File("D:/lingquan.txt"), Charset.forName("utf-8"));
        System.out.println(result.get(0));
    }
}
