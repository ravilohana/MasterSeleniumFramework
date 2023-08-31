package objects;

import utils.JacksonUtils;

import java.io.IOException;

public class Products {

    // products POJO's
    private int id;
    private String name;


// Default Constructor

    public Products(){}

    // Parameterized Constructor


    public Products(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Products(int id) throws IOException {
        String productsJsonFilePath = "./json_files/products.json";
        Products[] products = JacksonUtils.deserializeJson(productsJsonFilePath,Products[].class);
        for (Products product: products) {
            if(product.getId() == id){
                this.id = id;
                this.name = product.getName();
            }
        }
    }

    // Getter and Setter

    public int getId() {
        return id;
    }

    public Products setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Products setName(String name) {
        this.name = name;
        return this;
    }





}
