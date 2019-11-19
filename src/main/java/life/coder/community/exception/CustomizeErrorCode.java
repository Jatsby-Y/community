package life.coder.community.exception;

/**
 * @author Karl
 * @date 2019年 11月19日 15:59:05
 */
public class CustomizeErrorCode implements ICustomizeErrorCode{
    public static final String QUESTION_NOT_FOUND = "您搜索的问题不存在，要不换个试试？";
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    CustomizeErrorCode(String message) {
        this.message = message;
    }

}
