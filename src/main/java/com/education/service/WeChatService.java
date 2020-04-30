package com.education.service;

import com.education.util.AESUtil;
import com.education.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public interface WeChatService {

    public String weChatLogin(String code);

    public String getWxInfoByOpenId(String encryptedData, String session_key, String iv);
}
