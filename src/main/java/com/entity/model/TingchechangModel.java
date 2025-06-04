package com.entity.model;

import com.entity.TingchechangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 停车场
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
public class TingchechangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 经度
	 */
	
	private String jingdu;
		
	/**
	 * 纬度
	 */
	
	private String weidu;
		
	/**
	 * 地址
	 */
	
	private String dizhi;
		
	/**
	 * 车位总数
	 */
	
	private Integer cheweizongshu;
		
	/**
	 * 面积
	 */
	
	private String mianji;
		
	/**
	 * 收费标准
	 */
	
	private String shoufeibiaozhun;
		
	/**
	 * 详情说明
	 */
	
	private String xiangqingshuoming;
		
	/**
	 * 经度
	 */
	
	private Double longitude;
		
	/**
	 * 纬度
	 */
	
	private Double latitude;
		
	/**
	 * 地址
	 */
	
	private String fulladdress;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：经度
	 */
	 
	public void setJingdu(String jingdu) {
		this.jingdu = jingdu;
	}
	
	/**
	 * 获取：经度
	 */
	public String getJingdu() {
		return jingdu;
	}
				
	
	/**
	 * 设置：纬度
	 */
	 
	public void setWeidu(String weidu) {
		this.weidu = weidu;
	}
	
	/**
	 * 获取：纬度
	 */
	public String getWeidu() {
		return weidu;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
				
	
	/**
	 * 设置：车位总数
	 */
	 
	public void setCheweizongshu(Integer cheweizongshu) {
		this.cheweizongshu = cheweizongshu;
	}
	
	/**
	 * 获取：车位总数
	 */
	public Integer getCheweizongshu() {
		return cheweizongshu;
	}
				
	
	/**
	 * 设置：面积
	 */
	 
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	
	/**
	 * 获取：面积
	 */
	public String getMianji() {
		return mianji;
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
	 * 设置：详情说明
	 */
	 
	public void setXiangqingshuoming(String xiangqingshuoming) {
		this.xiangqingshuoming = xiangqingshuoming;
	}
	
	/**
	 * 获取：详情说明
	 */
	public String getXiangqingshuoming() {
		return xiangqingshuoming;
	}
				
	
	/**
	 * 设置：经度
	 */
	 
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * 获取：经度
	 */
	public Double getLongitude() {
		return longitude;
	}
				
	
	/**
	 * 设置：纬度
	 */
	 
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * 获取：纬度
	 */
	public Double getLatitude() {
		return latitude;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	
	/**
	 * 获取：地址
	 */
	public String getFulladdress() {
		return fulladdress;
	}
			
}
