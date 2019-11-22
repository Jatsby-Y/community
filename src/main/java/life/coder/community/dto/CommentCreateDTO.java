package life.coder.community.dto;

import lombok.Data;

/**
 * @author Karl
 * @date 2019年 11月19日 20:49:10
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
