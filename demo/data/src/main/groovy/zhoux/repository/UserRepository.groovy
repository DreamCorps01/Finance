package zhoux.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import zhoux.entity.User

/**
 * Created by Dell on 2017/7/6.
 */
interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username)

    User findByUsernameAndPassword(String username, String password)
}