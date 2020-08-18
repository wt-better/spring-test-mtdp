package com.mtdp.spring.utils.annotation.annotation_utils;

import com.mtdp.spring.utils.annotation.annotation_utils.anno.Service;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/16
 */
@Service(value = "bean", classes = {Bean.class})
public class AbstractBean implements IBean {

}
