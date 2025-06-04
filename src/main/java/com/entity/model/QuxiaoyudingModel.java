package com.entity.model;

import com.entity.QuxiaoyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 取消预定
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
public class QuxiaoyudingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车位名称
	 */
	
	private String cheweimingcheng;
		
	/**
	 * 车位类型
	 */
	
	private String cheweileixing;
		
	/**
	 * 车位图片
	 */
	
	private String cheweitupian;
		
	/**
	 * 车位位置
	 */
	
	private String cheweiweizhi;
		
	/**
	 * 收费标准
	 */
	
	private String shoufeibiaozhun;
		
	/**
	 * 停车价格
	 */
	
	private Double tingchejiage;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 车牌号码
	 */
	
	private String chepaihaoma;
		
	/**
	 * 预定时间
	 */
	
	private String yudingshijian;
		
	/**
	 * 取消时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date quxiaoshijian;
		
	/**
	 * 取消原因
	 */
	
	private String quxiaoyuanyin;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：车位名称
	 */
	 
	public void setCheweimingcheng(String cheweimingcheng) {
		this.cheweimingcheng = cheweimingcheng;
	}
	
	/**
	 * 获取：车位名称
	 */
	public String getCheweimingcheng() {
		return cheweimingcheng;
	}
				
	
	/**
	 * 设置：车位类型
	 */
	 
	public void setCheweileixing(String cheweileixing) {
		this.cheweileixing = cheweileixing;
	}
	
	/**
	 * 获取：车位类型
	 */
	public String getCheweileixing() {
		return cheweileixing;
	}
				
	
	/**
	 * 设置：车位图片
	 */
	 
	public void setCheweitupian(String cheweitupian) {
		this.cheweitupian = cheweitupian;
	}
	
	/**
	 * 获取：车位图片
	 */
	public String getCheweitupian() {
		return cheweitupian;
	}
				
	
	/**
	 * 设置：车位位置
	 */
	 
	public void setCheweiweizhi(String cheweiweizhi) {
		this.cheweiweizhi = cheweiweizhi;
	}
	
	/**
	 * 获取：车位位置
	 */
	public String getCheweiweizhi() {
		return cheweiweizhi;
	}
				
	
	/**
	 * 设置：收费标准
	 */
	 
	public void setShoufeibiaozhun(String shoufeibiaozhun) {
		this.shoufeibiaozhun = shoufeibiaozhun;
	}
	
	/**
	 * 获取：收费标准
	 */
	public String getShoufeibiaozhun() {
		return shoufeibiaozhun;
	}
				
	
	/**
	 * 设置：停车价格
	 */
	 
	public void setTingchejiage(Double tingchejiage) {
		this.tingchejiage = tingchejiage;
	}
	
	/**
	 * 获取：停车价格
	 */
	public Double getTingchejiage() {
		return tingchejiage;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：车牌号码
	 */
	 
	public void setChepaihaoma(String chepaihaoma) {
		this.chepaihaoma = chepaihaoma;
	}
	
	/**
	 * 获取：车牌号码
	 */
	public String getChepaihaoma() {
		return chepaihaoma;
	}
				
	
	/**
	 * 设置：预定时间
	 */
	 
	public void setYudingshijian(String yudingshijian) {
		this.yudingshijian = yudingshijian;
	}
	
	/**
	 * 获取：预定时间
	 */
	public String getYudingshijian() {
		return yudingshijian;
	}
				
	
	/**
	 * 设置：取消时间
	 */
	 
	public void setQuxiaoshijian(Date quxiaoshijian) {
		this.quxiaoshijian = quxiaoshijian;
	}
	
	/**
	 * 获取：取消时间
	 */
	public Date getQuxiaoshijian() {
		return quxiaoshijian;
	}
				
	
	/**
	 * 设置：取消原因
	 */
	 
	public void setQuxiaoyuanyin(String quxiaoyuanyin) {
		this.quxiaoyuanyin = quxiaoyuanyin;
	}
	
	/**
	 * 获取：取消原因
	 */
	public String getQuxiaoyuanyin() {
		return quxiaoyuanyin;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
