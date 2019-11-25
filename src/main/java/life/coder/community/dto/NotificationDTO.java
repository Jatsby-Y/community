package life.coder.community.dto;

import lombok.Data;

/**
 * @author Karl
 * @date 2019年 11月22日 16:14:59
 */
@Data
public class NotificationDTO {
    private Long id;
    private String outerTitle;
    private String typeName;
    private Integer type;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private Long outerid;
}
