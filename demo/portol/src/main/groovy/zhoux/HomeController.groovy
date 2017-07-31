package zhoux
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping



/**
 * Created by Dell on 2017/7/4.
 */
@Controller
class HomeController {

   @RequestMapping("/")
    String index(){
        return "home/index"
    }

}
