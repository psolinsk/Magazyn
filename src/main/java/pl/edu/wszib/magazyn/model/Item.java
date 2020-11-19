package pl.edu.wszib.magazyn.model;

public class Item {
    private String name;
    private int count;
    private String serialNumber;

    public Item(String name, int count, String serialNumber) {
        this.name = name;
        this.count = count;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
