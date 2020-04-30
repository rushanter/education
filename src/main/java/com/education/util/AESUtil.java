package com.education.util;

import com.education.service.impl.WeChatServiceImpl;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Security;

public class AESUtil {

    private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);

    public static final AESUtil instance = new AESUtil();

    public static boolean initialized = false;

    /**
     * AES解密
     *
     * @param content 密文
     * @return
     */
    public static String decrypt(String content, String key, String iv) {
        try {
            initialize();
            byte[] contentByte = Base64Utils.decode(content.getBytes());
            byte[] keyByte = Base64Utils.decode(key.getBytes());
            byte[] ivByte = Base64Utils.decode(iv.getBytes());

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));
            return new String(cipher.doFinal(contentByte), "UTF-8");
        } catch (Exception e) {
            logger.info("AES解密失败");
            return null;
        }
    }

    private static void initialize() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    private static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }
}
