package API.clients;

import API.models.AuthRequest;
import API.models.AuthResponse;


public class AuthorizationClient extends BaseClient {
    public AuthorizationClient() {
        super();
    }
    public AuthResponse post(AuthRequest credential) {
        return prepareRequest()
                .body(credential)
                .when()
                .post(baseUrl+ "/auth")
                .as(AuthResponse.class);


    }
}
