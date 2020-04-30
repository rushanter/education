package com.education.health;

import com.education.constants.ResultErrorMsg;
import com.education.constants.ResultMsg;
import com.education.entity.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author Jenkin.K
 * @date 2017/12/21
 */
@RestController
public class HealthCheckController {
    Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @GetMapping(value = "/healthCheck")
    @ResponseBody
    public Object healthCheck() {
        ResultMsg resultMsg = new ResultMsg();
        logger.info("health check ok");
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }
}
