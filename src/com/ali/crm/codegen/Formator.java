package com.ali.crm.codegen;

import org.apache.commons.lang.StringUtils;

public class Formator {
    public static String echo(String str) {
        return str;
    }

    //所有的输入参数都必须是单词以"_"分隔的字符串
    public String XyzAbc(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            } else {
                words[i] = words[i].substring(0, 1).toUpperCase();
            }
        }
        result = StringUtils.join(words, "");
        return result;
    }

    //如果第一个单词仅一个字母，小写开头，否则与XyzAbc等效
    //Ibatis DO里属性的get/set名适用
    public String beanXAbc(String str) {
        if (str != null && str.length() > 1 && "_".equals(str.substring(1, 2))) {
            return str.substring(0, 1).toLowerCase() + XyzAbc(str.substring(2));
        } else {
            return XyzAbc(str);
        }
    }

    public String XYZ_ABC(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toUpperCase();
        }
        result = StringUtils.join(words, "_");
        return result;
    }

    public String Xyz_Abc(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            } else {
                words[i] = words[i].substring(0, 1).toUpperCase();
            }
        }
        result = StringUtils.join(words, "_");
        return result;
    }

    public String xyz_abc(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        result = StringUtils.join(words, "_");
        return result;
    }

    public String xyzabc(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        result = StringUtils.join(words, "");
        return result;
    }

    public String XYZABC(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toUpperCase();
        }
        result = StringUtils.join(words, "");
        return result;
    }

    public String xyzAbc(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                if (words[i].length() > 1) {
                    words[i] = words[i].substring(0, 1).toLowerCase() + words[i].substring(1).toLowerCase();
                } else {
                    words[i] = words[i].substring(0, 1).toLowerCase();
                }
            } else {
                if (words[i].length() > 1) {
                    words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                } else {
                    words[i] = words[i].substring(0, 1).toUpperCase();
                }
            }
        }
        result = StringUtils.join(words, "");
        return result;
    }

    public String Xyzabc(String str) {
        if (StringUtils.isEmpty(str))
            return "";
        String result;
        String[] words = StringUtils.split(str, "_");
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                if (words[i].length() > 1) {
                    words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                } else {
                    words[i] = words[i].substring(0, 1).toUpperCase();
                }
            } else {
                words[i] = words[i].toLowerCase();
            }
        }
        result = StringUtils.join(words, "");
        return result;
    }
}
