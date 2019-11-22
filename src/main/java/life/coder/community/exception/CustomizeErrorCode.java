package life.coder.community.exception;

/**
 * @author Karl
 * @date 2019年 11月19日 15:59:05
 */
public enum  CustomizeErrorCode implements ICustomizeErrorCode{
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    QUESTION_NOT_FOUND(2001, "您寻找的问题不存在，要不您换个试试？"),
    NO_LOGIN(2003, "当前操作需要登录，请登录后重试"),
    SYS_ERROR(2004, "服务器冒烟啦，要不然你稍后再试试？"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "您回复的不存在，要不您换个试试？"),
    CONTENT_IS_EMPTY(2007, "评论内容不能为空，请输入内容");
    private String message;
    private Integer code;


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
