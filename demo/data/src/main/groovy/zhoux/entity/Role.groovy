package zhoux.entity

import org.springframework.data.jpa.domain.AbstractPersistable
import zhoux.enums.RoleType

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Dell on 2017/7/6.
 */
@Entity
@Table(name = "z_role")
class Role extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -856234002396786101L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role_name", unique = true)
    RoleType roleType
    @Column(name = "name")
    String name
    private String role
    private Long userId
}
