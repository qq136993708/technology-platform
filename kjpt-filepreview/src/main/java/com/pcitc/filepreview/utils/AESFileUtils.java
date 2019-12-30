package com.pcitc.filepreview.utils;

import org.springframework.util.Base64Utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * <p>
 * AES加密解密工具包
 * </p>
 *
 * @author
 */
public class AESFileUtils {

    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;
    private static final int CACHE_SIZE = 1024;
    private static final String FILE_KEY = "kjptFile";

    private static final byte[] _key = getSecretKey(FILE_KEY);



    /**
     * <p>
     * 生成密钥
     * </p>
     *
     * @param seed 密钥种子
     * @return
     * @throws Exception
     */
    private static byte[] getSecretKey(String seed) {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecureRandom secureRandom = new SecureRandom();
        if (seed != null && !"".equals(seed)) {
            secureRandom.setSeed(seed.getBytes());
        }
        keyGenerator.init(KEY_SIZE, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * <p>
     * 加密
     * </p>
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(_key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }

    /**
     * <p>
     * 文件加密
     * </p>
     *
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static void encryptFile(String sourceFilePath, String destFilePath) throws Exception {
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath);
        if (sourceFile.exists() && sourceFile.isFile()) {
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            destFile.createNewFile();
            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(destFile);

            encrypt(in, out);
        }
    }


    public static void encryptDataToFile(byte[] source, File destFile) throws Exception {

        destFile.createNewFile();

        InputStream in = new ByteArrayInputStream(source);
        OutputStream out = new FileOutputStream(destFile);

        encrypt(in, out);
    }


    public static void encrypt(InputStream in, OutputStream out) throws Exception {

        SecretKeySpec secretKeySpec = new SecretKeySpec(_key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        CipherInputStream cin = new CipherInputStream(in, cipher);
        byte[] cache = new byte[CACHE_SIZE];
        int nRead = 0;
        while ((nRead = cin.read(cache)) != -1) {
            out.write(cache, 0, nRead);
            out.flush();
        }
        out.close();
        cin.close();
        in.close();

    }


    /**
     * <p>
     * 解密
     * </p>
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(_key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }

    /**
     * <p>
     * 文件解密
     * </p>
     *
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static void decryptFile(String sourceFilePath, String destFilePath) throws Exception {
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath);
        if (sourceFile.exists() && sourceFile.isFile()) {
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            destFile.createNewFile();
            FileInputStream in = new FileInputStream(sourceFile);
            FileOutputStream out = new FileOutputStream(destFile);

            decrypt(in, out);
        }
    }


    public static byte[] decryptFileToData(File sourceFile) throws Exception {

        if(sourceFile.exists() == false || sourceFile.isFile() == false){
            return null;
        }

        InputStream in = new FileInputStream(sourceFile);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        decrypt(in, out);

        return out.toByteArray();
    }

    public static void decrypt(InputStream in, OutputStream out) throws Exception {

        SecretKeySpec secretKeySpec = new SecretKeySpec(_key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        CipherOutputStream cout = new CipherOutputStream(out, cipher);

        byte[] cache = new byte[CACHE_SIZE];
        int nRead = 0;
        while ((nRead = in.read(cache)) != -1) {
            cout.write(cache, 0, nRead);
            cout.flush();
        }
        cout.close();
        out.close();
        in.close();

    }

}