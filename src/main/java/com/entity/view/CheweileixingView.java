package com.entity.view;

import com.entity.CheweileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 车位类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
@TableName("cheweileixing")
public class CheweileixingView  extends CheweileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheweileixingView(){
	}
 
 	public CheweileixingView(CheweileixingEntity cheweileixingEntity){
 	try {
			BeanUtils.copyProperties(this, cheweileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
