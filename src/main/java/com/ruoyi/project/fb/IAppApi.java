package com.ruoyi.project.fb;

import cn.mycommons.easyfeedback.dto.PageResp;
import cn.mycommons.easyfeedback.dto.app.AppDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "appApi", url = "localhost:8081")
public interface IAppApi {

    @GetMapping("/app/list")
    PageResp<AppDto> list(@RequestParam int page, @RequestParam int size);

    @PostMapping("/app/search")
    PageResp<AppDto> search(@RequestBody AppDto dto,
                            @RequestParam int page,
                            @RequestParam int size);
}