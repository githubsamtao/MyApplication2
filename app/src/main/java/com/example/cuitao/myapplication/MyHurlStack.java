package com.example.cuitao.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.HttpStack;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by CUITAO on 2017/09/04.
 *
 */

public class MyHurlStack implements HttpStack {
    private static final String  HEADER_CONTENT_TYPE = "Content-Type";
    public interface  UrlRewriter{
        public String rewriteUrl(String originalUrl);
    }

    public MyHurlStack() {
        this(null);

    }

    public MyHurlStack(UrlRewriter urlRewriter){

    }
//    public MyHurlStack(UrlRewriter urlRewriter){
//
//    }

    @Override
    public HttpResponse performRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
        return null;
    }
}
