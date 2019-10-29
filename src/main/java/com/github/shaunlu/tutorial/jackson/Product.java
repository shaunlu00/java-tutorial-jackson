package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @JsonProperty("UUID")
    private String id;
    @JsonProperty("PRODUCT_NAME")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@hh:mm:ss")
    private Date createTime = new Date();

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date updateTime = new Date();

    private ProductType productType = ProductType.COMPUTER;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum ProductType {
        COMPUTER("computer", 9011),
        BOOK("book", 9012);
        String code;
        int number;
        ProductType(String code, int number) {
            this.code = code;
            this.number = number;
        }

        public String getCode() {
            return code;
        }

        public int getNumber() {
            return number;
        }
    }

    private String nullField = null;

    private String emptyField = "";

    public Product(){}

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNullField() {
        return nullField;
    }

    public String getEmptyField() {
        return emptyField;
    }
}
