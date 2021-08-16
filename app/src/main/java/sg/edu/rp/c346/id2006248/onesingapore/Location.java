package sg.edu.rp.c346.id2006248.onesingapore;

import java.io.Serializable;

public class Location implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;
    private int local;
    private String hotel;

    public Location(String title, String singers, int year, int local, String hotel, int stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.local = local;
        this.hotel = hotel;
        this.stars = stars;
    }

    public Location(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        if (title == null && singers == null){
            return Integer.toString(year);
        }
        else{
            return "";
        }

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int isLocal() {
        return local;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
