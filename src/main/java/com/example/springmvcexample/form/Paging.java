package com.example.springmvcexample.form;

public class Paging {
	private Integer pageNo = 1;
	private Integer pageSize = 10;
	private Integer pageTotal;
	private String firstPage;
	private String previousPage;
	private String nextPage;
	private String lastPage;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		if (pageTotal > 0) {
			this.pageTotal = pageTotal;
			if (firstPage != null)
				pageNo = 1;
			else if (previousPage != null)
				pageNo--;
			else if (nextPage != null)
				pageNo++;
			else if (lastPage != null)
				pageNo = pageTotal;

			if (pageNo < 1)
				pageNo = 1;
			if (pageNo > pageTotal)
				pageNo = pageTotal;
		} else
			this.pageTotal = 0;

	}

	public String getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}

	public String getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(String previousPage) {
		this.previousPage = previousPage;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	@Override
	public String toString() {
		return "Paging [pageNo=" + pageNo + ", pageSize=" + pageSize + ", pageTotal=" + pageTotal + ", firstPage="
				+ firstPage + ", previousPage=" + previousPage + ", nextPage=" + nextPage + ", lastPage=" + lastPage
				+ "]";
	}

}
