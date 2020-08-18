package com.mtdp.spring.meta_data;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/5/19
 */
public class AnnotationMetadataTest {

    public static void main(String[] args) {
        AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(AnnotationClass.class);

        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes("org.springframework.stereotype.Service");
        System.out.println(annotationAttributes);
    }
}

@Service(value = "annotationClass")
@ComponentScan
class AnnotationClass {

}
