package tasks.task6.code;

import java.util.Objects;

public class SmartPhone {
    private final Long IMEINumber;
    private final String nameOfSmartphone;
    private double price;
    private Byte screenSizeOfTheSmartphoneInInches;

    public SmartPhone() {
        this.IMEINumber = null;
        this.nameOfSmartphone = null;
        this.price = 0.0;
        this.screenSizeOfTheSmartphoneInInches = 0;
    }

    public SmartPhone(Long IMEInumber, String nameOfSmartphone, double price, Byte screenSizeOfTheSmartphoneInInches) {
        this.IMEINumber = IMEInumber;
        this.nameOfSmartphone = nameOfSmartphone;
        this.price = price;
        this.screenSizeOfTheSmartphoneInInches = screenSizeOfTheSmartphoneInInches;
    }

    public Long getIMEINumber() {
        return IMEINumber;
    }

    public String getNameOfSmartphone() {
        return nameOfSmartphone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Byte getScreenSizeOfTheSmartphoneInInches() {
        return screenSizeOfTheSmartphoneInInches;
    }

    public void setScreenSizeOfTheSmartphoneInInches(Byte screenSizeOfTheSmartphoneInInches) {
        this.screenSizeOfTheSmartphoneInInches = screenSizeOfTheSmartphoneInInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartPhone that = (SmartPhone) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(IMEINumber, that.IMEINumber) && Objects.equals(nameOfSmartphone, that.nameOfSmartphone) && Objects.equals(screenSizeOfTheSmartphoneInInches, that.screenSizeOfTheSmartphoneInInches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IMEINumber, nameOfSmartphone, price, screenSizeOfTheSmartphoneInInches);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "IMEINumber=" + IMEINumber +
                ", nameOfSmartphone='" + nameOfSmartphone + '\'' +
                ", price=" + price +
                ", screenSizeOfTheSmartphoneInInches=" + screenSizeOfTheSmartphoneInInches +
                '}';
    }
}
