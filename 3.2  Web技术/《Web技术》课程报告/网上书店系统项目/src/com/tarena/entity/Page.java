package com.tarena.entity;

public class Page {

	public Page() {

	}

	/**
	 * 当前页
	 */
	private int pageNo=1;
	/**
	 * 每页行数
	 */
	private int pageSize=5;
	
	/**
	 * 起始行
	 */
	private int begin;
	/**
	 * 总条数
	 */
	private int countItem;
	/**
	 * 总页数
	 */
	private int countPage;
	
	public int getCountPage() {
		//计算总页数
		if(countItem%pageSize==0){
			countPage=countItem/pageSize;
		}else{
			countPage=countItem/pageSize+1;
		}
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getCountItem() {
		return countItem;
	}

	public void setCountItem(int countItem) {
		this.countItem = countItem;
	}

	public int getBegin() {
		return (pageNo-1)*pageSize;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
