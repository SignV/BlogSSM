package ssm.blog.entity;

import java.util.List;

public class PageBean<T> {
    private int currPage;   //当前页数
    private int pageSize;   //每页显示的个数
    private long total;     //总记录数
    private int start;      //当前页面开始的记录
    private List<T> result; //分页查询结果

    public PageBean(){

    }
    public PageBean(int currPage,int pageSize){
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.start = ( currPage - 1 ) * pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currPage=" + currPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", start=" + start +
                ", result=" + result +
                '}';
    }
}
