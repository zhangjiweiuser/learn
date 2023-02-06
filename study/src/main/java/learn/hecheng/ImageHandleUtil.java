package learn.hecheng;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/30 10:19
 */
public class ImageHandleUtil {
    private Font font = null;
    private Graphics2D g = null;

    /**
     * 导入本地图片到缓冲区
     *
     * @param imgName
     * @return
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 导入网络图片到缓冲区
     *
     * @param imgName
     * @return
     */
    public BufferedImage loadImageUrl(String imgName) {
        try {
            URL url = new URL(imgName);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成新图片到本地
     *
     * @param newImage
     * @param img
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                // 目录不存在则创建
                String dirUrl = newImage.substring(0, newImage.lastIndexOf(File.separator));
                File dir = new File(dirUrl);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File outputfile = new File(newImage);
                ImageIO.write(img, "png", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设定文字的字体等
     *
     * @param fontSize
     */
    public void setFont(String name, int style, int fontSize) {
        this.font = new Font(name, style, fontSize);
    }

    /**
     * 修改图片,返回修改后的图片缓冲区（只输出一行文本）,图片居中显示
     *
     * @param img
     * @param content
     * @param y
     * @param color
     * @return
     */
    public BufferedImage modifyImage(BufferedImage img, Object content, int y, Color color) {
        try {
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(color);// 设置字体颜色
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// 抗锯齿
            if (this.font != null) {
                g.setFont(this.font);
            }
            int width = img.getWidth();// 图片宽度
            if (content != null) {
                String str = content.toString();
                int strWidth = g.getFontMetrics().stringWidth(str);// 字体宽度
                g.drawString(str, (width - strWidth) / 2, y);
            }
            g.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y, Color color) {
        try {
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(color);// 设置字体颜色
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// 抗锯齿
            if (this.font != null) {
                g.setFont(this.font);
            }
            if (content != null) {
                String str = content.toString();
                g.drawString(str, x, y);
            }
            g.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    /**
     * 将一张图片画在另一张图片上
     *
     * @param addImage  被添加的图片
     * @param sourceImg 源图
     * @param x
     * @param y
     * @return
     */
    public BufferedImage modifyImagetogeter(BufferedImage addImage, BufferedImage sourceImg, int x,
                                            int y) {
        int width = addImage.getWidth();
        int height = addImage.getHeight();
        try {
            g = sourceImg.createGraphics();
            g.drawImage(addImage, x, y, width, height, null);
            g.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceImg;
    }

    /**
     * @param img1
     * @param img2
     * @param title        标题
     * @param reservePrice 现价
     * @param zkFinalPrice 折扣价
     * @return BufferedImage
     * @throws IOException
     */
    public static BufferedImage mergeImage(BufferedImage img1, BufferedImage img2, String title, String reservePrice, String zkFinalPrice)
            throws IOException {
        Font font = new Font("微软雅黑", Font.BOLD, 20);
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();
        // 新的图
        BufferedImage newImage = new BufferedImage(w1, h2 + h1, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
        graphics.drawImage(img1, 0, 0, null);
//        graphics.drawImage(img2, (newImage.getWidth()) / 2 - (w2 / 2), newImage.getHeight() - h2, null);
        graphics.drawImage(img2, (newImage.getWidth()) - w2 , newImage.getHeight() - h2, null);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);
        int width = graphics.getFontMetrics(font).stringWidth(title);
        int startY = h1+30;
        if (width > newImage.getWidth()) {
            char[] array = title.toCharArray();
            StringBuilder sb = new StringBuilder(array[0]);
            for (char c : array) {
                sb.append(c);
                int newWidth = graphics.getFontMetrics(font).stringWidth(sb.toString());
                if ((newWidth + 19) >= newImage.getWidth()) {
                    // 准备换行
                    graphics.drawString(sb.toString(), 0, startY);
                    startY += 30;
                    sb.delete(0, sb.length());
                }
            }
            graphics.drawString(sb.toString(), 0, startY);
        } else {
            graphics.drawString(title, 0, startY);
        }
        graphics.drawString("现价￥" + reservePrice, 0, startY + 30);
        startY += 30;
        graphics.drawString("卷后价￥" + zkFinalPrice, 0, startY + 30);
        return newImage;
    }
}
