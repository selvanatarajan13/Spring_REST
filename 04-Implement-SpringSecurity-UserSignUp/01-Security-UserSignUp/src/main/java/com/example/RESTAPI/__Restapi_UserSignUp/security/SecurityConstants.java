package com.example.RESTAPI.__Restapi_UserSignUp.security;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SIGN_UP_URL = "/users";
    public static final String TOKEN_SECRET = "c4a71ea639f6de11f146f21193d91c4518a3c285f1853d44778910d6130a4c03";
    public static final String HEADER_STRING = "Authorization";
}
