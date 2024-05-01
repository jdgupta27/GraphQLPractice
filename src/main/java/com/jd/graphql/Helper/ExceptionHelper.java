package com.jd.graphql.Helper;

public class ExceptionHelper {
    public static RuntimeException throwResourceNotFoundException(){
        return new RuntimeException("Resource not found");
    }

}
