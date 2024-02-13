package gr.vbatsalis.MoneySplitApplication;

public class Payment {
    private String desc;
    private int value;

    public Payment(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "desc='" + desc + '\'' +
                ", value=" + value +
                '}';
    }
}
