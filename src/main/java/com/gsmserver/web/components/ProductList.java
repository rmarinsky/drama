package com.gsmserver.web.components;

import static com.github.rmarinsky.Drama.find;
import static com.github.rmarinsky.conditions.Condition.visible;

public class ProductList {

    public ProductItem productItem;

    public ProductList isLoaded() {
        find(".product-list").shouldBe(visible);
        return this;
    }

    public ProductList sizeIs(int count) {
        //find(".product-list").findAll(".product-item").shouldHaveSize(count);
        return this;
    }


}
