package com.psy.biz;

import java.util.List;

import com.psy.vo.BulletinBoardSystemVO;

public interface BBSBiz {

	public List<BulletinBoardSystemVO> getAllPosting();
	
	public void addPosting(BulletinBoardSystemVO boardSystemVO);
	
	public boolean updateRecommed(int Id);
	
	public BulletinBoardSystemVO getPosting(int Id);
	
	public boolean deletPosting(int Id);
	
	public List<BulletinBoardSystemVO> searchPosting(String search);
	
}
