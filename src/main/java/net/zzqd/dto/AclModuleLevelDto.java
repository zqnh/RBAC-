package net.zzqd.dto;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.zzqd.model.SysAclModule;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author zqnh
 * @date 2019/8/11 on 10:20.
 */

@Getter
@Setter
@ToString
public class AclModuleLevelDto extends SysAclModule
{

    private List<AclModuleLevelDto> aclModuleList = Lists.newArrayList();

    private List<AclDto> aclList = Lists.newArrayList();

    public static AclModuleLevelDto adapt(SysAclModule aclModule) {
        AclModuleLevelDto dto = new AclModuleLevelDto();
        BeanUtils.copyProperties(aclModule, dto);
        return dto;
    }
}
