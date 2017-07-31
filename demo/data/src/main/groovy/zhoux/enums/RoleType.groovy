package zhoux.enums

/**
 * Created by Dell on 2017/7/6.
 */
enum RoleType {

    ADMIN("管理员"),

    USER("普通用户")

    String name

    RoleType(String name) {
        this.name = name
    }

    @Override
    String toString() {
        return name
    }

}