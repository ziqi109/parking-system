package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 车辆出场
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
@TableName("cheliangchuchang")
public class CheliangchuchangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CheliangchuchangEntity() {
		
	}
	
	public CheliangchuchangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 车位编号
	 */
					
	private String cheweibianhao;
	
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
	 * 车牌号码
	 */
					
	private String chepaihaoma;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 入场时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date ruchangshijian;
	
	/**
	 * 出场时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date chuchangshijian;
	
	/**
	 * 总时长
	 */
					
	private Integer zongshizhang;
	
	/**
	 * 合计费用
	 */
					
	private Double hejifeiyong;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：车位编号
	 */
	public void setCheweibianhao(String cheweibianhao) {
		this.cheweibianhao = cheweibianhao;
	}
	/**
	 * 获取：车位编号
	 */
	public String getCheweibianhao() {
		return cheweibianhao;
	}
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
	 * 设置：入场时间
	 */
	public void setRuchangshijian(Date ruchangshijian) {
		this.ruchangshijian = ruchangshijian;
	}
	/**
	 * 获取：入场时间
	 */
	public Date getRuchangshijian() {
		return ruchangshijian;
	}
	/**
	 * 设置：出场时间
	 */
	public void setChuchangshijian(Date chuchangshijian) {
		this.chuchangshijian = chuchangshijian;
	}
	/**
	 * 获取：出场时间
	 */
	public Date getChuchangshijian() {
		return chuchangshijian;
	}
	/**
	 * 设置：总时长
	 */
	public void setZongshizhang(Integer zongshizhang) {
		this.zongshizhang = zongshizhang;
	}
	/**
	 * 获取：总时长
	 */
	public Integer getZongshizhang() {
		return zongshizhang;
	}
	/**
	 * 设置：合计费用
	 */
	public void setHejifeiyong(Double hejifeiyong) {
		this.hejifeiyong = hejifeiyong;
	}
	/**
	 * 获取：合计费用
	 */
	public Double getHejifeiyong() {
		return hejifeiyong;
	}
	/**
	 * 设置：登记日期
	 */
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
