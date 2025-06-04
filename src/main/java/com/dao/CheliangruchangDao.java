package com.dao;

import com.entity.CheliangruchangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangruchangVO;
import com.entity.view.CheliangruchangView;


/**
 * 车辆入场
 * 
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
public interface CheliangruchangDao extends BaseMapper<CheliangruchangEntity> {
	
	List<CheliangruchangVO> selectListVO(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
	
	CheliangruchangVO selectVO(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
	
	List<CheliangruchangView> selectListView(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);

	List<CheliangruchangView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangruchangEntity> wrapper);

	
	CheliangruchangView selectView(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
	

}
