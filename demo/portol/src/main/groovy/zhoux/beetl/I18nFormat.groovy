package zhoux.beetl

import org.beetl.core.Context
import org.beetl.core.ContextFormat
import org.springframework.context.ApplicationContext


import javax.servlet.http.HttpServletRequest

/**
 * Created by simon.hj.song on 2016/10/17.
 * 对Beetl集成国际化支持
 */
class I18nFormat extends ContextFormat {
    @Override
    Object format(Object data, String pattern, Context ctx) {
        if (data) {
            HttpServletRequest request = ctx.getGlobal("request") as HttpServletRequest
            def spring = ctx.getGlobal("springCtx") as ApplicationContext
            //采用当前语言，根据用户选择的语言进行显示
            try {
                if (pattern == "local") {
                    def locale = request.cookies.find { (it.name == "lang") }?.value
                    def l = locale == "en" ? Locale.ENGLISH : (locale == "zh_TW" ? Locale.TRADITIONAL_CHINESE : Locale.SIMPLIFIED_CHINESE)
                    return spring.getMessage((String) data, null, l)
                } else {
                    return spring.getMessage((String) data, null, new Locale(pattern))
                }
            } catch (Exception ex) {
                return data
            }
        }
        return ""
    }
}