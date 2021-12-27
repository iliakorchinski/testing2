package model;

public class Route {
    private String pointTo;
    private String checkInDate;
    private String checkOutDate;
    private int roomsAmount;
    private int adultsAmount;
    private int kidsAmount;


    public Route(String pointTo) {
        this.pointTo = pointTo;
    }

    public Route(String pointTo, String checkInDate, String checkOutDate, int roomsAmount, int adultsAmount, int kidsAmount) {
        this.pointTo = pointTo;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomsAmount = roomsAmount;
        this.adultsAmount = adultsAmount;
        this.kidsAmount = kidsAmount;
    }

    public Route(String pointTo, String checkInDate, String checkOutDate) {
        this.pointTo = pointTo;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getPointTo() {
        return pointTo;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public int getAdultsAmount() {
        return adultsAmount;
    }

    public int getKidsAmount() {
        return kidsAmount;
    }
}
