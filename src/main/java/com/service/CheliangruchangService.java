package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangruchangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangruchangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangruchangView;


/**
 * 车辆入场
 *
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
public interface CheliangruchangService extends IService<CheliangruchangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangruchangVO> selectListVO(Wrapper<CheliangruchangEntity> wrapper);
   	
   	CheliangruchangVO selectVO(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
   	
   	List<CheliangruchangView> selectListView(Wrapper<CheliangruchangEntity> wrapper);
   	
   	CheliangruchangView selectView(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangruchangEntity> wrapper);

   	

}

