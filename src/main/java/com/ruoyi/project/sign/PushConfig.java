package com.ruoyi.project.sign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.StringJoiner;

/**
 * PushConfig <br/>
 * Created by xiaqiulei on 2020-03-09.
 */
@Configuration
public class PushConfig {

    @Value("${push.appId}")
    public String appId;

    @Value("${push.appSecretKey}")
    public String appSecretKey;

    @Value("${push.appPkgName}")
    public String appPkgName;

    @Value("${push.title}")
    public String title;

    @Value("${push.desc}")
    public String desc;

    @Override
    public String toString() {
        return new StringJoiner(", ", PushConfig.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("appSecretKey='" + appSecretKey + "'")
                .add("appPkgName='" + appPkgName + "'")
                .add("title='" + title + "'")
                .add("desc='" + desc + "'")
                .toString();
    }
}