package com.gsmserver.web.pages;

import com.gsmserver.web.components.ProductList;
import com.gsmserver.web.data.ProductDto;

import static com.github.rmarinsky.Drama.byText;

public class SearchResultPage {

    public ProductList productList = new ProductList();

    public SearchResultPage findProductByTextAndAddToCart(ProductDto productDto) {
        byText(productDto.name)
                .find(".addToCart").click();
        return this;
    }

    public SearchResultPage findProductByText() {

        return this;
    }

    public SearchResultPage discountPriceIsVisible() {
        return this;
    }
}
