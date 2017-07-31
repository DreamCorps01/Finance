package zhoux.beetl

import org.beetl.core.Context
import org.beetl.core.Function
import org.springframework.security.web.csrf.CsrfToken

import javax.servlet.http.HttpServletRequest

/**
 * Created by simon.hj.song on 2016/10/18 0018.
 */
class Csrf4Input implements Function {

    @Override
    Object call(Object[] paras, Context ctx) {
        def request = ctx.getGlobal("request") as HttpServletRequest
        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName())
        if (token != null) {
            try {
                return "<input type='hidden' name='${token.parameterName}' value='${token.token}'/>"
            }
            catch (IOException e) {
            }
        }
        return null
    }
}