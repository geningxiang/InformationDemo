package com.caimao.information.common.http;

import okhttp3.Response;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/6/2 21:17
 */
public class HttpResponse {
    private final int code;
    private final String message;
    private final byte[] body;

    public HttpResponse(Response response) throws IOException {
        this.code = response.code();
        this.message = response.message();
        this.body = response.body().bytes();
    }

    public boolean isSuccessful() {
        return this.code == 200;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public byte[] getBody() {
        return body;
    }

    public String getBody(Charset charset) {
        return new String(this.body, charset);
    }
}
