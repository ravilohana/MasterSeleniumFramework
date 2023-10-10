package webAPI.actions;

import objects.LoginCredentials;
import org.checkerframework.checker.units.qual.C;
import org.selenium.pom.tests.AddToCartTest;
import utils.ConfigLoaders;
import utils.FakerUtils;

public class DummyClass {
    public static void main(String[] args) {
//       new SignUpAPI().getAccount();
//        System.out.println(new SignUpAPI().fetchRegisterNonceValue());
//        String username = "demouser" + new FakerUtils().generateRandomNumber();
//        String email_id = "demouser"+ new FakerUtils().generateRandomNumber()+"@gmail.com";
//        String password = "demouser"+ new FakerUtils().generateRandomNumber();
//        LoginCredentials userRegister = new LoginCredentials()
//                .setUsername(username)
//                        .setEmail_id(email_id)
//                                .setPassword(password);
//        SignUpAPI signUpAPI = new SignUpAPI();
//        signUpAPI.register(userRegister);
//        System.out.println("REGISTER COOKIES: " + signUpAPI.getCookies());
//
//
//        // Add to Cart API without logging
//        // Add to Cart API with logging first we have to register
//        CartAPI cartAPI = new CartAPI(signUpAPI.getCookies());
//        System.out.println(cartAPI.addToCartAPI(1215,1));
//        System.out.println(cartAPI.getCookies());

//        LoginCredentials loginCredentials = new LoginCredentials();
//        System.out.println(ConfigLoaders.getInstance().getPassword());
//        System.out.println(ConfigLoaders.getInstance().getUsername());
//        System.out.println(ConfigLoaders.getInstance().getEmailId());

            LoginAPI loginAPI = new LoginAPI();
            loginAPI.getAccount();
        System.out.println(loginAPI.fetchRegisterNonceValueUsingGroovy());

        String username = ConfigLoaders.getInstance().getUsername();
        String password = ConfigLoaders.getInstance().getPassword();
                LoginCredentials userLogin = new LoginCredentials()
                .setUsername(username)
                                .setPassword(password);

        loginAPI.userLoginUsingAPI(userLogin);
        System.out.println("Login COOKIES: " + loginAPI.getCookies());

    }
}
