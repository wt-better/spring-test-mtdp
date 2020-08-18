package com.mtdp.spring.utils.annotation.annotation_utils;

import com.mtdp.spring.utils.annotation.annotation_utils.anno.Reference;
import com.mtdp.spring.utils.annotation.annotation_utils.anno.Service;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/16
 */
@Reference(value = "bean",timeout = 5000)
public class Bean extends AbstractBean{

    @Service(value = "testMethod",classes = {Bean.class})
    public void method(){

    }
}
