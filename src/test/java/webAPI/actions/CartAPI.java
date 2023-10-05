package webAPI.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import utils.ConfigLoaders;
import webAPI.actions.constants.EndPoint;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class CartAPI {

    Cookies cookies = new Cookies();

    public CartAPI(){}

    public CartAPI(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Response addToCartAPI(int productID, int qty){
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<String,Object>();
        formParams.put("product_sku","");
        formParams.put("product_id",productID);
        formParams.put("quantity",qty);
        if (cookies == null) {
            cookies = new Cookies();
        }
//        Response response =given().
//                baseUri(ConfigLoaders.getInstance().getBaseURL())
//                .headers(headers)
//                .formParams(formParams)
//                .cookies(cookies)
//                .log().all()
//        .when()
//                .post("/?wc-ajax=add_to_cart")
//        .then()
//                .log().all()
//                .extract()
//                .response();

        Response response = APIRequestHttpMethods.post(EndPoint.ADD_TO_CART.url, headers, formParams, cookies);
        if(response.getStatusCode() != 200){
            throw  new RuntimeException("Failed to add to cart, HTTP status code: " + response.statusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}

