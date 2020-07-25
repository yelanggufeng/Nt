package com.netintech.common.utils.bean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *分页bean
 * @param <T>
 */
public class Page<T>{
    /**页面大小*/
	private Integer pageSize = 10;
	/**总记录数*/
	private Integer total= 0 ;
	/**内容数*/
	private List<T> result;
	/**当前页码*/
	private Integer curPage=1;
	/**最大页码*/
	private Integer maxPage;
	/**前一页*/
	private Integer pre;
	/**后一页*/
	private Integer next;
	/**记录偏移位置*/
	private Integer offset=0;
	/**条件过滤参数*/
	private Map<String, Object> filter = new HashMap<String, Object>(0);
	/**id集合*/
	private Integer[] ids;
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getResult() {
	    if(result == null){
	        return new LinkedList<T>();
	    }
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getMaxPage() {
		maxPage=total%pageSize>0?total/pageSize+1:total/pageSize;
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	
	public Integer getOffset() {
		offset = 0;
		if (curPage != null){
			offset=curPage*pageSize-pageSize;
		}
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPre() {
		pre=curPage-1<=0?1:curPage-1;
		return pre;
	}
	public void setPre(Integer pre) {
		this.pre = pre;
	}
	public Integer getNext() {
		next=curPage+1>=getMaxPage()?getMaxPage():curPage+1;
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Map<String, Object> getFilter() {
		return filter;
	}
	public void setFilter(Map<String, Object> filter) {
		this.filter = filter;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
}
