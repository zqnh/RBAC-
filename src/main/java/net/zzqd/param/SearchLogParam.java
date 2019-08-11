package net.zzqd.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zqnh
 * @date 2019/8/11 on 10:24.
 */
@Getter
@Setter
@ToString
public class SearchLogParam {

    private Integer type; // LogType

    private String beforeSeg;

    private String afterSeg;

    private String operator;

    private String fromTime;//yyyy-MM-dd HH:mm:ss

    private String toTime;
}
