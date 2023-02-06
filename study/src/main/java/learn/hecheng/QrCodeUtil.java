package learn.hecheng;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/30 10:05
 */
public class QrCodeUtil {
    private static final int DAFAULT_WIDTH = 360;
    private static final int DAFAULT_HEIGHT = 360;

    private static final Logger LOGGER = LoggerFactory.getLogger(QrCodeUtil.class);

    public static void main(String[] args) {
        createQrCode("hello");
    }

    public static String createQrCode(String text) {
        return createQrCode(DAFAULT_WIDTH, DAFAULT_HEIGHT, text);
    }

    public static String createQrCode(int width, int height, String text) {
        HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            byte[] bytes = createQrCode2Bytes(width, height, text);
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".png";

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

            ImageIO.write(ImageIO.read(bais),"png",new File("d://erweima.png"));
//            UpYunClient.upload(fileName, bytes);
            return "";
        } catch (Exception e) {
            LOGGER.error("create qrcode error", e);
        }
        return null;
    }


    public static byte[] createQrCode2Bytes(String text) {
        return createQrCode2Bytes(DAFAULT_WIDTH, DAFAULT_HEIGHT, text);
    }

    public static byte[] createQrCode2Bytes(int widht, int height, String text) {
        HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            BitMatrix bitMatrix =
                    new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, widht, height,
                            hints);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ImageIO.write(image, "png", out);
            return out.toByteArray();
        } catch (Exception e) {
            LOGGER.error("create qrcode error", e);
        }
        return null;
    }

    /**
     * 生成条形码并已字节码形式返回，生成的图片格式为png
     *
     * @param contents
     * @param width
     * @param height
     * @return
     */
    public static byte[] createBarcode2Byte(String contents, int width, int height) {
        int codeWidth = 3 + // start guard
                (7 * 6) + // left bars
                5 + // middle guard
                (7 * 6) + // right bars
                3; // end guard
        codeWidth = Math.max(codeWidth, width);
        try {
            BitMatrix bitMatrix =
                    new MultiFormatWriter().encode(contents, BarcodeFormat.CODE_128, codeWidth,
                            height, null);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, "png", out);
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
