package com.dao;

import com.entity.YudingcheweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YudingcheweiVO;
import com.entity.view.YudingcheweiView;


/**
 * 预定车位
 * 
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
public interface YudingcheweiDao extends BaseMapper<YudingcheweiEntity> {
	
	List<YudingcheweiVO> selectListVO(@Param("ew") Wrapper<YudingcheweiEntity> wrapper);
	
	YudingcheweiVO selectVO(@Param("ew") Wrapper<YudingcheweiEntity> wrapper);
	
	List<YudingcheweiView> selectListView(@Param("ew") Wrapper<YudingcheweiEntity> wrapper);

	List<YudingcheweiView> selectListView(Pagination page,@Param("ew") Wrapper<YudingcheweiEntity> wrapper);

	
	YudingcheweiView selectView(@Param("ew") Wrapper<YudingcheweiEntity> wrapper);
	

}
