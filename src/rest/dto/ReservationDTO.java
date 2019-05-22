package rest.dto;

public class ReservationDTO extends SuperDTO{

    private int reserveId;
    private int id;
    private String date;
    private String time;
    private int ticket;
    private double amount;
    private String payMethod;

    public ReservationDTO() {

    }

    public ReservationDTO(int reserveId,int id, String date, String time, int ticket, double amount, String payMethod) {
        this.reserveId = reserveId;
        this.id = id;
        this.date = date;
        this.time = time;
        this.ticket = ticket;
        this.amount = amount;
        this.payMethod = payMethod;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "reserveId=" + reserveId +
                ", id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", ticket=" + ticket +
                ", amount=" + amount +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
