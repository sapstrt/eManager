package com.emanager.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 10/22/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class GoogleTokenValidator {
    final static Logger LOGGER = LoggerFactory.getLogger(GoogleTokenValidator.class);
    Checker checker;

    public GoogleTokenValidator(String audience, String clientIdNotSeparated) {
        String[] clientIds = clientIdNotSeparated.split(",");
        checker = new Checker(clientIds, audience);
    }

    public String validateIdTokenAndGetEmailId(String idToken) {
        GoogleIdToken.Payload payload = null;
        if ((payload = checker.check(idToken)) == null)
            return null;
        LOGGER.debug("This is the value of the payload :"
                + '\n' + "USer Email " + payload.getEmail()
                + '\n' + "USer AccessTokenHash " + payload.getAccessTokenHash()
                + '\n' + "USer UserId " + payload.getUserId()
                + '\n' + "USer HostedDomain " + payload.getHostedDomain()
                + '\n' + "USer Issuee " + payload.getIssuee());
        return payload.getEmail();

    }


}

class Checker {

    private final List mClientIDs;
    private final String mAudience;
    private final GoogleIdTokenVerifier mVerifier;
    private final JsonFactory mJFactory;
    private String mProblem = "Verification failed. (Time-out?)";

    public Checker(String[] clientIDs, String audience) {
        mClientIDs = Arrays.asList(clientIDs);
        mAudience = audience;
        NetHttpTransport transport = new NetHttpTransport();
        mJFactory = new GsonFactory();
        mVerifier = new GoogleIdTokenVerifier(transport, mJFactory);
    }

    public GoogleIdToken.Payload check(String tokenString) {
        GoogleIdToken.Payload payload = null;
        try {
            GoogleIdToken token = GoogleIdToken.parse(mJFactory, tokenString);
            if (mVerifier.verify(token)) {
                GoogleIdToken.Payload tempPayload = token.getPayload();
                if (!tempPayload.getAudience().equals(mAudience))
                    mProblem = "Audience mismatch";
                else if (!mClientIDs.contains(tempPayload.getIssuee()))
                    mProblem = "Client ID mismatch";
                else
                    payload = tempPayload;
            }
        } catch (GeneralSecurityException e) {
            mProblem = "Security issue: " + e.getLocalizedMessage();
        } catch (IOException e) {
            mProblem = "Network problem: " + e.getLocalizedMessage();
        }
        return payload;
    }

    public String problem() {
        return mProblem;
    }
}
