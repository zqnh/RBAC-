package net.zzqd.dto;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.zzqd.model.SysDept;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author zqnh
 * @date 2019/8/10 on 11:19.
 */
@Getter
@Setter
@ToString
public class DeptLevelDto extends SysDept
{

    private List<DeptLevelDto> deptList = Lists.newArrayList();

    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(dept, dto);
        return dto;
    }
}
