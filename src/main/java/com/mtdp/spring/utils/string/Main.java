package com.mtdp.spring.utils.string;

import org.springframework.util.StringUtils;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/3/10
 */
public class Main {

    private String placeholderPrefix = "${";
    private String simplePrefix = "{";
    private String placeholderSuffix = "}";


    private int findPlaceholderEndIndex(CharSequence buf, int startIndex) {
        int index = startIndex + this.placeholderPrefix.length();
        int withinNestedPlaceholder = 0;
        while (index < buf.length()) {
            if (StringUtils.substringMatch(buf, index, this.placeholderSuffix)) {
                if (withinNestedPlaceholder > 0) {
                    withinNestedPlaceholder--;
                    index = index + this.placeholderSuffix.length();
                } else {
                    return index;
                }
            } else if (StringUtils.substringMatch(buf, index, this.simplePrefix)) {
                withinNestedPlaceholder++;
                index = index + this.simplePrefix.length();
            } else {
                index++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String propertyHolder = "${hello}";
        System.out.println(propertyHolder.length());
        System.out.println(main.findPlaceholderEndIndex(propertyHolder, 1));
    }
}
