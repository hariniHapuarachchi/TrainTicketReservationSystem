package rest.dto;

public class PaymentDTO extends SuperDTO {

    private int id;
    private int reserveId;
    private String creditCard;
    private int cvcNo;
    private String name;

    private int mobile;
    private int digitNum;

    public PaymentDTO() {
    }

    public PaymentDTO(int id,int reserveId, String creditCard, int cvcNo, String name, int mobile, int digitNum) {
        this.id = id;
        this.reserveId = reserveId;
        this.creditCard = creditCard;
        this.cvcNo = cvcNo;
        this.name = name;
        this.mobile = mobile;
        this.digitNum = digitNum;
    }

    public PaymentDTO(int reserveId, String creditCard, int cvcNo, String name) {
        this.id = id;
        this.reserveId = reserveId;
        this.creditCard = creditCard;
        this.cvcNo = cvcNo;
        this.name = name;
    }

    public PaymentDTO(int reserveId, int mobile, int digitNum) {
        this.id = id;
        this.reserveId = reserveId;
        this.mobile = mobile;
        this.digitNum = digitNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getCvcNo() {
        return cvcNo;
    }

    public void setCvcNo(int cvcNo) {
        this.cvcNo = cvcNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getDigitNum() {
        return digitNum;
    }

    public void setDigitNum(int digitNum) {
        this.digitNum = digitNum;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", reserveId=" + reserveId +
                ", creditCard='" + creditCard + '\'' +
                ", cvcNo=" + cvcNo +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", digitNum=" + digitNum +
                '}';
    }
}
