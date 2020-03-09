package com.ruoyi.project.sign;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * SignController <br/>
 * Created by xiaqiulei on 2020-03-09.
 */
@RestController
@RequestMapping("/sign")
public class SignController extends BaseController {

    @Autowired
    SignTask signTask;

    @GetMapping("test")
    public AjaxResult test() throws IOException, ParseException {
        Object o = signTask.sendMessage("180713516");
        return AjaxResult.success(o);
    }
}