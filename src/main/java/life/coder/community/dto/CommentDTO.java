package life.coder.community.dto;

import life.coder.community.model.User;
import lombok.Data;

/**
 * @author Karl
 * @date 2019年 11月21日 12:51:09
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
