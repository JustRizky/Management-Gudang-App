package model;

public abstract class ShoesModel {
    private int id;
    private int stock;
    private String name, brand, type;

    public ShoesModel(int id, String name, String brand, String type, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
