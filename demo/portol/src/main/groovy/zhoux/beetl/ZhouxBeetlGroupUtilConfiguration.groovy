package zhoux.beetl

import org.beetl.core.resource.ClasspathResourceLoader
import org.beetl.ext.spring.BeetlGroupUtilConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component

/**
 * Created by Dell on 2017/7/5.
 */
@Component
class ZhouxBeetlGroupUtilConfiguration extends BeetlGroupUtilConfiguration{

    @Autowired
    ApplicationContext ctx

    ZhouxBeetlGroupUtilConfiguration() {
        //采用Class Path的资源加载方法
        resourceLoader = new ClasspathResourceLoader()
    }

    /**
     * 提供您的自定义初始化接口
     */
    @Override
    protected void initOther() {
        //全局变量，提供 Spring 的 Context ， 所有beetl的函数和格式化方法都可以进行调用了。
        groupTemplate.sharedVars = ["springCtx": ctx, "picTable": "9"]
    }
}
