package net.zzqd.common;

import lombok.extern.slf4j.Slf4j;
import net.zzqd.exception.PermissionException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zqnh
 * @date 2019/8/9 on 20:14.
 *
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver
{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        String  url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";

        //.json .page
        // 这时我们项目中所有请求json数据，都使用.json结尾
        if(url.endsWith(".json"))
        {
            if(ex instanceof PermissionException)
            {
                JsonData result = JsonData.fail(ex.getMessage());
                mv = new ModelAndView("jsonView",result.toMap());
            }
            else
            {
                log.error("unknow json exception,url"+url,ex);
                JsonData result = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView",result.toMap());
            }
        }
        else if(url.endsWith(".page"))// 这时我们项目中所有请求page页面，都使用.page结尾
        {
            log.error("unknow page exception,url"+url,ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception",result.toMap());
        }
        else
        {
            log.error("unknow exception,url"+url,ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView",result.toMap());
        }

        return mv;
    }
}
