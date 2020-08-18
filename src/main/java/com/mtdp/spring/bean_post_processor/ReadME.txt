一、在spring容器初始化的过程中会注册BeanPostProcessor
注册的顺序是：
0、注册BeanPostProcessorChecker，作用是检查对应bean应用的BeanPostProcessor个数是否和全局beanFactory中的个数相同
    如果bean应用的BeanPostProcessor个数小于全局的个数，将会有如下的日志：
    信息: Bean 'xxx' of type [xxx] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
    （一般造成这样的结果是BeanPostProcessor依赖了其他的springBean，导致该bean提前初始化导致，以至于后续注册的BeanPostProcessor对该Bean无效）

1、注册实现了BeanPostProcessor接口和PriorityOrdered接口的BeanPostProcessor
2、注册实现了BeanPostProcessor接口和Ordered接口的BeanPostProcessor
3、注册其他BeanPostProcessor接口的实现
4、注册MergedBeanDefinitionPostProcessor类型的实现
5、最后注册ApplicationListenerDetector，用来探测ApplicationListener的bean并注册

二、BeanPostProcessor的类型
    1、InstantiationAwareBeanPostProcessor

    2、SmartInstantiationAwareBeanPostProcessor

    3、BeanPostProcessor

    4、DestructionAwareBeanPostProcessor



