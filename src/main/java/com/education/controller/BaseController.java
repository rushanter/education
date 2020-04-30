package com.education.controller;

import com.education.constants.ResultErrorMsg;
import com.education.constants.ResultMsg;
import com.education.entity.Banner;
import com.education.entity.Categorie;
import com.education.entity.UserInfo;
import com.education.mapper.BannerMapper;
import com.education.mapper.CategorieMapper;
import com.education.mapper.UserInfoMapper;
import com.education.entity.Record;
import com.education.mapper.RecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * @author lss
 * @since 2020-03-22
 */
@RestController
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private CategorieMapper categorieMapper;

    @RequestMapping("/queryBanner")
    public ResultMsg queryBanner() {
        ResultMsg resultMsg = new ResultMsg();
        List<Banner> banners = bannerMapper.queryBannerList();
        logger.info(banners.toString());
        resultMsg.setData(banners);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }



    @RequestMapping("/queryUser")
    public ResultMsg queryUser() {
        ResultMsg resultMsg = new ResultMsg();
        List<UserInfo> users = userInfoMapper.queryUserList();
        resultMsg.setData(users);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }

    @RequestMapping("/queryForType")
    public ResultMsg queryForType(int type,int page) {
        ResultMsg resultMsg = new ResultMsg();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("type",type);
        map.put("page",page);
        List<Record> records = recordMapper.queryForType(map);
        resultMsg.setData(records);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }

    @RequestMapping("/queryForRecommend")
    public ResultMsg queryForRecommend(int recommend,int page) {
        ResultMsg resultMsg = new ResultMsg();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("type",recommend);
        map.put("page",page);
        List<Record> records = recordMapper.queryForRecommend(map);
        resultMsg.setData(records);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }

    @RequestMapping("/queryCategories")
    public ResultMsg queryCategories() {
        ResultMsg resultMsg = new ResultMsg();
        List<Categorie> Categorie = categorieMapper.queryCategorieList();
        resultMsg.setData(Categorie);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }

}
