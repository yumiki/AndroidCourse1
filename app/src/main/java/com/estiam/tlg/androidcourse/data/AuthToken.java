package com.estiam.tlg.androidcourse.data;

/**
 * Created by nono on 24/02/2017.
 */

public class AuthToken {

    private static final String LOGIN="ludo";
    private static final String PASSWORD="test";

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static AuthToken createToken(String login, String password) throws InvalidValueException {
        AuthToken authToken= new AuthToken();

        if(login.equals(LOGIN))
            if (password.equals(PASSWORD)){
                authToken.setValue(createValue(login,password));
                return authToken;
            }
            else throw new InvalidValueException("Password invalid");
        else
            throw new InvalidValueException("Login invalid");
    }

    public static class InvalidValueException extends Exception {
        InvalidValueException(String message) {
            super(message);
        }
    }

    private static String createValue(String login,String password){
        return login.hashCode()+""+password.hashCode();
    }
}
