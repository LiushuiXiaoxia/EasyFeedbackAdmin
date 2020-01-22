package com.ruoyi.project.fb;

import cn.mycommons.easyfeedback.dto.PageResp;
import com.ruoyi.framework.web.page.TableDataInfo;

public class FbUtil {

    protected static TableDataInfo convert(PageResp<?> pageResp) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(pageResp.getData());
        rspData.setTotal(pageResp.getTotal());
        return rspData;
    }
}