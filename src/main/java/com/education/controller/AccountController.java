package com.education.controller;

import com.education.constants.ResultErrorMsg;
import com.education.constants.ResultMsg;
import com.education.service.WeChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lss
 * @since 2020-03-22
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private WeChatService weChatService;

    @GetMapping(value = "/weChatLogin")
    public ResultMsg WeChatLogin(String code) {
        ResultMsg resultMsg = new ResultMsg();

        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }


}


