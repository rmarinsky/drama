package com.gsmserver.web.data;

import lombok.Data;

@Data
public class ProductDto {
    public String name;
    public String id;
    public String count;
    public String price;
    public String discountPrice;
}
