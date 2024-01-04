package com.juzihulian.tianhe.encrypt;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 * 加解密工具类
 */
public final class RsaEncrypUtil {

  public static final String CHARSET = "UTF-8";
  /**
   * 密钥算法
   */
  public static final String ALGORITHM_RSA = "RSA";
  public static final String ALGORITHM_RSA_SIGN = "SHA256WithRSA";
  public static final int ALGORITHM_RSA_PRIVATE_KEY_LENGTH = 2048;

  private RsaEncrypUtil() {
  }

  /**
   * 初始化RSA算法密钥对
   *
   * @param keysize RSA1024已经不安全了,建议2048
   * @return 经过Base64编码后的公私钥Map, 键名分别为publicKey和privateKey
   */
  public static Map<String, String> initRSAKey(int keysize) {
    if (keysize != ALGORITHM_RSA_PRIVATE_KEY_LENGTH) {
      throw new IllegalArgumentException(
          "RSA1024已经不安全了,请使用" + ALGORITHM_RSA_PRIVATE_KEY_LENGTH + "初始化RSA密钥对");
    }
    //为RSA算法创建一个KeyPairGenerator对象
    KeyPairGenerator kpg;
    try {
      kpg = KeyPairGenerator.getInstance(ALGORITHM_RSA);
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalArgumentException("No such algorithm-->[" + ALGORITHM_RSA + "]");
    }
    //初始化KeyPairGenerator对象,不要被initialize()源码表面上欺骗,其实这里声明的size是生效的
    kpg.initialize(ALGORITHM_RSA_PRIVATE_KEY_LENGTH);
    //生成密匙对
    KeyPair keyPair = kpg.generateKeyPair();
    //得到公钥
    Key publicKey = keyPair.getPublic();
    String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());
    //得到私钥
    Key privateKey = keyPair.getPrivate();
    String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
    Map<String, String> keyPairMap = new HashMap<String, String>(2);
    keyPairMap.put("publicKey", publicKeyStr);
    keyPairMap.put("privateKey", privateKeyStr);
    return keyPairMap;
  }


  /**
   * RSA算法公钥加密数据
   *
   * @param data 待加密的明文字符串
   * @param key  RSA公钥字符串
   * @return RSA公钥加密后的经过Base64编码的密文字符串
   */
  public static String buildRSAEncryptByPublicKey(String data, String key) {
    try {
      //通过X509编码的Key指令获得公钥对象
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(key));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
      Key publicKey = keyFactory.generatePublic(x509KeySpec);
      //encrypt
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
      return Base64.encodeBase64String(
          rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET)));
    } catch (Exception e) {
      throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
    }
  }

  /**
   * RSA算法公钥解密数据
   *
   * @param data 待解密的经过Base64编码的密文字符串
   * @param key  RSA公钥字符串
   * @return RSA公钥解密后的明文字符串
   */
  public static String buildRSADecryptByPublicKey(String data, String key) {
    try {
      //通过X509编码的Key指令获得公钥对象
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(key));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
      Key publicKey = keyFactory.generatePublic(x509KeySpec);
      //decrypt
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(Cipher.DECRYPT_MODE, publicKey);
      //return new String(cipher.doFinal(Base64.decodeBase64(data)), CHARSET);
      return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data)),
          CHARSET);
    } catch (Exception e) {
      throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
    }
  }

  /**
   * RSA算法私钥加密数据
   *
   * @param data 待加密的明文字符串
   * @param key  RSA私钥字符串
   * @return RSA私钥加密后的经过Base64编码的密文字符串
   */
  public static String buildRSAEncryptByPrivateKey(String data, String key) {
    try {
      //通过PKCS#8编码的Key指令获得私钥对象
      PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(key));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
      Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
      //encrypt
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(Cipher.ENCRYPT_MODE, privateKey);
      return Base64.encodeBase64String(
          rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET)));
    } catch (Exception e) {
      throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
    }
  }

  /**
   * RSA算法私钥解密数据
   *
   * @param data 待解密的经过Base64编码的密文字符串
   * @param key  RSA私钥字符串
   * @return RSA私钥解密后的明文字符串
   */
  public static String buildRSADecryptByPrivateKey(String data, String key) {
    try {
      //通过PKCS#8编码的Key指令获得私钥对象
      PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(key));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
      Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
      //decrypt
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(Cipher.DECRYPT_MODE, privateKey);
      //return new String(cipher.doFinal(Base64.decodeBase64(data)), CHARSET);
      return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data)),
          CHARSET);
    } catch (Exception e) {
      throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
    }
  }


  /**
   * RSA算法使用私钥对数据生成数字签名
   *
   * @param data 待签名的明文字符串
   * @param key  RSA私钥字符串
   * @return RSA私钥签名后的经过Base64编码的字符串
   */
  public static String buildRSASignByPrivateKey(String data, String key) {
    try {
      //通过PKCS#8编码的Key指令获得私钥对象
      PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(key));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
      PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
      //sign
      Signature signature = Signature.getInstance(ALGORITHM_RSA_SIGN);
      signature.initSign(privateKey);
      signature.update(data.getBytes(CHARSET));
      return Base64.encodeBase64String(signature.sign());
    } catch (Exception e) {
      throw new RuntimeException("签名字符串[" + data + "]时遇到异常", e);
    }
  }

  /**
   * RSA算法使用公钥校验数字签名
   *
   * @param data 参与签名的明文字符串
   * @param key  RSA公钥字符串
   * @param sign RSA签名得到的经过Base64编码的字符串
   * @return true--验签通过,false--验签未通过
   */
  public static boolean buildRSAverifyByPublicKey(String data, String key, String sign) {
    try {
      //通过X509编码的Key指令获得公钥对象
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(key));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
      PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
      //verify
      Signature signature = Signature.getInstance(ALGORITHM_RSA_SIGN);
      signature.initVerify(publicKey);
      signature.update(data.getBytes(CHARSET));
      return signature.verify(Base64.decodeBase64(sign));
    } catch (Exception e) {
      throw new RuntimeException("验签字符串[" + data + "]时遇到异常", e);
    }
  }

  /**
   * RSA算法分段加解密数据
   *
   * @param cipher 初始化了加解密工作模式后的javax.crypto.Cipher对象
   * @param opmode 加解密模式,值为javax.crypto.Cipher.ENCRYPT_MODE/DECRYPT_MODE
   * @return 加密或解密后得到的数据的字节数组
   */
  private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas) {
    int maxBlock = 0;
    if (opmode == Cipher.DECRYPT_MODE) {
      maxBlock = ALGORITHM_RSA_PRIVATE_KEY_LENGTH / 8;
    } else {
      maxBlock = ALGORITHM_RSA_PRIVATE_KEY_LENGTH / 8 - 11;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;
    byte[] buff;
    int i = 0;
    try {
      while (datas.length > offSet) {
        if (datas.length - offSet > maxBlock) {
          buff = cipher.doFinal(datas, offSet, maxBlock);
        } else {
          buff = cipher.doFinal(datas, offSet, datas.length - offSet);
        }
        out.write(buff, 0, buff.length);
        i++;
        offSet = i * maxBlock;
      }
    } catch (Exception e) {
      throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
    }
    byte[] resultDatas = out.toByteArray();
    IOUtils.closeQuietly(out);
    return resultDatas;
  }

  public static void main(String[] args) {
    for(int i=0;i<13;i++){
    Map<String, String> stringStringMap = RsaEncrypUtil.initRSAKey(2048);
    System.out.println(stringStringMap.get("publicKey"));

    }
//    System.out.println(stringStringMap.get("privateKey"));
//    String str = "aaa";
//    String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnHKkOoiPigFVEPakamc_pP7d4JU9PtYcHPhXCa12HaPagHHqC7q-fluBkpQ1Het4-_2Yn2WUHyRigvEBEOPer1s0fXbL34r9H-iNZKD4zAyrhmJ4lJ7NWr2FMYbPZElqEjhC89xNaw5RKy5izyjWhlK8oSJJ4VbAJ9MSBlneAZ7WTcFV3AWNaOKV84eeOB689lvgVRGVIgsXAAHJVhZ2aTJQj6EG5DlgkB3m64RfmGqofTFU6m5yW1te0k-3BmxcdAoPvRnXBmj8z5OIFlgDqdhdEBB5AbN_djefaE3i_YmfgsITuzi3JZJiqtjsn2_HR42DIrionhLHgJX87i1XBQIDAQAB";
//
//    String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCccqQ6iI-KAVUQ9qRqZz-k_t3glT0-1hwc-FcJrXYdo9qAceoLur5-W4GSlDUd63j7_ZifZZQfJGKC8QEQ496vWzR9dsvfiv0f6I1koPjMDKuGYniUns1avYUxhs9kSWoSOELz3E1rDlErLmLPKNaGUryhIknhVsAn0xIGWd4BntZNwVXcBY1o4pXzh544Hrz2W-BVEZUiCxcAAclWFnZpMlCPoQbkOWCQHebrhF-Yaqh9MVTqbnJbW17ST7cGbFx0Cg-9GdcGaPzPk4gWWAOp2F0QEHkBs392N59oTeL9iZ-CwhO7OLclkmKq2Oyfb8dHjYMiuKieEseAlfzuLVcFAgMBAAECggEAW3UJXM6IWvz8ZbZJ14oUQrhbrPaRnzI7rRPgjd_BtQIcsgnl8IVy5xtHXBEYHC2TxHwzxLr1JF9412NcZCtR-uEuhkn0VPJDl2uzfKg9yct-WkkmhHtxQSKZwqI0i0P_pjcNrNGU0IjGGqA7Uy9keZHUg74vwnOcUauqVdwjVH5DTecm6S6SMURmbOVA3HL6U3tvz010S6r6CubMYBbrPVRNc9NAfasAFlY8mzBvVGeMqTY_YyTjk0hlJc945yx8xkKjpIp_AbUFwnDjavuXAMBcuMijsMfUwAr1Xw6WihFyM3vb2C4DPJIiMBr4gHWceDNU_-AdX1AJXLNYrt7u4QKBgQDdTmBRl65IkCIL8nNbnmhPNt3q2FZ-FglcLYop6nM1XAkwXMYl2X9b-6LCXiY0ytX3Hr7pdkdQdzjnmj-EcoZsw0kQgpoMpJJM_avFlKXfqtWZhEpcpytDq_HKK0JUQCXuknFTkqLV_Vp34-wIKLcAjV98_wmziptvoN4EJR0r8wKBgQC0-VJxy7U4xEm1dIToFpz97b8L0D9DI_W3rrMfuM5ROFskUFugFj_wlB43hP67ULcqLI2f8CROyvveIitBO9IGOv6ebOukBrkTaWh-6Z7iHAqjhK6Pbz_e8CzHilDaNw4UcMhjpygO85T98-aUoZsg-a_HrnlcCSqhLwQA5VgHJwKBgQDMptcBfRApgEhL3gh5mDKD1ow_yZGqhbxgJqjW_D1QAe1pcNG4XLqfGEO6FJCmT1Cwdxk7Eir-qVHRM147oCDZYXomr2-_80xrsEXxr_X4saVXkvOlXN3wdYhiWcC74ppxVbFBBKBa3TCVIAu8u9IHy7SbBco14x68ivnkwWGJqwKBgQCcMLpZAElNzwsWkpPKgwnHlpNWLMsMtVJyz1JFRIi8THlM5BXQGqPgjNVvcVcwbz9GJOGuceHEJygt1Sujx29CdVQfgz30eODuwgCv2A2KdE0yR2co4Akt7feX1-ZkDzQVrCkm6LOIA-5JJ2GQUdHDKfvtyMVxC3BBYISCCW5p7QKBgECFLM_idUUFNtNTnVTs0do5A-_xVgF9G8mvJH39NHwxs8ezcjOYJyo7hICtsNM71NbjUJpu4j8Rcd9QeBV3FvkkF7X0ahXsHsRee8qMxR7wSqXwGhUIY58EhEA9Tf6e__JtKritL2hmZcphag1C1uRhdDKqaSX_Wt7bVdMRJqgE";
//
//    String encry = RsaEncrypUtil.buildRSAEncryptByPublicKey(str, publicKey);
//    System.out.println(encry);
//
//    System.out.println(RsaEncrypUtil.buildRSADecryptByPrivateKey(encry,privateKey));

//    String s = "BV53yR6y0ycwzVNfbbiZF3eCdjgDWPGzf02vGhG4gNLhOAuoVOfmtLEBaaGA1meI+7dF94F3eChjLt5AxZ3CKurEqKRgUwwyu7yKtviTclMeAm7k2EUDA31xaDz9DlIO9WFhzPB56VM6LCCuPlOVaHm1sJmoK20kYBIP2KF8CDqczMcvUhjPkbzwbU1bQPYMEJZDYHtt2W3VwRbHsCoi9w2fp3i7xMpxhsfKVN+wayt+7mo+w4WBxm4DyGSV01SVjcMPHSZrCeGNmTaMH2/zqZAwZqD6zCQCt7Bsiq5rIPq7dLNufIAtDIx6VCsGQWKUHF9YsTMT5GmDz+hhoNe4LQ==";
//    System.out.println(RsaEncrypUtil.buildRSADecryptByPrivateKey(encry,privateKey));
//    String sign = "fBMCMZfXm+WhOgM8aQ2GBql2iXEbBreNE2UDRjw9UAHOFHw1TICYbOBCMSD0rkSi5OfjQjZOJxeqHCa/4NjsUlIa45JXcHrzdz24i6SBczvlG8Qm/q21ilO89Xy8XIUWrXfEGGMPrNX8aV6Alikt+YbTTVo9eU/oqgCHxCHCjMaPzDYhmTcOXj/3fuYZGbomR+8yqOqBUGScXPK4XD4Fmy46wHtC/lX2Jk7mCmgqvVL8t5AGSmv4dk2jF4+i49vqVUQyoWQ4s43Z1CbH1Zf6CbhpjlDk5Sc+WNvHQfkqBisq3nIVXFbCjlmEQEH79PK0wSlYiiUkiZFJeT4mUi7aSg==";
//
//    System.out.println(RsaEncrypUtil.buildRSAverifyByPublicKey(s,privateKey,sign));
  }
}
