package bean;

import java.util.Date;

public class Room {
    private int id ;
    private double price;
    private Date date;
    private String isBook;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", isBook=" + isBook +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String isBook() {
        return isBook;
    }

    public void setBook(String book) {
        isBook = book;
    }
}
