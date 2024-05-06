package org.hca.quizapplication.constant;

public class EndPoints {
    public static final String VERSION="/v2";
    //profiller:
    public static final String API="/api";
    public static final String DEV="/dev";
    public static final String TEST="/test";

    public static final String ROOT=API+VERSION;

    //entities:
    public static final String ANSWER ="/answers";
    public static final String QUESTION="/questions";
    public static final String QUIZ ="/quiz";

    //methods:
    public static final String CREATE="";
    public static final String FIND_ALL ="";
    public static final String UPDATE="/{id}";
    public static final String DELETE="/{id}";
    public static final String FIND_BY_ID="/{id}";
    public static final String GET_QUIZ = "/{questionCount}";
}
