package zhoux.entity

import zhoux.enums.UserStatus
import zhoux.enums.UserType
import javax.persistence.*

/**
 * Created by Dell on 2017/7/4.
 */
@Entity
@Table(name = "z_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id // 用户ID

    @Column(name = "name")
    String  username //用户名
    @Column(name = "password")
    String password //密码
    public SystemUser(){}
    public SystemUser(User user){
        this.username = user.username
        this.password = user.password
        this.id = user.id
    }
    @Column(name = "age")
    int age //年龄
    @Column(name = "email")
    String email //邮箱
    @Column(name = "telephone")
    String telephone // 电话
    @Column(name = "gender")
    Boolean gender //性别
    @Column(name = "address")
    String address //地址
    @Column(name = "height")
    String height //身高
    @Column(name = "weight")
    String weight //体重
    @Column(name = "education")
    String education //学历
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "usertype", unique = true)
    UserType userType //用户类型
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", unique = true)
    UserStatus status

}
