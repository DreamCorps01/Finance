package zhoux.enums

/**
 * Created by Dell on 2017/7/6.
 */
enum UserStatus {

    NORMAL("正常"),

    ABNORMAL("异常")

    String name

    UserStatus(String name) {
        this.name = name
    }

    @Override
    String toString() {
        return name
    }

}