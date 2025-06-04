package com.entity.view;

import com.entity.TingchechangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 停车场
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
@TableName("tingchechang")
public class TingchechangView  extends TingchechangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TingchechangView(){
	}
 
 	public TingchechangView(TingchechangEntity tingchechangEntity){
 	try {
			BeanUtils.copyProperties(this, tingchechangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
