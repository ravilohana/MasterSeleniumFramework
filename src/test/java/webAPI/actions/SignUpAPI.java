package webAPI.actions;

import io.restassured.http.Cookies;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import objects.LoginCredentials;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import utils.ConfigLoaders;

import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SignUpAPI {
    private Cookies cookies;

    public Cookies getCookies(){
        return cookies;
    }

    public String fetchRegisterNonceValueUsingGroovy(){
        Response response = getAccount();
        return response.htmlPath().getString("**.findAll {it.@name=='woocommerce-register-nonce'}.@value");
    }

    public String fetchRegisterNonceValueUsingJSoup(){
        Response response = getAccount();
        Document document = Jsoup.parse(response.body().prettyPrint());
        Element element = document.selectFirst("#woocommerce-register-nonce");
        assert element != null;
        return element.attr("value");
    }

    public Response getAccount(){
        Cookies cookies = new Cookies();
        Response response =given().
                baseUri(ConfigLoaders.getInstance().getBaseURL()).
                cookies(cookies)
                .log().all()
        .when()
                .get("/account")
        .then()
                .log().all()
                .extract()
                .response();
        if(response.getStatusCode() !=200){
            throw  new RuntimeException("Failed to fetch the account, HTTP status code: " + response.statusCode());
        }
        return response;
    }

    public Response register(LoginCredentials user){
        Cookies cookies = new Cookies();
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,String> formParams = new HashMap<String,String>();
        formParams.put("username",user.getUsername());
        formParams.put("email",user.getEmail_id());
        formParams.put("password",user.getPassword());
        formParams.put("woocommerce-register-nonce",fetchRegisterNonceValueUsingGroovy());
        formParams.put("register","Register");
        Response response =given().
                baseUri(ConfigLoaders.getInstance().getBaseURL())
                .headers(headers)
                .formParams(formParams)
                .cookies(cookies)
                .log().all()
        .when()
                .post("/account")
        .then()
                .log().all()
                .extract()
                .response();
        if(response.getStatusCode() != 302){
            throw  new RuntimeException("Failed to fetch the account, HTTP status code: " + response.statusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
