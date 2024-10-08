package com.course.selenium.fp2;

import com.course.selenium.fp2.fragments.AddedToCartCard;
import com.course.selenium.fp2.fragments.PaymentMethodCard;
import com.course.selenium.fp2.fragments.SearchBar;
import com.course.selenium.fp2.fragments.ShippingMethodCard;
import com.course.selenium.fp2.helpers.BrowserFactory;
import com.course.selenium.fp2.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class makingAPurchaseSteps {
    private final WebDriver driver = BrowserFactory.getDriver();

    HomePage homePage;
    AuthPage authPage;
    SearchBar searchBar;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    AddedToCartCard addedToCartCard;
    ShoppingCartPage shoppingCartPage;
    CheckoutAddressesPage checkoutAddressesPage;
    ShippingMethodCard shippingMethodCard;
    PaymentMethodCard paymentMethodCard;
    OrderConfirmationPage orderConfirmationPage;

    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();

        authPage = new AuthPage(driver);
        authPage.typeEmailIntoLogIn(BrowserFactory.getUserLogin());
        authPage.typePasswordIntoLogIn(BrowserFactory.getUserPassword());
        authPage.clickSignInButton();

    }

    @And("The user is on the page of the {string} they want to buy")
    public void theUserIsOnThePageOfTheTheyWantToBuy(String productToBuy) {
        searchBar = new SearchBar(driver);
        searchBar.useSearchBar(productToBuy);

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.goToProductPage(productToBuy);

        productPage = new ProductPage(driver);
    }

    @And("The user selects correct {string}, {string} etc.")
    public void theUserSelectsCorrectSizeQuantity(String size, String quantity) {
//        Assert.assertEquals(productPage.getRegularPrice()*0.8, productPage.getDiscountedPrice());
        productPage.selectSize(size);
        productPage.selectQuantity(quantity);

    }

    @And("The user adds items to shopping cart")
    public void theUserAddsItemsToShoppingCart() {
        productPage.addProductToCart();
        addedToCartCard = new AddedToCartCard(driver);
    }

    @When("The user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        addedToCartCard.clickProceedToCheckout();

        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.proceedToCheckout();

        checkoutAddressesPage = new CheckoutAddressesPage(driver);
    }

    @And("The user confirms shipping address, {string}, {string}, {string}, {string}, {string}")
    public void theUserConfirmsShippingAddress(String alias, String address, String city, String postCode, String country) {
        Assert.assertEquals("Imię Nazwisko"+"\n"+ address+"\n"+city+"\n"+postCode+"\n"+country, checkoutAddressesPage.getShippingAddress(alias));
        checkoutAddressesPage.selectShippingAddress(alias);
        checkoutAddressesPage.confirmShippingAddress();

        shippingMethodCard = new ShippingMethodCard(driver);
    }

    @And("The user selects shipping method")
    public void theUserSelectsShippingMethod() {
        shippingMethodCard.selectSelfPickUp();
        shippingMethodCard.clickContinueButton();

        paymentMethodCard = new PaymentMethodCard(driver);
    }

    @And("the user selects payment type")
    public void theUserSelectsPaymentType() {
        paymentMethodCard.selectPayByCheck();
        paymentMethodCard.acceptTermsConditions();
    }

    @And("the user clicks on Place Order")
    public void theUserClicksOnPlaceOrder() {
        paymentMethodCard.placeOrder();

        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @Then("The order is created")
    public void theOrderIsCreated() {
        Assert.assertTrue(orderConfirmationPage.getBannerText().contains("YOUR ORDER IS CONFIRMED"));
        orderConfirmationPage.screenshotConfirmation();
    }

}
