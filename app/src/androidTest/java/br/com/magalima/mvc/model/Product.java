package br.com.magalima.mvc.model;

public class Product {
    private String id;
    private String description;
    private double value;
    private String adicionalInfo;
    private String image;


    public Product(String id, String description, double value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public Product(String id, String description, double value, String adicionalInfo) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.adicionalInfo = adicionalInfo;
    }

    public Product(String id, String description, double value, String adicionalInfo, String image) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.adicionalInfo = adicionalInfo;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getAdicionalInfo() {
        return adicionalInfo;
    }

    public void setAdicionalInfo(String adicionalInfo) {
        this.adicionalInfo = adicionalInfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
