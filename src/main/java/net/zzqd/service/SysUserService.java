package net.zzqd.service;

import com.google.common.base.Preconditions;
import net.zzqd.beans.PageQuery;
import net.zzqd.beans.PageResult;
import net.zzqd.common.RequestHolder;
import net.zzqd.dao.SysUserMapper;
import net.zzqd.exception.ParamException;
import net.zzqd.model.SysUser;
import net.zzqd.param.UserParam;
import net.zzqd.util.BeanValidator;
import net.zzqd.util.IpUtil;
import net.zzqd.util.MD5Util;
import net.zzqd.util.PasswordUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zqnh
 * @date 2019/8/10 on 18:02.
 */
@Service
public class SysUserService
{
    @Resource
    private SysUserMapper sysUserMapper;

    public void save(UserParam param)
    {
        BeanValidator.check(param);
        if(checkTelephoneExist(param.getTelephone(),param.getId()))
        {
            throw  new ParamException("手机号已被注册");
        }
        if(checkEmailExist(param.getMail(),param.getId()))
        {
            throw new ParamException("邮箱已经被注册");
        }
        String password = PasswordUtil.randomPassword();
        password = "12345678";
        String encryptedPassword = MD5Util.encrypt(password);
        SysUser user = SysUser.builder().username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
                .password(encryptedPassword).deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        user.setOperator(RequestHolder.getCurrentUser().getUsername());
        user.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        user.setOperateTime(new Date());
        //TODO:sendEmail

        sysUserMapper.insertSelective(user);

    }

    public void update(UserParam param)
    {
        BeanValidator.check(param);
        if(checkTelephoneExist(param.getTelephone(),param.getId()))
        {
            throw  new ParamException("手机号已被注册");
        }
        if(checkEmailExist(param.getMail(),param.getId()))
        {
            throw new ParamException("邮箱已经被注册");
        }
        SysUser before = sysUserMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before,"待更新的用户不存在");
        SysUser after = SysUser.builder().id(param.getId()).username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
            .password(before.getPassword()).deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        after.setOperator(RequestHolder.getCurrentUser().getOperator());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        sysUserMapper.updateByPrimaryKeySelective(after);

    }

    public boolean checkEmailExist(String mail,Integer userId)
    {
        return sysUserMapper.countByMail(mail,userId)>0;
    }

    public boolean checkTelephoneExist(String telephone,Integer userId)
    {
        return sysUserMapper.countByTelephone(telephone,userId)>0;
    }

    public SysUser findByKeyword(String keyword)
    {
        return sysUserMapper.findByKeyword(keyword);
    }

    public PageResult<SysUser> getPageByDeptId(int deptId, PageQuery page) {
        BeanValidator.check(page);
        int count = sysUserMapper.countByDeptId(deptId);
        if (count > 0) {
            List<SysUser> list = sysUserMapper.getPageByDeptId(deptId, page);
            return PageResult.<SysUser>builder().total(count).data(list).build();
        }
        return PageResult.<SysUser>builder().build();
    }
    public List<SysUser> getAll() {
        return sysUserMapper.getAll();
    }
}
