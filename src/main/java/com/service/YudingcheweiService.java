package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YudingcheweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YudingcheweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YudingcheweiView;


/**
 * 预定车位
 *
 * @author 
 * @email 
 * @date 2024-01-19 10:55:21
 */
public interface YudingcheweiService extends IService<YudingcheweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YudingcheweiVO> selectListVO(Wrapper<YudingcheweiEntity> wrapper);
   	
   	YudingcheweiVO selectVO(@Param("ew") Wrapper<YudingcheweiEntity> wrapper);
   	
   	List<YudingcheweiView> selectListView(Wrapper<YudingcheweiEntity> wrapper);
   	
   	YudingcheweiView selectView(@Param("ew") Wrapper<YudingcheweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YudingcheweiEntity> wrapper);

   	

}

