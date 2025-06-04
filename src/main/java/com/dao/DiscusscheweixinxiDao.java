package com.dao;

import com.entity.DiscusscheweixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusscheweixinxiVO;
import com.entity.view.DiscusscheweixinxiView;


/**
 * 车位信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-19 10:55:22
 */
public interface DiscusscheweixinxiDao extends BaseMapper<DiscusscheweixinxiEntity> {
	
	List<DiscusscheweixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusscheweixinxiEntity> wrapper);
	
	DiscusscheweixinxiVO selectVO(@Param("ew") Wrapper<DiscusscheweixinxiEntity> wrapper);
	
	List<DiscusscheweixinxiView> selectListView(@Param("ew") Wrapper<DiscusscheweixinxiEntity> wrapper);

	List<DiscusscheweixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusscheweixinxiEntity> wrapper);

	
	DiscusscheweixinxiView selectView(@Param("ew") Wrapper<DiscusscheweixinxiEntity> wrapper);
	

}
