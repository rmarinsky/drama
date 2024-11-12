package com.gsmserver.web.pages;

import com.gsmserver.web.components.LoginPopup;
import com.gsmserver.web.data.ProductDto;

import static com.github.rmarinsky.Drama.find;

public class HomePage {

    public void searProductByNameAndEnter(ProductDto productDto) {
        find("[name='searchword']")
                .fill(productDto.name)
                .pressEnter();
    }

    public void searchProductByNameAndClick(ProductDto name) {
        find("[name='searchword']").fill("Sigma Plus Box");
        find(".search-button[type='submit']").click();
    }


    public LoginPopup openLoginPopup() {
        find(".login").click();
        return new LoginPopup();
    }
}
