package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YudingcheweiDao;
import com.entity.YudingcheweiEntity;
import com.service.YudingcheweiService;
import com.entity.vo.YudingcheweiVO;
import com.entity.view.YudingcheweiView;

@Service("yudingcheweiService")
public class YudingcheweiServiceImpl extends ServiceImpl<YudingcheweiDao, YudingcheweiEntity> implements YudingcheweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YudingcheweiEntity> page = this.selectPage(
                new Query<YudingcheweiEntity>(params).getPage(),
                new EntityWrapper<YudingcheweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YudingcheweiEntity> wrapper) {
		  Page<YudingcheweiView> page =new Query<YudingcheweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YudingcheweiVO> selectListVO(Wrapper<YudingcheweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YudingcheweiVO selectVO(Wrapper<YudingcheweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YudingcheweiView> selectListView(Wrapper<YudingcheweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YudingcheweiView selectView(Wrapper<YudingcheweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
