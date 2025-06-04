package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YudingcheweiEntity;
import com.entity.view.YudingcheweiView;

import com.service.YudingcheweiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 预定车位
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
@RestController
@RequestMapping("/yudingchewei")
public class YudingcheweiController {
    @Autowired
    private YudingcheweiService yudingcheweiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YudingcheweiEntity yudingchewei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yudingchewei.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YudingcheweiEntity> ew = new EntityWrapper<YudingcheweiEntity>();

		PageUtils page = yudingcheweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yudingchewei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YudingcheweiEntity yudingchewei, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yudingchewei.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YudingcheweiEntity> ew = new EntityWrapper<YudingcheweiEntity>();

		PageUtils page = yudingcheweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yudingchewei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YudingcheweiEntity yudingchewei){
       	EntityWrapper<YudingcheweiEntity> ew = new EntityWrapper<YudingcheweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yudingchewei, "yudingchewei")); 
        return R.ok().put("data", yudingcheweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YudingcheweiEntity yudingchewei){
        EntityWrapper< YudingcheweiEntity> ew = new EntityWrapper< YudingcheweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yudingchewei, "yudingchewei")); 
		YudingcheweiView yudingcheweiView =  yudingcheweiService.selectView(ew);
		return R.ok("查询预定车位成功").put("data", yudingcheweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YudingcheweiEntity yudingchewei = yudingcheweiService.selectById(id);
        return R.ok().put("data", yudingchewei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YudingcheweiEntity yudingchewei = yudingcheweiService.selectById(id);
        return R.ok().put("data", yudingchewei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YudingcheweiEntity yudingchewei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yudingchewei);
        yudingcheweiService.insert(yudingchewei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YudingcheweiEntity yudingchewei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yudingchewei);
    	yudingchewei.setUserid((Long)request.getSession().getAttribute("userId"));
        yudingcheweiService.insert(yudingchewei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YudingcheweiEntity yudingchewei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yudingchewei);
        yudingcheweiService.updateById(yudingchewei);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YudingcheweiEntity> list = new ArrayList<YudingcheweiEntity>();
        for(Long id : ids) {
            YudingcheweiEntity yudingchewei = yudingcheweiService.selectById(id);
            yudingchewei.setSfsh(sfsh);
            yudingchewei.setShhf(shhf);
            list.add(yudingchewei);
        }
        yudingcheweiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yudingcheweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
