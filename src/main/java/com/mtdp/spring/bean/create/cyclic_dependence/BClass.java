package com.mtdp.spring.bean.create.cyclic_dependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/6/12
 */
@Component
public class BClass {

    @Autowired
    private AClass aClass;
}
