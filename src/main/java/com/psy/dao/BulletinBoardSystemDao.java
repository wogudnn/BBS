package com.psy.dao;

import java.util.List;

import com.psy.vo.BulletinBoardSystemVO;

public interface BulletinBoardSystemDao {

	public void addPosting(BulletinBoardSystemVO boardSystemVO);
	
	public List<BulletinBoardSystemVO> getPostingOf();
	
	public BulletinBoardSystemVO getPostingAt(int Id);
	
	public void updateRecommendCount(int Id);
	
	public void deletePosting(int Id);
	
	public void updateHitCount(int Id);
}
