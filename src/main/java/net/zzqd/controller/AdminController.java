package net.zzqd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zqnh
 * @date 2019/8/10 on 20:46.
 */
@Controller
@RequestMapping("/admin")
public class AdminController
{
    @RequestMapping("index.page")
    public ModelAndView index()
    {
        return new ModelAndView("admin");
    }
}
