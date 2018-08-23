package com.chenhm.springboot.util;

/**
 * @author chen-hongmin
 * @date 2018/8/22 10:29
 * @since V1.0
 */
public class StringUtils {

    public static final String PARENTHESES = "{}";

    /**
     * 格式化 数据 默认使用{} 占位符
     *
     * @param source 元数据
     * @param args 占位数据
     * @return 格式化之后数据
     */
    public static String format(String source, Object... args) {

        return format(source, PARENTHESES, args);
    }

    /**
     * 格式化
     *
     * @param source      元数据
     * @param placeholder 占位符
     * @param args        占位数据
     * @return 格式化之后数据
     */
    public static String format(String source, String placeholder, Object... args) {

        if (isEmpty(source) || isEmpty(placeholder)) {
            return source;
        }
        int i = 0;
        while (source.contains(placeholder)) {
            source = source.replaceFirst(escapeExprSpecialWord(placeholder), args[i].toString());
            i++;
        }
        return source;
    }

    /**
     * 是否为空
     *
     * @param source
     * @return
     */
    public static boolean isEmpty(String source) {


        if (source == null || source.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 转义正则特殊字符 （$()*+.[]?\^{},|）
     *
     * @param keyword
     * @return
     */
    public static String escapeExprSpecialWord(String keyword) {

        if (!StringUtils.isEmpty(keyword)) {
            String[] fbsArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|"};
            for (String key : fbsArr) {
                if (keyword.contains(key)) {
                    keyword = keyword.replace(key, "\\" + key);
                }
            }
        }
        return keyword;
    }


    public static void main(String[] args) {

        String source = "hello {},you are {}";
        String format = format(source, "{}", "cc", "sb");
        System.out.println(format);
    }
}
