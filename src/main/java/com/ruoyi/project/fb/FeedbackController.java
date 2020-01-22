package com.ruoyi.project.fb;

import cn.mycommons.easyfeedback.dto.CommonResp;
import cn.mycommons.easyfeedback.dto.PageResp;
import cn.mycommons.easyfeedback.dto.feedback.FeedbackDto;
import cn.mycommons.easyfeedback.dto.feedback.MetaDto;
import cn.mycommons.easyfeedback.dto.feedback.status.UpdateStatusReq;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fb/feedback")
public class FeedbackController extends BaseController {

    private String prefix = "fb/feedback";

    @Autowired
    private IFeedbackApi feedbackApi;

    @RequiresPermissions("fb:feedback:view")
    @GetMapping()
    public String feedback(@RequestParam(required = false) String pkgName,
                           @RequestParam(required = false) String platform,
                           ModelMap map) {
        map.put("pkgName", Strings.isNullOrEmpty(pkgName) ? "" : pkgName);
        map.put("platform", Strings.isNullOrEmpty(platform) ? "" : platform);
        return prefix + "/feedback";
    }

    /**
     * 查询意见反馈列表
     */
    @RequiresPermissions("fb:feedback:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam(required = false) String pkgName,
                              @RequestParam(required = false) String platform,
                              FeedbackDto feedbackDto) {
        startPage();
        Page<Object> page = PageHelper.getLocalPage();
        if (!Strings.isNullOrEmpty(pkgName) && !Strings.isNullOrEmpty(platform)) {
            feedbackDto.setMeta(new MetaDto());
            feedbackDto.getMeta().setPkgName(pkgName);
            feedbackDto.getMeta().setPlatform(platform);
        }

        PageResp<FeedbackDto> resp = feedbackApi.search(feedbackDto, page.getPageNum(), page.getPageSize());
        return FbUtil.convert(resp);
    }

    @RequiresPermissions("fb:feedback:list")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, ModelMap mmap) {
        CommonResp<FeedbackDto> dto = feedbackApi.detail(id);
        mmap.put("feedback", dto.getData());
        return prefix + "/detail";
    }

    /**
     * 新增意见反馈
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 修改意见反馈
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        CommonResp<FeedbackDto> dto = feedbackApi.detail(id);
        mmap.put("feedback", dto.getData());
        return prefix + "/edit";
    }

    /**
     * 修改保存意见反馈
     */
    @RequiresPermissions("fb:feedback:edit")
    @Log(title = "意见反馈", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FeedbackDto feedback) {
        UpdateStatusReq req = new UpdateStatusReq();
        req.setStatus(feedback.getStatus());
        CommonResp<Integer> resp = feedbackApi.updateStatus(feedback.getId(), req);
        return toAjax(resp.getData());
    }
}