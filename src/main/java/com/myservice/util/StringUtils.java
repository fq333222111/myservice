package com.myservice.util; /**
 * StringUtils.java
 * <p>
 * <p>
 * /**
 */

import java.util.Random;
import java.util.UUID;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author lijianhang
 *
 */
public final class StringUtils {

    private static final char[] WORD = {

            /*A-Z*/
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,

            /*a-z*/
            97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122

    };

    private static final char[] NUM = {
            /*0-9*/
            48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
    };

    private static final Pattern pattern = Pattern.compile("((数字\\d+,)|(字母\\d+,)){1,100}");


    private StringUtils() {
    }

    public static boolean isEmpty(String str) {

        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {

        return str != null && str.trim().length() > 0;
    }

    public static String nullToStrTrim(String str) {

        if (str == null) {
            return "";
        }

        return str.trim();
    }

    public static boolean checkString(String str, String regex) {

        return str.matches(regex);
    }

    public static int getLength(String str) {

        if (str == null) {
            str = "";
        }
        return str.replaceAll("[^\\x00-\\xff]", "**").length();
    }

    public static boolean checkMD5(String md5) {

        return checkString(md5, "[0-9A-Fa-f]{32}");
    }

    public static String byte2hex(byte[] b) {

        StringBuilder str = new StringBuilder();
        String stmp = "";

        int length = b.length;

        for (int n = 0; n < length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                str.append("0");
            }
            str.append(stmp);
        }

        return str.toString().toLowerCase();
    }

    public static boolean checkEmail(String email) {

        email = nullToStrTrim(email);
        if (isEmpty(email)) {
            return false;
        }
        if (email.length() < 6 || email.length() > 50) {
            return false;
        }

        String regex = "^[a-zA-Z0-9_.-]+@(([a-zA-Z0-9-])+.)+(?:com|cn|net)$";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher mat = pattern.matcher(email);
        return mat.find();
    }

    public static boolean checkPhone(String phone) {

        return checkString(phone, "1[0-9]{10}");
    }

    public static boolean checkMobile(String mobile) {

        return checkString(mobile, "1[3,4,5,7,8][0-9]{9}");
    }

    /**
     * 获得随机验证码
     *
     * @param numberFlag
     *            是否是数字
     * @param length
     *            长度
     * @return 验证码
     */
    public static String createRandom(boolean numberFlag, int length) {
        StringBuilder retStr = new StringBuilder();
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr.append(strTable.charAt(intR));
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr.toString();
    }


    /**
     * 校验手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * uuid 32
     * @return
     */
    public static String uuid32len() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * uuid 36
     * @return
     */
    public static String uuid36len() {
        return UUID.randomUUID().toString();
    }

    /*数字3,数字10,字母5*/
    public static final String getSerialCodeWithFormat(String formatString) {

        Matcher matcher = pattern.matcher(formatString);
        if (!matcher.find()) {
            return null;
        }
        MatchResult result = matcher.toMatchResult();
        String matchResult = result.group(0);
        String[] splits = matchResult.split(",");

        StringBuilder code = new StringBuilder();

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].startsWith("字母")) {
                code.append(getWordAccess(Integer.valueOf(splits[i].replaceAll("字母", ""))));
            }

            if (splits[i].startsWith("数字")) {
                code.append(getNumberAccess(Integer.valueOf(splits[i].replaceAll("数字", ""))));
            }
        }
        return code.toString();
    }

    public static final String getNumberAccess(int length) {
        StringBuilder ret = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            ret.append(Character.valueOf(NUM[random.nextInt(NUM.length)]));
        }

        return ret.toString();
    }

    public static final String getWordAccess(int length) {
        StringBuilder ret = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            ret.append(Character.valueOf(WORD[random.nextInt(WORD.length)]));
        }

        return ret.toString();
    }

    public static String randomNumber(int min, int max) {
        //生成10个指定范围的随机数
        Random random = new Random();
        int n = random.nextInt(max) + min;
        return String.valueOf(n);
    }

    /**
     * 判断是否是IP
     * @param ip
     * @return
     */
    public static boolean isIp(String ip){
        if(ip.length() < 7 || ip.length() > 15 || "".equals(ip))
        {
            return false;
        }
        /**
         * 判断IP格式和范围
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(ip);

        boolean ipAddress = mat.find();

        return ipAddress;

    }
}
