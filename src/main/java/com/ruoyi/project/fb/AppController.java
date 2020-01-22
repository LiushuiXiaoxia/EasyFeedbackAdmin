package com.ruoyi.project.fb;

import cn.mycommons.easyfeedback.dto.PageResp;
import cn.mycommons.easyfeedback.dto.app.AppDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fb/app")
public class AppController extends BaseController {

    private String prefix = "fb/app";

    @Autowired
    private IAppApi appApi;

    @RequiresPermissions("fb:app:view")
    @GetMapping()
    public String app() {
        return prefix + "/app";
    }

    /**
     * 查询意见反馈列表
     */
    @RequiresPermissions("fb:app:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppDto dto) {
        startPage();
        Page<Object> page = PageHelper.getLocalPage();
        // PageResp<AppDto> resp = appApi.search(dto, page.getPageNum(), page.getPageSize());
        PageResp<AppDto> resp = appApi.list(page.getPageNum(), page.getPageSize());
        return FbUtil.convert(resp);
    }
}