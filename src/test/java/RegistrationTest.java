import com.javacodegeeks.enterprise.rest.jersey.jerseyclient.RestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sazzad on 1/27/16.
 */
public class RegistrationTest {
    @Test
    public void testPost() {
        HashMap<String, Object> rootMap =
                RestAPI.callPost(
                        "http://localhost/web-corporate/api/submit/corporate/registration/get",
                        "{\"Params\": {\"RegistrationID\":9}}");
        System.out.println(rootMap);
        HashMap<String, Object> dataMap = (HashMap<String, Object>) rootMap.get("Data");
        Assert.assertEquals(dataMap.get("RegistrationID"), 9);

    }


    @Test
    public void testPostWithCollection() {

        ArrayList<HashMap<String, Object>> hashMaps = RestAPI.callPostWithList(
                "https://9ehgtjukre.execute-api.us-east-1.amazonaws.com/dev_api/v1/registrations/request/collection",
                "[{\"RequestTypeID\":1,\"ContactID\":1,\"ProductID\":1,\"PackageID\":13}]");
        System.out.println(hashMaps);
        Assert.assertEquals(hashMaps.get(0).get("PackageID"),13);

    }

    @Test
    public void testPostWithCollectionForError() {

        ArrayList<HashMap<String, Object>> hashMaps = RestAPI.callPostWithList(
                "https://9ehgtjukre.execute-api.us-east-1.amazonaws.com/dev_api/v1/registrations/request/collection",
                "[{\"RequestTypeID\":1,\"ContactID\":1,\"ProductID\":1,\"PackageID\":13}]");
        System.out.println(hashMaps);
        Assert.assertEquals(hashMaps.get(0).get("Description"),"Duplicate record found");

    }


    @Test
    public void testGetWithList() {

        ArrayList<HashMap<String, Object>> rootMap =
                RestAPI.callGetWithList("https://9ehgtjukre.execute-api.us-east-1.amazonaws.com/dev_api/v1/accounts/1/packages/2/products/2/registrations/composite");
        Assert.assertEquals(rootMap.get(0).get("AccountID"), 1);

    }




}
