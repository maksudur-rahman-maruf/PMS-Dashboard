package com.revesoft.pms.dashboard.model;

public class Achievement {
	private long id;
	private long userId;
	private long projectId;
	private int year;
	private String month;
	private String week;
	private double achievement;
	private long verifiedBy1;
	private long verifiedBy2;
	private int isDeleted;
	private long lastModificationTime;

	public Achievement(long id, long userId, long projectId, int year, String month, String week, double achievement,
			long verifiedBy1, long verifiedBy2, int isDeleted, long lastModificationTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.projectId = projectId;
		this.year = year;
		this.month = month;
		this.week = week;
		this.achievement = achievement;
		this.verifiedBy1 = verifiedBy1;
		this.verifiedBy2 = verifiedBy2;
		this.isDeleted = isDeleted;
		this.lastModificationTime = lastModificationTime;
	}

	public Achievement(long id, long userId, int year, String month, double achievement) {
		this.id = id;
		this.userId = userId;
		this.year = year;
		this.month = month;
		this.achievement = achievement;

	}
	
	public Achievement(String month, double achievement) {
		this.month = month;
		this.achievement = achievement;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public double getAchievement() {
		return achievement;
	}

	public void setAchievement(double achievement) {
		this.achievement = achievement;
	}

	public long getVerifiedBy1() {
		return verifiedBy1;
	}

	public void setVerifiedBy1(long verifiedBy1) {
		this.verifiedBy1 = verifiedBy1;
	}

	public long getVerifiedBy2() {
		return verifiedBy2;
	}

	public void setVerifiedBy2(long verifiedBy2) {
		this.verifiedBy2 = verifiedBy2;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public long getLastModificationTime() {
		return lastModificationTime;
	}

	public void setLastModificationTime(long lastModificationTime) {
		this.lastModificationTime = lastModificationTime;
	}

}