package com.dao;

import com.entity.QuxiaoyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuxiaoyudingVO;
import com.entity.view.QuxiaoyudingView;


/**
 * 取消预定
 * 
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
public interface QuxiaoyudingDao extends BaseMapper<QuxiaoyudingEntity> {
	
	List<QuxiaoyudingVO> selectListVO(@Param("ew") Wrapper<QuxiaoyudingEntity> wrapper);
	
	QuxiaoyudingVO selectVO(@Param("ew") Wrapper<QuxiaoyudingEntity> wrapper);
	
	List<QuxiaoyudingView> selectListView(@Param("ew") Wrapper<QuxiaoyudingEntity> wrapper);

	List<QuxiaoyudingView> selectListView(Pagination page,@Param("ew") Wrapper<QuxiaoyudingEntity> wrapper);

	
	QuxiaoyudingView selectView(@Param("ew") Wrapper<QuxiaoyudingEntity> wrapper);
	

}
