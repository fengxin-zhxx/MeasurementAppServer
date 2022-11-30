package util;

import java.io.UnsupportedEncodingException;

public class StringUtil {
    public static String getEncoding(String str) {
        String[] sEncodeArr = {"UTF-8","GBK"};
        for (int i = 0; i < sEncodeArr.length; i++) {
            try {
                if (str.equals(new String(str.getBytes(sEncodeArr[i]), sEncodeArr[i]))) {
                    return sEncodeArr[i];
                }
            } catch (Exception e) {
            }
        }
        return "";
    }

    public static String toUTF_8(String str) throws UnsupportedEncodingException {
        return changeCharset(str, "UTF-8");
    }
    public static String changeCharset(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用默认字符编码解码字符串。
            byte[] bs = str.getBytes();
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }
}