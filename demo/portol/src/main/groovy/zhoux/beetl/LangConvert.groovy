package zhoux.beetl

import org.beetl.core.Context
import org.beetl.core.Function


/**
 * Created by simon.hj.song on 2016/10/18 0018.
 */
class LangConvert implements Function {
    @Override
    Object call(Object[] paras, Context ctx) {
        def obj = paras[0]
        def propertyname = paras[1] as String
        return getLocaleProperty(obj, propertyname)
    }

    public static java.lang.String getLocaleProperty(java.lang.Object obj, java.lang.String property, java.util.Locale locale) { /* compiled code */ }
}