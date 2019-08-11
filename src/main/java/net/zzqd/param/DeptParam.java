package net.zzqd.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author zqnh
 * @date 2019/8/10 on 10:47.
 */
@Getter
@Setter
@ToString
public class DeptParam
{
    private Integer id;

    @NotBlank(message = "部门名称不可以为空")
    @Length(max = 15,min = 2,message = "部门名称长度需要在2-15之间")
    private String name;

    private Integer parentId = 0;

    @NotNull(message = "展示顺序不可以为空")
    private Integer seq;

    @Length(max = 150,message = "备注的长度在150个字之间")
    private String remark;
}
