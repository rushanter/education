package com.education.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.education.entity.param.WeChatInfo;
import com.education.service.UserInfoService;
import com.education.service.WeChatService;
import com.education.util.AESUtil;
import com.education.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @author lss
 * @since 2020/3/27
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    private static final Logger logger = LoggerFactory.getLogger(WeChatServiceImpl.class);

    @Value("${wechat.loginUrl}")
    private String loginUrl;

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.grant_type}")
    private String grant_type;


    @Override
    public String weChatLogin(String code) {
        Map<String, Object> param = new HashMap<>();
        param.put("appid", appId);
        param.put("secret", secret);
        param.put("js_code", code);
        param.put("authorization_code", grant_type);
        String result = HttpUtil.doGet(loginUrl, param);
        return result;
    }
    @Override
    public String getWxInfoByOpenId(String encryptedData, String session_key, String iv) {
        String decrypt = AESUtil.decrypt(encryptedData, session_key, iv);
        return decrypt;
    }


}
