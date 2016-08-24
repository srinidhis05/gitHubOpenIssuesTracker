package com.sri.api;

/**
 * Created by srinidhis on 17/08/16.
 */
//An ENUM to map the URL to call
public enum  URLMapper {
    ISSUES("/issues"),
    REPO("");

    private final String URLPath;

    URLMapper(String s) {
        this.URLPath=s;
    }

    public String getFullURLPath(String repoName){
        String result=repoName+this.URLPath;
        return "https://api.github.com/repos/"+result;
    }
}
