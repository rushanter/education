package com.education;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.education.mapper.UserInfoMapper;
import com.education.service.WeChatService;
import com.education.util.HttpUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private WeChatService weChatService;

    @Test
    public void test() throws Exception {
//        {"session_key":"8n9m2IYi\/lw6+FGBXawUNQ==","openid":"o3DUh5VtauUXphRiQAbDwuy6u1Mc"}

        System.out.println(weChatService.weChatLogin("001qxaAK0t6mEb2Mi2zK0wWbAK0qxaAY"));
        String url ="https://api.weixin.qq.com/sns/jscode2session";
        String appid="wx5b224d37cfaa1970";
        String secret="f943b6ea50453b7b66d9b9706a1cb48d";
        String js_code="001Awpsn0DpPXm1Bqvqn056Asn0Awpsb";
        String grant_type="authorization_code";

        Map<String, Object> param = new HashMap<>();
        param.put("appid", appid);
        param.put("secret", secret);
        param.put("js_code", js_code);
        param.put("authorization_code", grant_type);
        String responseStr = HttpUtil.doGet(url, param);
        JSONObject jsonObject = JSON.parseObject(responseStr);
        System.out.println(responseStr);
        url="https://api.weixin.qq.com/cgi-bin/token";
        Map<String, Object> param2 = new HashMap<>();
        param2.put("grant_type", "client_credential");
        param2.put("appid", appid);
        param2.put("secret", secret);

        url="https://api.weixin.qq.com/cgi-bin/user/info";
        String access_token=jsonObject.getString("session_key");
        String openid=jsonObject.getString("openid");
//        String access_token="OwsENPc3oomAMd0rV9AOEw==";
//        String openid="o3DUh5VtauUXphRiQAbDwuy6u1Mc";
        System.out.println(access_token+openid);
        Map<String, Object> param1 = new HashMap<>();
        param1.put("access_token", access_token);
        param1.put("openid", openid);

        String str = HttpUtil.doGet(url, param1);
        System.out.println(str);
    }
    @Before
    public void init() throws Exception{
        System.out.println("1111");
    }
    @After
    public void destory(){
        System.out.println(2);
    }
}