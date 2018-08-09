package com.chenhm.springboot.util;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author chen-hongmin
 * @date 2018/8/9 15:02
 * @since V1.0
 */
public class StringFormatUtils {

    /**
     * sql 中占位符
     */
    private final static String SQL_PLACEHOLDER = "?";

    public static String formatSql(String source, List<Object> values) {

        if (source == null || source.trim().length() == 0) {
            return "";
        }
        if (values.size() == 0) {
            return source;
        }
        int i = 0;

        while (source.contains(SQL_PLACEHOLDER)) {
            source = source.replaceFirst("\\?", values.get(i).toString());
            i++;
        }
        source = source.replace("\n", "");
        source = source.replaceAll("\\s{2,}", " ");

        return source;
    }

    public static void main(String[] args) {

        String source = "select * from table where id = ? and name = ?";
//        String chenhm = formatSql(source, "1", "chenhm");

//        System.out.println(chenhm);
    }
}
