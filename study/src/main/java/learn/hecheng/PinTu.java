package learn.hecheng;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/30 10:18
 */
public class PinTu {
    public static void main(String[] args) {
        pintu();
    }

    private static void pintu() {
        InputStream buffin = null;
        try {
            // 二维码
            // 高额卷分享链接
            String couponUlr = "https://www.baidu.com";
            byte[] imgByte = QrCodeUtil.createQrCode2Bytes(250, 250, couponUlr);
            buffin = new ByteArrayInputStream(imgByte);
            BufferedImage couponImage = ImageIO.read(buffin);
            // 商品主图
            String imageUrl = "https://static001.geekbang.org/infoq/1e/1ee0db98c4c96fbbfeb72f954aadc076.jpeg?x-oss-process=image/resize,w_416,h_234";
            URL url = new URL(imageUrl);
            BufferedImage picImage = ImageIO.read(url);
            BufferedImage modifyImage =
                    ImageHandleUtil.mergeImage(picImage, couponImage, "大回馈",
                            "1299", "998");
//            response.setContentType("image/jpg");
//            os = response.getOutputStream();
//            ImageIO.write(modifyImage, "jpg", os);
//            os.flush();

            ImageIO.write(modifyImage, "png", new File("d://erweima.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
