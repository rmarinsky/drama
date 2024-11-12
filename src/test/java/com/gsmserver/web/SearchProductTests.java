package com.gsmserver.web;

import com.github.rmarinsky.DramaWrapper;
import com.gsmserver.common.LocatorDecorator;
import com.gsmserver.common.LocatorUtils;
import com.gsmserver.web.data.ProductDto;
import com.gsmserver.web.data.UserDto;
import com.gsmserver.web.pages.CheckoutPage;
import com.gsmserver.web.pages.HomePage;
import com.gsmserver.web.pages.OrderSummeryPage;
import com.gsmserver.web.pages.SearchResultPage;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.github.rmarinsky.Drama.*;
import static com.github.rmarinsky.conditions.Condition.visible;
import static com.gsmserver.common.data.UserData.getUser;

public class SearchProductTests {

    private final HomePage homePage = new HomePage();
    private final ProductDto targetSigmaPlusBox = new ProductDto().name("Sigma Plus Box");
    private final SearchResultPage searchResultPage = new SearchResultPage();


    @BeforeEach
    void beforeEach() {
        open("https://gsmserver.com");
    }

    @Test
    @DisplayName("search simple product and add to cart")
    void searchSimpleProductViaEnter() {
        homePage.searProductByNameAndEnter(targetSigmaPlusBox);
        searchResultPage.productList
                .isLoaded()
                .sizeIs(1);
        searchResultPage.productList.productItem
                .withProduct(targetSigmaPlusBox)
                .isLoaded()
                .discountPriceIsVisible()
                .addToCart();
        openCart();
        byText("Sigma Plus Box").shouldBe(visible);
    }


    @Test
    @DisplayName("search simple product and add to cart")
    void searchSimpleProductByCLick() {

        homePage.searchProductByNameAndClick(targetSigmaPlusBox);
        searchResultPage.findProductByTextAndAddToCart(targetSigmaPlusBox);
        openCart();
        byText("Sigma Plus Box").shouldBe(visible);
    }


    @Test
    @DisplayName("search simple product and add to cart")
    void authorizedUserSearchSimpleProductAndCheckOrder() {
        var targetUser = getUser();

        homePage.openLoginPopup().registerUser(targetUser);
        homePage.searProductByNameAndEnter(targetSigmaPlusBox);
        searchResultPage.findProductByTextAndAddToCart(targetSigmaPlusBox);
        find("#cart").click();
        byText("Sigma Plus Box").shouldBe(visible);

        open("/checkout/");


        Locator ologin = DramaWrapper.drama().page().locator("ologin");
        ologin.click();
        new LocatorDecorator(ologin)
                .clickZPlyaskamy()
                .checkTooltip();

        //decorator
        LocatorUtils.clickZPlyaskamy(ologin);
        //utilit class
        LocatorUtils.checkTooltip(ologin);


        new CheckoutPage()
                .fullFilForm()
                .submitCheckout();

        new OrderSummeryPage().checkOrderInfo(this.targetSigmaPlusBox, targetUser);
    }

    @ParameterizedTest
    @MethodSource("products")
    @DisplayName("check products [{index}] {argumentsWithNames}")
    void checkProducts(UserDto targetProductDto) {

        Assertions.fail();
    }

    private static List<UserDto> products() {
//        var faker = new com.github.javafaker.Faker();
        var correctUserUser = getUser();
//        correctUserUser.city(faker.address().city());

        var anotherUserUser = getUser();

//        anotherUserUser.city(faker.address().city());


        return List.of(correctUserUser, anotherUserUser);
    }


    private static void openCart() {
        find("#cart").click();
    }


}
