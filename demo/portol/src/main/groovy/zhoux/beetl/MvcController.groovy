package zhoux.beetl

import org.beetl.ext.spring.BeetlGroupUtilConfiguration
import org.beetl.ext.spring.BeetlSpringViewResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

/**
 * Created by Dell on 2017/7/5.
 */
@Configuration
@EnableScheduling
//@EnableConfigurationProperties([BksyProperties, HikariCPProperties, KaptchaProperties])
class MvcController {

    @Autowired
    ZhouxBeetlGroupUtilConfiguration cfg
    /**
     * Beetl配置
     * @return
     */
    @Bean(initMethod = 'init', name = 'beetlConfig')
    BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        cfg
    }


    /**
     * Spring默认的视图解析器定义：Beetl视图解析器
     * @param beetlGroupUtilConfiguration
     * @return
     */
    @Bean(name = 'beetlViewResolver')
    BeetlSpringViewResolver getBeetlSpringViewResolver(
            @Qualifier('beetlConfig') BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        new BeetlSpringViewResolver(
                prefix: '/templates/',
                suffix: '.html',
                cache: false,
                contentType: 'text/html;charset=UTF-8',
                order: 0,
                config: beetlGroupUtilConfiguration
        )
    }

}
