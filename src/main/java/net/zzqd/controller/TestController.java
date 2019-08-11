package net.zzqd.controller;

import lombok.extern.slf4j.Slf4j;
import net.zzqd.common.ApplicationContextHelper;
import net.zzqd.common.JsonData;
import net.zzqd.dao.SysAclModuleMapper;
import net.zzqd.exception.PermissionException;
import net.zzqd.model.SysAclModule;
import net.zzqd.param.TestVo;
import net.zzqd.util.BeanValidator;
import net.zzqd.util.JsonMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author zqnh
 * @date 2019/8/9 on 16:22.
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController
{
    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello()
    {
        log.info("hello");
        throw new PermissionException("test exception");
//        return JsonData.success("hello rbac");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo)
    {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module =  moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");

    }
}
