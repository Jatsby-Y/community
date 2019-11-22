package life.coder.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Karl
 * @date 2019年 11月22日 13:43:27
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
