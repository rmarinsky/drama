package com.gsmserver.web.components;

import com.github.rmarinsky.LocatorActions;
import com.github.rmarinsky.conditions.Condition;
import com.gsmserver.web.data.ProductDto;

import static com.github.rmarinsky.Drama.key;

public class ProductItem {

    private LocatorActions targetProduct;

    public void addToCart() {
        this.targetProduct.find(".addToCart").click();
    }

    public void addToWishList() {
        this.targetProduct.find(".addToWishList").click();
    }

    public void addToCompare() {
        this.targetProduct.find(".addToCompare").click();
    }

    public void viewDetails() {
        this.targetProduct.find(".viewDetails").click();
    }

    public void viewReviews() {
        // View reviews
    }

    public void viewRating() {
        // View rating
    }

    public void viewPrice() {
        // View price
    }

    public void viewImage() {
        // View image
    }

    public void viewTitle() {
        // View title
    }

    public void viewDescription() {
        // View description
    }

    public void viewCategory() {
        // View category
    }

    public void viewBrand() {
        // View brand
    }

    public void viewStock() {
        // View stock
    }

    public void viewAvailability() {
        // View availability
    }

    public void viewShipping() {
        // View shipping
    }

    public void viewTax() {
        // View tax
    }

    public void viewAddToCartButton() {
        // View add to cart button
    }

    public void viewAddToWishListButton() {
        // View add to wish list button
    }

    public void viewAddToCompareButton() {
        // View add to compare button
    }

    public void viewViewDetailsButton() {
        // View view details button
    }

    public void viewViewReviewsButton() {
        // View view reviews button
    }

    public void viewViewRatingButton() {
        // View view rating button
    }

    public void viewViewPriceButton() {
        // View view price button
    }

    public void viewViewImageButton() {
        // View view image button
    }

    public void viewViewTitleButton() {
        // View view title button
    }

    public void viewViewDescriptionButton() {
        // View view description button
    }

    public void viewViewCategoryButton() {
        // View view category button
    }

    public void viewViewBrandButton() {
        // View view brand button
    }

    public void viewViewStockButton() {
        // View view stock button
    }

    public void viewViewAvailabilityButton() {
        // View view availability button
    }

    public void viewViewShippingButton() {
        // View view shipping button
    }

    public ProductItem withProduct(ProductDto sigmaPlusBox) {
        this.targetProduct = key(sigmaPlusBox.id);
        return this;
    }

    public ProductItem discountPriceIsVisible() {
        targetProduct.find(".discountPrice").shouldBe(Condition.visible);
        return this;
    }

    public ProductItem isLoaded() {

        return this;
    }
}
