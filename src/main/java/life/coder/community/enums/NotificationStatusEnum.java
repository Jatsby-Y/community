package life.coder.community.enums;

/**
 * @author Karl
 * @date 2019年 11月22日 15:52:07
 */
public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);

    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
