package EncryOrDecry;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SM4Utils {

    private String secretKey = "";

    private String iv = "";

    private boolean hexString = false;

    public SM4Utils(){}

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public boolean isHexString() {
        return hexString;
    }

    public void setHexString(boolean hexString) {
        this.hexString = hexString;
    }

    public String encryptData_ECB(String plainText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;

            byte[] keyBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
            }
            else
            {
                keyBytes = secretKey.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
            String cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0)
            {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptData_ECB(String cipherText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;

            byte[] keyBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
            }
            else
            {
                keyBytes = secretKey.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
            return new String(decrypted, "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String encryptData_CBC(String plainText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            }
            else
            {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("UTF-8"));
            String cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0)
            {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptData_CBC(String cipherText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            }
            else
            {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));
            return new String(decrypted, "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException
    {
        String plainText = "6STAF0pGnhmsq02e52nJHr0eUVNvCnbf04Di%2Bd0Cm9wDkptzRotNJQcByLxAYVbsBG5H0V9ZxzXp6DCgNbKaLGHaY76dhI12uIW9TXdaoW1gkYuLIMG5rFdW8p%2BVqdm/q5ra7Dys/XROac0LKejEDtMqCZvV/wUx/fbnGFa4eGHIPdyeKKL0JNOghbZtuklWmLTpu/pGqMTvtv5K9sdW5WC2fiZDwgvaBajGZO6H4gl2DR%2BZuYH3BWhrEgkZ4CMf%2Bm8jQ9%2Bm54%2BGx5YU%2BI5cwUUDgtU1YeghMdhlOJ7fN3uvZC3ZeS1Qd3rFMvLxzoyO/F5GyILpiC%2B3gV5W31T%2Bj4fajV1zNMsggbbwIX/Lh9x68ujObzkm1A1Sv7tL9qXezngKEp46e/kkgX97ikRlkEKNjRkvoAMMieR7DOwukRQkVinm%2BeAOinkqqQuT%2BcHXflqPKD7bn80QwsGqc3XvFJ/h5zAaHT7Ll1B/4%2BF/9tQuzXypbYxWaEYtGlzXBNww%2B1IKNOWVPtHPPEYHdwO32Yc7dyxZt/yngXmvWUgU1IpXMQGGyO5rfYZ4C70KT/Q4g8gGOI4TcFb66ytoGpi5SBhVAj5yUlLYZLQAGxlMOAp7KgnlxWBCK/DJhjwxezz5sDtWZvYniRXuWqDeNZJr8IMmt/177Ifc%2B6Xwoi4o7TrTh/K8a2SqbaEGGaBY1B60";
        plainText = URLDecoder.decode(plainText,"UTF-8");
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = "9ffb8d835b231e03380f1fb3249c002a";
        sm4.hexString = true;
        sm4.setIv("79696B61746F6E6779696B61746F6E67");
        sm4.setHexString(true);
        String back =sm4.decryptData_CBC(plainText);
        System.out.println(back);


//        System.out.println("ECB模式加密");
//        String cipherText = sm4.encryptData_ECB(plainText);
//        System.out.println("密文: " + cipherText);
//        System.out.println("");

//        plainText = sm4.decryptData_ECB(cipherText);
//        System.out.println("明文: " + plainText);
//        System.out.println("");
//
//        System.out.println("CBC模式加密");
//        sm4.iv = "79696B61746F6E6779696B61746F6E67";
//        cipherText = sm4.encryptData_CBC(plainText);
//        System.out.println("密文: " + cipherText);
//        System.out.println("");
//
//        plainText = sm4.decryptData_CBC(cipherText);
//        System.out.println("明文: " + plainText);

//        System.out.println("CBC模式解密");
//        System.out.println("密文：4esGgDn/snKraRDe6uM0jQ==");
//        String cipherText2 = "4esGgDn/snKraRDe6uM0jQ==";
//        plainText = sm4.decryptData_CBC(cipherText2);
//        System.out.println("明文: " + plainText);
//        System.out.println(Util.hexToByte("4e0c6ddcabdf481f88fcee58afc0be47").length);
//        byte[] b = new byte[]{0x79, 0x69, 0x6b, 0x61, 0x74, 0x6f, 0x6e, 0x67, 0x79, 0x69, 0x6b, 0x61, 0x74, 0x6f, 0x6e, 0x67};
//        System.out.println(Util.byteToHex(b));
//        System.out.println(Util.hexToByte("79696B61746F6E6779696B61746F6E67")[14]);
    }
}
