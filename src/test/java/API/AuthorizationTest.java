package API;


import API.clients.AuthorizationClient;
import API.models.AuthRequest;
import API.models.AuthResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AuthorizationTest {

    @Test
    public void testAuth() {
        AuthorizationClient client = new AuthorizationClient();
        AuthRequest credential = new AuthRequest("admin", "password123");
        AuthResponse response = client.post(credential);
        Assert.assertNotNull(response.getToken());
    }
}
