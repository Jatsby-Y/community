package life.coder.community.dto;

import lombok.Data;

/**
 * @author Karl
 * @date 2019年 11月25日 13:01:13
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
