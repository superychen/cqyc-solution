#spring全家桶、mysql、微服务

##spring全家桶
1、**`介绍下spring的ioc`**
    ioc就是控制反转的意思，控制反转就是原来这个对象的控制权在我们代码中，我们自己new对象，在spring中，应用程序不再控制对象的创建，被动的接受由容器注入的对象。
        没有spring，我们使用的对象，需要自己创建，有了ioc后，对象由ioc容器创建并管理，想使用直接从容器取。
    优点：01、使用者不用关心bean实现细节 02：不用创建多个相同bean  03、bean的修改使用方无需感知
    
2、**`介绍下spring的Aop`**
    面向切面编程，把公共的逻辑抽出来，让开发者专注于逻辑开发。有如下概念：01、aspect（切面，由切入点和通知组成）02、pointCut（切入点，条件定义）03、Advice（通知。切面的具体行为，由4中通知）
        04、joinPoint（连接点，程序运行时的执行点）05、weaving（织入，将切面和业务连接起来，编译时是静态代理，运行时动态代理）
    如何实现的AOP：01：在bean初始化流程的过程中，beanPostProcessor后置方法时创建代理对象，里面有一个wrapIfNecessary方法。 02：在这个方法里面有一个校验，如果存在advice，就创建代理对象。
        03：创建代理对象在createProxy方法中，createProxy的主要作用时根据给定的bean类、bean名称、特定拦截器和目标源，创建代理对象。
        04：这里面创建aop是通过代理模式实现的，有两种实现方式，一种基于jdk动态代理，一种基于Cglib动态管理。默认使用jdk动态代理，缺点是不能没有接口的类。
        
3、**`为什么spring不建议使用基于字段的依赖注入？`**
    01：单一职责问题，根据设计原则，一个类的设计应该符合单一职责原则，我们基于字段注入的时候，随着业务保证，字段越来越多，其实已经违背了单一职责。
        02：可能产生NPE：对于bean初始化顺序为：静态变量或静态语句块 -> 实例变量或初始化语句块 -> 构造方法 -> @Autowired，如果在构造器中获取bean信息，会出现NPE。
        03：隐藏依赖：应该显式通知容器，比如构造起或setter通知，外部容器不应该感知bean内部私有字段，会破坏封装性。
    spring支持哪些注入方式：
        01：字段注入 02：构造起注入（如果两个bean循环依赖的话，构造器会出现循环引用的问题，这个时候可以在某一个构造起中加@Lazy注解，延迟加载） 03：setter注入

4、**`spring bean的初始化过程`**
    spring初始换过程分5个小阶段：实例化、初始化、注册destruction回调、bean的正常使用、bean的销毁。
    01：实例化是创建对象的过程，通过调用类的构造器创建bean实例，属于生命周期开始阶段，对应doCreateBean中的createBeanInstance方法。
    02：初始化是Bean创建之后，进行一些设置或准备工作。包括bean的属性，调用各种前置和后置处理器。对应doCreateBean中的populateBean和initializeBean。
    03：实例化+初始化代码实现：01：创建bean实例的代码主要是在createBeanInstance方法，它里面逻辑是先确保bean对应类有没有被加载，如果有工厂方法，调用工厂方法创建这个bean，没有的话调用它的
        构造器方法创建bean。 02：然后就是初始化，在初始化前，会有一段解决三级循环依赖的代码。03：初始化的第一步就是设置属性值（对应方法就是populateBean方法），它负责将属性值应用到bean实例中，
        处理了自动装配、属性注入、依赖检查。04：initializeBean方法，这是初始化关键方法，第一步先检查Aware，看这个Bean是不是显现了BeanNameAware、BeanFactoryAware等aware接口，实现了
        就调用它们的构造方法执行。第二步调用BeanPostProcessor前置处理方法，在bean初始化前添加一些自己的逻辑处理。第三步就是调用afterPropertiesSet方法或者自定义init-method方法。
        第四步就是beanPostProcessor后置处理方法,除了会调用自定义的后置方法外，还会调用wrapIfNecessary方法创建AOP代理。

5、**`spring的事务传播机制`**
    spring事务传播机制用于控制多个事务方法相互调用时的事务行为。spring事务规定了7中事务传播级别，默认是REQUIRED：
    01：REQUIRED：如果不存在事务就开启事务，存在事务就加入事务，保证只有一个事务运行。02：REQUIRES_NEW：每次执行新开一个事务，如果当前存在事务，就挂起事务
    03：SUPPORTS：有事务加入事务，没事务就普通执行。04：NOT_SUPPORTED：有事务暂停事务，没有普通执行。05、MANDATORY：强制有事务，没有事务报异常
    06：NEVER：有事务则报异常 07、NESTED：有事务就创建嵌套事务，嵌套事务不影响父事务，父事务影响嵌套事务。

6、**`Autowired和Resource的关系？`**
    相同点：两个注解功能基本是等价的，可以将bean注入到filed。不同点：byName和Type匹配顺序不同，Autowired是先通过ByType，然后在ByName的方式。
Resource在获取bean，是先通过byName方式，在是byType方式

7、**`beanFactory和factoryBean关系？`**
    01、BeanFactory比较常用，bean工厂，整个ioc容器的一部分，负责管理bean的创建和生命周期。比如applicationContext，其实就是一种BeanFactory。
    02、FactoryBean是一个接口，定义工厂bean，可以生产某种类型的对象，定义一个bean后，实现了factoryBean，返回的不是bean实例，而是getObject中的得到的对象，比如
        dubbo中的dubboReference，这个是用来创建远程服务代理对象。factoryBean通常用来创建复杂对象，比如通过特定的创建过程获取的对象。
        
8、**`spring在业务常见的使用方式`**
    01、通过IOC实现策略模式。02、通过AOP实现通用参数拦截校验、日志打印、缓存逻辑什么的。 03、通过Event异步解耦（spring中的event有同步模式和异步模式）。
    04、通过spring管理事务
    
9、**`spring如何开启事务`**
    01、编程式事务，基于底层的api，如PlatformTransactionManager、TransactionDefinition、transactionTemplate等核心接口，开发者通过编程的方式进行事务管理。
    02、声明式事务，可以基于注解或xml的方式管理事务。优点：01：使用aop实现，本质在目标方法执行前后拦截，对代码没有侵入性，只需要写业务逻辑即可。
           缺点：01、粒度问题（最小到方法上） 02、用错方式导致事务不生效
    事务失效原因：
     01、代理（AOP）失效情况：1、@Transactional用在非puclic方法上（private只会在当前对象调用，不会走到代理对象）
        2、同一个类中方法调用，导致失效（根private一样，无法走到代理对象）3、final、static方法：代理对象无法对final方法进行覆盖，static方法属于这个类，并不是对象的。
     02、@transactional方式不对：如使用注解属性propagation设置错误，如not_supported，只会在非事务下执行。还就是rollbackFor设置错误。
     03、异常被捕获。   04、事务中用了多线程，transactional使用ThreadLocal机制存储事务上下文，新线程是不会包含原有的事务。
                    
10、**`spring中用到的设计模式`**
    01、工厂模式  02、适配器模式（springMvc中的HandlerAdapter，用于controller注解解析和url映射就是通过requestMappingHandlerAdapter实现）
    03、代理模式（spring aop） 04、单例模式（bean的singleton）05、模版方法模式（事务管理中的transactionTemplate，
        把事务管理设置为三个步骤模版实现，1：执行事务逻辑 2、异常回滚事务 3、提交事务） 06、责任链模式（springMVC中拦截器，如核心类handlerExecutionChain）

11、**`spring中的循环依赖问题`**
    循环依赖是指两个或者多个bean之前相互依赖，形成一个循环引用的情况，不处理会导致应用程序启动失败。spring中解决循环依赖的方式是引入三级缓存，但是有限制：
        01：相互依赖的bean必须是单例bean 02：依赖注入的方式不能都是构造器注入。
    为什么只支持单例：spring循环依赖的解决方案主要是通过对象的提前暴露实现的，创建过程中引用到另一个创建的对象，会提前暴露一个尚未完全初始化的对象实例，就是半成品。
        单例创建和初始化只会发生一次，所以依赖关系不会变化，可以通过半成品对象解决循环依赖。prototype原型对象会创建多次，运行过程中是动态的。
    为什么不支持构造函数注入：在对象实例化过程中，构造函数最先被调用的，此时对象还未完成实例化，无法注入半成品对象。
        如何解决构造器注入的循环依赖：01、重新设计，彻底消除循环依赖 02、改成非构造器注入 3、使用@Lazy解决
        
12、**`spirngMVC是如何将不同的request路由到不同的Controller`**
    在mvc流程中，http请求进入tomcat并在httpServlet处理时，会解析httpRequest数据，以此拿到handlerMethod。其实mvc就是从不同的request拿到对应handlerMethod。
    所以在mvc启动时，会把@requestMapping注解的方法和类封装成一个requestMappingInfo和handlerMethod，然后注册到mappingRegistry。当httpServletRequest访问时，
        会通过AbstractHandlerMethodMapping中lookupHandlerMethod方法获取对应的handlerMethod。

12、**`如何让你的bean在其他bean之前加载`**
    bean初始化两个时机：01、spring容器主动初始化该bean 02、其他bean依赖该bean，该bean会被初始化
    实现方式：01、直接依赖某bean 02、dependsOn：使用注解@DependsOn("beanB") 03、beanFactoryPostProcessor（spring的bean在初始化之前，
        会通过beanFactoryPostProcessor中的postProcessBeanFactory对工厂进行处理）
    踩坑：@Order只能控制同一个bean类型中的集和顺序，不能控制不同bean的初始化顺序

13、**`springBoot如何实现自动配置`**
    根据类路径的jar包，为jar包中的类自动配置，简单来说就是根据定义在classpath下的类，自动给你生成bean，加载到spring的context中，然后通过条件配置决定那些可以配置，然后将configuration配置
到spring.factories中。主要的扫描是通过启动时的一个enableAutoConfiguration注解，该注解中有个import的enableAutoConfigurationImportSelector会扫描classpath下所有的spring.factories文件，
然后注册到bean中。

14、**`springboot如何实现main方法启动项目？`**
    通过springApplication类的静态方法run来启动web项目，里面使用了一个内嵌的tomcat服务器，并配置为处理web请求。spring boot自动扫描程序中的spring组件，会自动配置大部分的web开发所需配置，包括
请求处理、视图解析、静态资源处理，这个时候tomcat也会启动。在run方法中，会有一个步骤进行上下文刷新（refreshContext），这个过程中，会调用一个关键方法onRefresh（在servletWebServerApplicationContext中）。
onRefresh中有一个createWebServer方法，里面有一段factory.getWebServer(getSelfInitializer())代码，这里factory有tomcat、undertow、jetty三种实现。在getWebServer中最后有一步是
getTomcatWebServer，会创建一个tomcatServer，并进行一个启动。





    