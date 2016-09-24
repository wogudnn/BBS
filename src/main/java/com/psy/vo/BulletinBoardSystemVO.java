package com.psy.vo;

public class BulletinBoardSystemVO {
	
	private int id;
	private String title;
	private String contents;
	private int hitCount;
	private int recommendConunt;
	private String CreatorName;
	private String CreateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public int getRecommendConunt() {
		return recommendConunt;
	}
	public void setRecommendConunt(int recommendConunt) {
		this.recommendConunt = recommendConunt;
	}
	public String getCreatorName() {
		return CreatorName;
	}
	public void setCreatorName(String creatorName) {
		CreatorName = creatorName;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	
	
}
