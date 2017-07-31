package zhoux.beetl

import org.beetl.core.Context
import org.beetl.core.Function
import org.springframework.security.web.csrf.CsrfToken

import javax.servlet.http.HttpServletRequest

/**
 * Created by simon.hj.song on 2016/10/18 0018.
 */
class Csrf4Meta implements Function {
    @Override
    Object call(Object[] paras, Context ctx) {
        def request = ctx.getGlobal("request") as HttpServletRequest
        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName())
        ctx.putAt("_csrf", token)
        if (token != null) {
            try {
                return "<meta name='_csrf_parameter' content='${token.parameterName}'/>" +
                        "<meta name='_csrf_header' content='${token.headerName}'/>" +
                        "<meta name='_csrf' content='${token.token}'/>"
            }
            catch (IOException e) {
            }
        }
        return null
    }
}