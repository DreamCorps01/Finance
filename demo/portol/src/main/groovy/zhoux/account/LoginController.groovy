package zhoux.account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import zhoux.entity.User
import zhoux.repository.UserRepository

import javax.servlet.http.HttpServletRequest

/**
 * Created by Dell on 2017/7/9.
 */
@Controller
class LoginController {
    @Autowired
    UserRepository userRepository

    @RequestMapping("/login")
    String login(String username, String password) {
        User user = userRepository.findByUsername(username)
        if(user == null){
            return "a"
        }else if(user.password != password){
            return "b"
        }
        return "c"
    }
}
