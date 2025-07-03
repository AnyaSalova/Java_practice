package task3;

public enum Prices {
    ECONOMY(1000),
    STANDARD(2000),
    LUX(5000),
    ULTRA_LUX(10000);

    private final int price;

    Prices(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}