package com.network.good.dto;


import com.network.good.mapper.GoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPage {
    /*数据总数： select count(*) from student; count(1)比count(*)效率高
	2.页面大小	用户自定义
	3.总页数		程序自动计算
		总页数=数据总数%页面大小==0？：数据总数/页面大小:数据总数/页面大小+1	4.当前页(页码）	用户自定义
	5.当前页的对象集合（实体类集合）
	*/
    @Autowired
    GoodDao goodDao;

    private int currentPage=1;
    private int totalPages;//总页数
    private int totallines;//总记录数
    private int pageSize=5;//每页多少行
    private int nextPage;//下一页
    private int prePage;//上一页


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        totalPages=totallines%pageSize==0?totallines/pageSize:totallines/pageSize+1;
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotallines() {

      return totallines;
    }

    public void setTotallines() {

        this.totallines =goodDao.getTotalLines();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNextPage() {
        if(currentPage<totalPages){
            nextPage=currentPage+1;
        }
        else{
            nextPage=currentPage;
        }
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrePage() {
        if(currentPage>1){
            prePage=currentPage-1;
        }
        else{
            prePage=currentPage;
        }
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
}

