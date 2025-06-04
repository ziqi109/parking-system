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

import com.entity.CheliangruchangEntity;
import com.entity.view.CheliangruchangView;

import com.service.CheliangruchangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 车辆入场
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
@RestController
@RequestMapping("/cheliangruchang")
public class CheliangruchangController {
    @Autowired
    private CheliangruchangService cheliangruchangService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangruchangEntity cheliangruchang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			cheliangruchang.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CheliangruchangEntity> ew = new EntityWrapper<CheliangruchangEntity>();

		PageUtils page = cheliangruchangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangruchang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheliangruchangEntity cheliangruchang, 
		HttpServletRequest request){
        EntityWrapper<CheliangruchangEntity> ew = new EntityWrapper<CheliangruchangEntity>();

		PageUtils page = cheliangruchangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangruchang), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangruchangEntity cheliangruchang){
       	EntityWrapper<CheliangruchangEntity> ew = new EntityWrapper<CheliangruchangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliangruchang, "cheliangruchang")); 
        return R.ok().put("data", cheliangruchangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheliangruchangEntity cheliangruchang){
        EntityWrapper< CheliangruchangEntity> ew = new EntityWrapper< CheliangruchangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliangruchang, "cheliangruchang")); 
		CheliangruchangView cheliangruchangView =  cheliangruchangService.selectView(ew);
		return R.ok("查询车辆入场成功").put("data", cheliangruchangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangruchangEntity cheliangruchang = cheliangruchangService.selectById(id);
        return R.ok().put("data", cheliangruchang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangruchangEntity cheliangruchang = cheliangruchangService.selectById(id);
        return R.ok().put("data", cheliangruchang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangruchangEntity cheliangruchang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(cheliangruchang);
        cheliangruchangService.insert(cheliangruchang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangruchangEntity cheliangruchang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(cheliangruchang);
        cheliangruchangService.insert(cheliangruchang);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheliangruchangEntity cheliangruchang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangruchang);
        cheliangruchangService.updateById(cheliangruchang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheliangruchangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
