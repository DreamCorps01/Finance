package zhoux.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import zhoux.entity.Role
import zhoux.entity.User
import zhoux.enums.RoleType
import zhoux.enums.UserStatus
import zhoux.repository.UserRepository

/**
 * Created by Dell on 2017/7/6.
 */
@Component
class CustomUserService implements UserDetailsService{

    @Autowired
    UserRepository userRepository
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在")
        }
        return user
    }
}
