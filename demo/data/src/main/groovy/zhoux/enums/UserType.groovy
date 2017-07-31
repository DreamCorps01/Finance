package zhoux.enums

/**
 * Created by Dell on 2017/7/4.
 */
enum UserType {

    PERSON("一般用户"),

    SPECIAL("特殊用户")

    String name

    UserType(String name) {
        this.name = name
    }

    @Override
    String toString() {
        return name
    }

}