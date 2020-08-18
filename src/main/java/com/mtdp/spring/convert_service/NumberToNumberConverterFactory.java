package com.mtdp.spring.convert_service;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.NumberUtils;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/3/3
 */
public final class NumberToNumberConverterFactory implements ConverterFactory<Number, Number> {

    @Override
    public <T extends Number> Converter<Number, T> getConverter(Class<T> targetType) {
        return new NumberToNumberConverter<>(targetType);
    }

    private static class NumberToNumberConverter<T extends Number> implements ConditionalConverter, Converter<Number, T> {

        private Class<T> targetClassType;

        NumberToNumberConverter(Class<T> targetType) {
            this.targetClassType = targetType;
        }


        @Override
        public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
            return false;
        }

        @Override
        public T convert(Number source) {
            return NumberUtils.convertNumberToTargetClass(source, targetClassType);
        }
    }
}
