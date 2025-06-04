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


import com.dao.CheliangruchangDao;
import com.entity.CheliangruchangEntity;
import com.service.CheliangruchangService;
import com.entity.vo.CheliangruchangVO;
import com.entity.view.CheliangruchangView;

@Service("cheliangruchangService")
public class CheliangruchangServiceImpl extends ServiceImpl<CheliangruchangDao, CheliangruchangEntity> implements CheliangruchangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangruchangEntity> page = this.selectPage(
                new Query<CheliangruchangEntity>(params).getPage(),
                new EntityWrapper<CheliangruchangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangruchangEntity> wrapper) {
		  Page<CheliangruchangView> page =new Query<CheliangruchangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CheliangruchangVO> selectListVO(Wrapper<CheliangruchangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheliangruchangVO selectVO(Wrapper<CheliangruchangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheliangruchangView> selectListView(Wrapper<CheliangruchangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangruchangView selectView(Wrapper<CheliangruchangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
