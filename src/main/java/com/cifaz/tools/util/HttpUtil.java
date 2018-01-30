package com.cifaz.tools.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private static int socketTimeOut = 250000;
    private static int connectionTimeOut = 30000;
    private static int setConnectionRequestTimeout = 1000;

    public HttpUtil() {
    }

    public static String httpGet(String url) throws IOException {
        return httpGet(url, (Map) null);
    }

    public static String httpGet(String url, Map<String, String> headers) throws IOException {
        traceRequestLog(url, "");
        HttpGet httpGet = new HttpGet(url);
        if (null != headers && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            Iterator i = keys.iterator();

            while (i.hasNext()) {
                String key = (String) i.next();
                httpGet.addHeader(key, (String) headers.get(key));
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeOut).setConnectTimeout(connectionTimeOut).setConnectionRequestTimeout(setConnectionRequestTimeout).build();
        httpGet.setConfig(requestConfig);

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            Throwable var36 = null;

            String var10;
            try {
                CloseableHttpResponse httpResponse = null;

                try {
                    httpResponse = httpClient.execute(httpGet);
                    HttpEntity entity = null;
                    String result = "";
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        entity = httpResponse.getEntity();
                        result = EntityUtils.toString(entity, "utf-8");
                        traceResponseLog(url, result);
                    } else {
                        logger.error("请求：" + url + "失败！ Code = " + statusCode);
                        httpGet.abort();
                    }

                    EntityUtils.consume(entity);
                    var10 = result;
                } catch (Exception var29) {
                    httpGet.abort();
                    throw var29;
                } finally {
                    if (null != httpResponse) {
                        httpResponse.close();
                    }

                }
            } catch (Throwable var31) {
                var36 = var31;
                throw var31;
            } finally {
                if (httpClient != null) {
                    if (var36 != null) {
                        try {
                            httpClient.close();
                        } catch (Throwable var28) {
                            var36.addSuppressed(var28);
                        }
                    } else {
                        httpClient.close();
                    }
                }

            }

            return var10;
        } catch (IOException var33) {
            logger.error("Http get failed !", var33);
            throw var33;
        }
    }

    public static String httpPost(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
        traceRequestLog(url, JsonUtil.toJson(params));
        HttpPost httpPost = new HttpPost(url);
        if (null != headers && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            Iterator i = keys.iterator();

            while (i.hasNext()) {
                String key = (String) i.next();
                httpPost.addHeader(key, (String) headers.get(key));
            }
        }

        ArrayList<BasicNameValuePair> pairs = new ArrayList();
        if (null != params && params.size() > 0) {
            Set<String> keys = params.keySet();
            Iterator i = keys.iterator();

            while (i.hasNext()) {
                String key = (String) i.next();
                pairs.add(new BasicNameValuePair(key, (String) params.get(key)));
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeOut).setConnectTimeout(connectionTimeOut).setConnectionRequestTimeout(setConnectionRequestTimeout).build();
        httpPost.setConfig(requestConfig);

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            Throwable var38 = null;

            String var12 = null;
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
                CloseableHttpResponse httpResponse = null;

                try {
                    httpResponse = httpClient.execute(httpPost);
                    HttpEntity entity = null;
                    String result = "";
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if (statusCode == 200) {
                        entity = httpResponse.getEntity();
                        result = EntityUtils.toString(entity, "utf-8");
                        traceResponseLog(url, result);
                    } else {
                        logger.error("请求：" + url + "失败！ Code = " + statusCode);
                        httpPost.abort();
                    }

                    EntityUtils.consume(entity);
                    var12 = result;
                } finally {
                    if (null != httpResponse) {
                        httpResponse.close();
                    }

                }
            } catch (Throwable var30) {
                var38 = var30;
                try {
                    throw var30;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            } finally {
                if (httpClient != null) {
                    if (var38 != null) {
                        try {
                            httpClient.close();
                        } catch (Throwable var28) {
                            var38.addSuppressed(var28);
                        }
                    } else {
                        httpClient.close();
                    }
                }

            }

            return var12;
        } catch (IOException var32) {
            logger.error("Http get failed !", var32);
            throw var32;
        }
    }

    public static String httpPostForm(String url, Map<String, String> params) throws IOException {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return httpPost(url, headers, (Map) params);
    }

    public static String httpPostJson(String url, String json) throws IOException {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        return httpPost(url, headers, (String) json);
    }

    public static String httpPost(String url, Map<String, String> headers, String params) throws IOException {
        traceRequestLog(url, params);
        HttpPost httpPost = new HttpPost(url);
        if (null != headers && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            Iterator i = keys.iterator();

            while (i.hasNext()) {
                String key = (String) i.next();
                httpPost.addHeader(key, (String) headers.get(key));
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeOut).setConnectTimeout(connectionTimeOut).setConnectionRequestTimeout(setConnectionRequestTimeout).build();
        httpPost.setConfig(requestConfig);

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            Throwable var34 = null;

            String var11;
            try {
                httpPost.setEntity(new StringEntity(params, "UTF-8"));
                CloseableHttpResponse httpResponse = null;

                try {
                    httpResponse = httpClient.execute(httpPost);
                    HttpEntity entity = null;
                    String result = "";
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if (statusCode == 200) {
                        entity = httpResponse.getEntity();
                        result = EntityUtils.toString(entity, "utf-8");
                        traceResponseLog(url, result);
                    } else {
                        logger.error("请求：" + url + "失败！ Code = " + statusCode);
                        httpPost.abort();
                    }

                    EntityUtils.consume(entity);
                    var11 = result;
                } finally {
                    if (null != httpResponse) {
                        httpResponse.close();
                    }

                }
            } catch (Throwable var29) {
                var34 = var29;
                throw var29;
            } finally {
                if (httpClient != null) {
                    if (var34 != null) {
                        try {
                            httpClient.close();
                        } catch (Throwable var27) {
                            var34.addSuppressed(var27);
                        }
                    } else {
                        httpClient.close();
                    }
                }

            }

            return var11;
        } catch (IOException var31) {
            logger.error("Http get failed !", var31);
            throw var31;
        }
    }

    private static void traceRequestLog(String requestURL, String outputStr) {
        String log = "请求：" + requestURL;
        if (StringUtils.isNotBlank(outputStr)) {
            log = log + "\r\nRequest Body = " + outputStr;
        }

        logger.info(log);
    }

    private static void traceResponseLog(String requestURL, String inputStr) {
        String log = "响应：" + requestURL;
        if (StringUtils.isNotBlank(inputStr)) {
            log = log + "\r\nResponse Body = " + inputStr;
        }

        logger.info(log);
    }

    public static void main(String[] args) throws IOException {
        String body = "{\"sign\": \"db20161019sivbja8c63cf9c00684c54f222a11a786f7ecf378e5676\",\"account\": \"DB20161019SIVBJA\",\"timestamp\":\"1362637045837\"}";
        httpPostJson("http://charge.vipgogo.com/flow/getAccountInfo", body);
    }
}
