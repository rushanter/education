package com.education.controller;

import com.education.constants.ResultErrorMsg;
import com.education.constants.ResultMsg;
import com.education.entity.Banner;
import com.education.entity.Categories;
import com.education.mapper.BannerMapper;
import com.education.mapper.CategoriesMapper;
import com.education.mapper.UserMapper;
import com.education.entity.Record;
import com.education.entity.User;
import com.education.mapper.RecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


/**
 * @author lss
 * @since 2020-03-22
 */
@Controller
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private CategoriesMapper categoriesMapper;


    @RequestMapping("/queryBanner")
    @ResponseBody
    public ResultMsg queryBanner() {
        ResultMsg resultMsg = new ResultMsg();
        List<Banner> banners = bannerMapper.queryBannerList();
        logger.info(banners.toString());
        resultMsg.setData(banners);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }



    @RequestMapping("/queryUser")
    @ResponseBody
    public ResultMsg queryUser() {
        ResultMsg resultMsg = new ResultMsg();
        List<User> users = userMapper.queryUserList();
        resultMsg.setData(users);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }

    @RequestMapping("/queryRecord")
    @ResponseBody
    public ResultMsg queryRecordList(int type,int page) {
        ResultMsg resultMsg = new ResultMsg();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("type",type);
        map.put("page",page);
        List<Record> records = recordMapper.queryRecordForType(map);
        resultMsg.setData(records);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }

    @RequestMapping("/queryCategories")
    @ResponseBody
    public ResultMsg queryCategories() {
        ResultMsg resultMsg = new ResultMsg();
        List<Categories> Categories = categoriesMapper.queryCategoriesList();
        resultMsg.setData(Categories);
        resultMsg.setErrorMsg(ResultErrorMsg.OK);
        return resultMsg;
    }

}
