package com.caimao.information.common.http;

import com.caimao.information.common.base.Charsets;
import okhttp3.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/6/1 21:17
 */
public class HttpRequest {

    /**
     * 请求类型
     */
    public enum TYPE {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH
    }

    /**
     * 默认 GET请求
     */
    private TYPE type = TYPE.GET;
    /**
     * 读取超时时间 默认20秒
     */
    private int readTimeout = 20;
    /**
     * 连接超时时间 默认20秒
     */
    private int connectTimeout = 20;
    /**
     * 编码格式 默认 UTF-8
     */
    private Charset charset = Charsets.UTF_8;

    private Proxy proxy = null;

    /**
     * 重试次数     !最大10次
     */
    private int retryNum = 0;

    private Map<String, String> headers = new HashMap<>();

    public HttpRequest setType(TYPE type) {
        if (type != null) {
            this.type = type;
        }
        return this;
    }

    public HttpRequest readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public HttpRequest connectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public HttpRequest charset(Charset charset) {
        if (charset != null) {
            this.charset = charset;
        }
        return this;
    }

    public HttpRequest proxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public HttpRequest addHeader(String key, String value) {
        if (key != null) {
            this.headers.put(key, value);
        }
        return this;
    }

    public HttpRequest addHeader(Map<String, String> headers) {
        if (headers != null) {
            this.headers.putAll(headers);
        }
        return this;
    }

    public HttpRequest retryNum(int retryNum) {
        if (retryNum > 0) {
            if (retryNum > 10) {
                retryNum = 10;
            }
            this.retryNum = retryNum;
        }
        return this;
    }

    public HttpResponse doRequest(String url, Map<String, Object> paramsMap) throws IOException {
        Request request = buildRequest(url, paramsMap);
        return execute(request);
    }

    public void doRequest(String url, Map<String, Object> paramsMap, Callback callBack) throws IOException {
        Request request = buildRequest(url, paramsMap);
        execute(request, callBack);
    }

    private Request buildRequest(String url, Map<String, Object> paramsMap) {
        Request.Builder requestBuilder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        //TODO Cookie 了解一下
        if (type == TYPE.GET) {
            url = addParamsToUrl(url, paramsMap);
        }
        requestBuilder.url(url);
        if (type != TYPE.GET) {
            RequestBody body = bulidFormBody(paramsMap);
            switch (type) {
                case POST: {
                    requestBuilder.post(body);
                    break;
                }
                case PUT: {
                    requestBuilder.put(body);
                    break;
                }
                case DELETE: {
                    requestBuilder.delete(body);
                    break;
                }
                case PATCH: {
                    requestBuilder.patch(body);
                    break;
                }
            }
        }
        return requestBuilder.build();
    }

    private OkHttpClient buildClient() {
        //TODO 连接池 了解一下？
        //.connectionPool(new ConnectionPool(20, 5, TimeUnit.MINUTES))

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                //读取超时 20秒
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                //连接超时 20秒
                .connectTimeout(connectTimeout, TimeUnit.SECONDS);
        if (proxy != null) {
            builder.proxy(proxy);
        }
        if (retryNum > 0) {
            //重试次数
            builder.addInterceptor(new RetryIntercepter(retryNum));
        }
        return builder.build();
    }

    private HttpResponse execute(Request request) throws IOException {
        return new HttpResponse(bulidCall(request).execute());
    }

    private void execute(Request request, Callback callback) {
        bulidCall(request).enqueue(callback);
    }

    private Call bulidCall(Request request) {
        OkHttpClient client = buildClient();
        return client.newCall(request);
    }

    /**
     * @param url       接口地址
     * @param paramsMap 请求参数
     */
    private String addParamsToUrl(String url, Map<String, Object> paramsMap) {
        if (paramsMap != null) {
            StringBuilder temp = new StringBuilder(200);
            temp.append(url);
            if (temp.indexOf("?") > -1) {
                temp.append("&");
            } else {
                temp.append("?");
            }
            //处理参数
            int pos = 0;
            for (String key : paramsMap.keySet()) {
                if (pos > 0) {
                    temp.append("&");
                }
                temp.append(key);
                temp.append("=");
                try {
                    temp.append(URLEncoder.encode(String.valueOf(paramsMap.get(key)), charset.name()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                pos++;
            }
            return temp.toString();
        } else {
            return url;
        }
    }

    private FormBody bulidFormBody(Map<String, Object> paramsMap) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder(charset);
        if (paramsMap != null) {
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                formBodyBuilder.add(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return formBodyBuilder.build();
    }


}