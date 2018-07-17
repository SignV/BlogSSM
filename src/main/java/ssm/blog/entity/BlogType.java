package ssm.blog.entity;


public class BlogType {

    private Integer id;
    private String typeName;
    private Integer orderNum;
    private Integer blogCount;

    public BlogType(){};

    public BlogType(Integer id, String typeName, Integer orderNum,Integer blogCount) {
        this.id = id;
        this.typeName = typeName;
        this.orderNum = orderNum;
        this.blogCount = blogCount;
    }

    public BlogType(String typeName, Integer orderNum,Integer blogCount) {
        this.typeName = typeName;
        this.orderNum = orderNum;
        this.blogCount = blogCount;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", orderNum=" + orderNum +
                ", blogCount=" + blogCount +
                '}';
    }
}
