package net.zzqd.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.zzqd.model.SysAcl;
import org.springframework.beans.BeanUtils;

/**
 * @author zqnh
 * @date 2019/8/11 on 10:20.
 */
@Getter
@Setter
@ToString
public class AclDto extends SysAcl {

    // 是否要默认选中
    private boolean checked = false;

    // 是否有权限操作
    private boolean hasAcl = false;

    public static AclDto adapt(SysAcl acl) {
        AclDto dto = new AclDto();
        BeanUtils.copyProperties(acl, dto);
        return dto;
    }
}
