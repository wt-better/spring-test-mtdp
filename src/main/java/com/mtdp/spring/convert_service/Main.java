package com.mtdp.spring.convert_service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/3/3
 */
public class Main {

    /**
     * ConverterFactory:获取Converter
     * 有如下子类：
     * 注意：这些子类都是包级别的访问权限，第三方不能new出该对象
     * NumberToNumberConverterFactory
     * CharacterToNumberFactory
     * etc...
     *
     */
    public static void main(String[] args) {
        ConverterFactory<Number,Number> converterFactory = new NumberToNumberConverterFactory();
        Converter<Number, Long> converter = converterFactory.getConverter(Long.class);
        System.out.println(converter.convert(100));
    }


}
