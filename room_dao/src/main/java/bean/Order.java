package bean;

import java.util.Date;
import java.util.UUID;

public class Order {
    private int  id;
    private int rid;
    private int bookContinue;
    private Date createTime;//创建订单的时间
    private Date payTime;//付款时间
    private Date rBegin;
    private Date rEnd;
    private String payYoN;
    private String code;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", rid=" + rid +
                ", bookContinue=" + bookContinue +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", rBegin=" + rBegin +
                ", rEnd=" + rEnd +
                ", payYoN='" + payYoN + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getrBegin() {
        return rBegin;
    }

    public void setrBegin(Date rBegin) {
        this.rBegin = rBegin;
    }

    public Date getrEnd() {
        return rEnd;
    }

    public void setrEnd(Date rEnd) {
        this.rEnd = rEnd;
    }

    public String getPayYoN() {
        return payYoN;
    }

    public void setPayYoN(String payYoN) {
        this.payYoN = payYoN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getBookContinue() {
        return bookContinue;
    }

    public void setBookContinue(int bookContinue) {
        this.bookContinue = bookContinue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Order() {
    }

    public Order(int id, int rid, int bookContinue, Date createTime, Date payTime, Date rBegin, Date rEnd, String payYoN) {
        this.id = id;
        this.rid = rid;
        this.bookContinue = bookContinue;
        this.createTime = createTime;
        this.payTime = payTime;
        this.rBegin = rBegin;
        this.rEnd = rEnd;
        this.payYoN = payYoN;
    }
}
