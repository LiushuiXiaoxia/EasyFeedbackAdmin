package com.ruoyi.project.fb;

import cn.mycommons.easyfeedback.dto.CommonResp;
import cn.mycommons.easyfeedback.dto.PageResp;
import cn.mycommons.easyfeedback.dto.feedback.FeedbackDto;
import cn.mycommons.easyfeedback.dto.feedback.status.UpdateStatusReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "feedback", url = "localhost:8081")
public interface IFeedbackApi {

    @GetMapping("/feedback/list")
    PageResp<FeedbackDto> list(@RequestParam int page, @RequestParam int size);

    @GetMapping("/feedback/{id}")
    CommonResp<FeedbackDto> detail(@PathVariable String id);

    @PostMapping("/feedback/status/{id}")
    CommonResp<Integer> updateStatus(@PathVariable String id, @RequestBody UpdateStatusReq req);
}