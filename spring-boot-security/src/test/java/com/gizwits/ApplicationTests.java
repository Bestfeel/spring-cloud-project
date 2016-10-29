package com.gizwits;

import com.gizwits.bean.User;
import com.gizwits.main.Application;
import com.gizwits.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ApplicationTests {


    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sender.send("spring-amqp-rabbitmq", "aaaaaa");
    }

    @Test
    public void testVanillaService() {
        RestTemplate restTemplate = new RestTemplate();

        User user = restTemplate.getForObject("http://localhost:8080/user", User.class);
        System.out.println(user);
//	    Assert.assertEquals("Hello World!", );
    }

    @Test
    public void testSecureService() {

        // curl -XGET   --insecure --user  guest:guest123  http://localhost:8080/user


        String plainCreds = "guest:guest123";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + new String(Base64.encode(plainCreds.getBytes())));
        HttpEntity<String> request = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> response = restTemplate.exchange("http://localhost:8080/user", HttpMethod.GET, request, User.class);
//		Assert.assertEquals("Hello World!", response.getBody().getMessage());

        System.out.println(response.getBody().toString());
    }


    @Test

    public void testOAuthService() {

        //  curl -X POST  -d "username=guest&password=guest123&client_id=trustedclient&client_secret=trustedclient123&grant_type=password"   http://localhost:8080/oauth/token

        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setUsername("guest");
        resource.setPassword("guest123");
        resource.setAccessTokenUri("http://localhost:8080/oauth/token");
        resource.setClientId("trustedclient");
        resource.setClientSecret("trustedclient123");
        resource.setGrantType("password");

        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, clientContext);
        OAuth2AccessToken accessToken = restTemplate.getAccessToken();
        System.out.println(accessToken);
        System.out.println(restTemplate.getResource());


        //  User user = restTemplate.getForObject("http://localhost:8080/user", User.class);
//
//
        // System.out.println(user);

    }


}