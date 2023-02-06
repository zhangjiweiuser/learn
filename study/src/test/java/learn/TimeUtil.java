package learn;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/31 14:16
 */
public class TimeUtil {

    @Test
    public void test1() {
        LocalDateTime start = LocalDateTime.of(2020, 8, 31, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2020, 8, 31, 14, 0, 0);
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMinutes());
        System.out.println(duration.toHours());
        System.out.println(start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(start.toLocalDate());
    }

    @Test
    public void test2() {
        long hours = 45;
        System.out.println(new BigDecimal(hours / 24));
        System.out.println(new BigDecimal(36 / 24));
        System.out.println(new BigDecimal(48 / 24));
        System.out.println(new BigDecimal(49 / 24));
    }

    private static final String ENCRY_ALGORITHM = "AES";
    /**
     * 加密算法/加密模式/填充类型
     */
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";
    /**
     * 设置 iv 偏移量
     */
    private static final String IV_ = null;
    /**
     * 设置加密字符集
     */
    private static final String CHARACTER = "UTF-8";
    /**
     * 设置加密密码处理长度。
     */
    private static final int PWD_SIZE = 16;

    /**
     * 加密
     */
    public static String encryptHex(String text, String password) {
        try {
            byte[] cipherTextBytes = encrypt(text.getBytes(CHARACTER),
                    pwdHandler(password));
            String cipherText = byte2hex(cipherTextBytes);
            return cipherText;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String decode(String content, String key) throws Exception {
        byte[] arr = string2ByteArr(content);
        byte[] raw = key.getBytes(CHARACTER);
        SecretKeySpec keySpec = new SecretKeySpec(raw, ENCRY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] original = cipher.doFinal(arr);
        return new String(original, CHARACTER);
    }

    public static byte[] string2ByteArr(String str) {
        byte[] bytes;
        bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    public static byte[] encrypt(byte[] clearTextBytes, byte[] pwdBytes)
            throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(pwdBytes,
                ENCRY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] cipherTextBytes = cipher.doFinal(clearTextBytes);
        return cipherTextBytes;
    }

    /**
     * 密码处理方法
     */
    private static byte[] pwdHandler(String password) throws
            UnsupportedEncodingException {
        byte[] data = null;
        if (password == null) {
            password = "";
        }
        StringBuffer sb = new StringBuffer(PWD_SIZE);
        sb.append(password);
        while (sb.length() < PWD_SIZE) {
            sb.append("0");
        }
        if (sb.length() > PWD_SIZE) {
            sb.setLength(PWD_SIZE);
        }
        data = sb.toString().getBytes("UTF-8");
        return data;
    }

    public static String byte2hex(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        String tmp = "";
        for (int n = 0; n < bytes.length; n++) {
            tmp = (java.lang.Integer.toHexString(bytes[n] & 0XFF));
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        System.out.println("----密码" + sb.toString());
        return sb.toString().toUpperCase();
    }

    @Test
    public void test3() throws Exception {
        String test = encryptHex("test", "uzO0alsedFUzKVVu");
        System.out.println(test);
        String deco = decode(test, "uzO0alsedFUzKVVu");
        System.out.println(deco);
    }
}
