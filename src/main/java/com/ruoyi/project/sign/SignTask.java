package com.ruoyi.project.sign;

import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Sender;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * SignTask <br/>
 * Created by xiaqiulei on 2020-03-09.
 */

@Component("signTask")
public class SignTask {

    private static final Logger log = LoggerFactory.getLogger(SignTask.class);

    @Autowired
    PushConfig pushConfig;

    public void init() {
        Constants.useOfficial();

        log.info("pushConfig = {}", pushConfig);
    }

    public Object sendMessage(String userId) throws IOException, ParseException {
        log.info("userId = {}", userId);

        Sender sender = new Sender(pushConfig.appSecretKey);
        String messagePayload = "This is a message";
        Message message = new Message.Builder()
                .title(pushConfig.title)
                .description(pushConfig.desc)
                .payload(messagePayload)
                .restrictedPackageName(pushConfig.appPkgName)
                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_LAUNCHER_ACTIVITY)
                .notifyType(Message.NOTIFY_TYPE_ALL)
                .notifyId((int) (System.currentTimeMillis() / 1000))
                .build();

        // Object result = sender.sendToAlias(message, userId, 3);
        Object result = sender.broadcastAll(message, 3);

        log.info("result = {}", result);

        return result;
    }
}