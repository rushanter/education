package com.education.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.util.*;
import java.util.Map.Entry;

public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private static PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 600000;

    public HttpUtil() {
    }

    public static String doGet(String url, Map<String, Object> params) {
        return doGet(url, params, (Map) null);
    }

    public static String doGet(String url, Map<String, Object> params, Map<String, Object> headers) {
        StringBuffer param = new StringBuffer();
        int i = 0;
        if (params != null) {
            for (Iterator var6 = params.keySet().iterator(); var6.hasNext(); ++i) {
                String key = (String) var6.next();
                if (i == 0) {
                    param.append("?");
                } else {
                    param.append("&");
                }
                param.append(key).append("=");
                try {
                    param.append(URLEncoder.encode(params.get(key).toString(), "UTF-8"));
                } catch (Exception var12) {
                    param.append(params.get(key));
                }
            }
        }

        String apiUrl = url + param;
        String result = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpGet httpGet = new HttpGet(apiUrl);
            if (headers != null) {
                Iterator var9 = headers.entrySet().iterator();

                while (var9.hasNext()) {
                    Entry<String, Object> it = (Entry) var9.next();
                    httpGet.addHeader((String) it.getKey(), it.getValue().toString());
                }
            }

            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                result = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException var13) {
            logger.error("doGet [{}] error. Exception:[{}]", apiUrl, var13);
        }

        return result;
    }

    public static String doPost(String url) {
        return doPost(url, (Map) (new HashMap()));
    }

    public static String doPost(String url, Map<String, Object> params) {
        return doPost(url, (Map) params, (Map) null);
    }

    public static String doPost(String url, Map<String, Object> params, Map<String, Object> headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList(params.size());
            Iterator var8 = params.entrySet().iterator();

            Entry it;
            while (var8.hasNext()) {
                it = (Entry) var8.next();
                NameValuePair pair = new BasicNameValuePair((String) it.getKey(), it.getValue().toString());
                pairList.add(pair);
            }
            if (headers != null) {
                var8 = headers.entrySet().iterator();

                while (var8.hasNext()) {
                    it = (Entry) var8.next();
                    httpPost.setHeader((String) it.getKey(), it.getValue().toString());
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException var19) {
            logger.error("doPost [{}] error. Exception:[{}]", httpPost.toString(), var19);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var18) {
                    logger.error("close inputstream error. url[{}] Exception:[{}]", httpPost.toString(), var18);
                }
            }
        }
        return httpStr;
    }

    public static String doPut(String url, Map<String, Object> params, Map<String, Object> headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPut httpPut = new HttpPut(url);
        CloseableHttpResponse response = null;

        try {
            httpPut.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList(params.size());
            Iterator var8 = params.entrySet().iterator();
            Entry it;
            while (var8.hasNext()) {
                it = (Entry) var8.next();
                NameValuePair pair = new BasicNameValuePair((String) it.getKey(), it.getValue().toString());
                pairList.add(pair);
            }
            if (headers != null) {
                var8 = headers.entrySet().iterator();

                while (var8.hasNext()) {
                    it = (Entry) var8.next();
                    httpPut.setHeader((String) it.getKey(), it.getValue().toString());
                }
            }
            httpPut.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPut);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException var19) {
            logger.error("doPut [{}] Exception:[{}].", httpPut.toString(), var19);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var18) {
                    logger.error("doPut [{}],close inputstream error:[{e}]", httpPut.toString(), var18);
                }
            }
        }
        return httpStr;
    }

    public static String doDelete(String url, Map<String, Object> headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpDelete httpDelete = new HttpDelete(url);
        CloseableHttpResponse response = null;

        try {
            httpDelete.setConfig(requestConfig);
            if (headers != null) {
                Iterator var6 = headers.entrySet().iterator();

                while (var6.hasNext()) {
                    Entry<String, Object> it = (Entry) var6.next();
                    httpDelete.setHeader((String) it.getKey(), it.getValue().toString());
                }
            }
            response = httpClient.execute(httpDelete);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException var16) {
            logger.error("doDelete [{}] Exception:[{}].", httpDelete.toString(), var16);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var15) {
                    logger.error("doDelete [{}],close inputstream error:[{e}]", httpDelete.toString(), var15);
                }
            }
        }
        return httpStr;
    }

    public static String doPost(String url, Object json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json;charset=UTF-8");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException var16) {
            logger.error("doPost [{}] Exception:[{}].", httpPost.toString(), var16);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var15) {
                    logger.error("doPost [{}],close inputstream error:[{e}]", httpPost.toString(), var15);
                }
            }
        }
        return httpStr;
    }

    public static String doPost(String url, Object json, Map<String, Object> headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            if (headers != null) {
                Iterator var7 = headers.entrySet().iterator();

                while (var7.hasNext()) {
                    Entry<String, Object> it = (Entry) var7.next();
                    httpPost.setHeader((String) it.getKey(), it.getValue().toString());
                }
            }
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json;charset=UTF-8");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException var17) {
            logger.error("doPost [{}] Exception:[{}].", httpPost.toString(), var17);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var16) {
                    logger.error("doPost [{}],close inputstream error:[{e}]", httpPost.toString(), var16);
                }
            }
        }
        return httpStr;
    }

    public static String doPostSSL(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;
        BasicNameValuePair pair;
        try {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList(params.size());
            Iterator var7 = params.entrySet().iterator();

            Entry entry;
            while (var7.hasNext()) {
                entry = (Entry) var7.next();
                pair = new BasicNameValuePair((String) entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("utf-8")));
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                entry = null;
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                httpStr = EntityUtils.toString(entity, "utf-8");
                return httpStr;
            }
            pair = null;
        } catch (Exception var21) {
            logger.error("doPostSSL [{}] Exception:[{}].", httpPost.toString(), var21);
            return httpStr;
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var20) {
                    logger.error("doPostSSL [{}],close inputstream error:[{e}]", httpPost.toString(), var20);
                }
            }
        }
        return null;
    }

    public static String doPostSSL(String url, Object json) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;

        Object var9;
        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity;
            if (statusCode != 200) {
                entity = null;
                return null;
            }
            entity = response.getEntity();
            if (entity != null) {
                httpStr = EntityUtils.toString(entity, "utf-8");
                return httpStr;
            }
            var9 = null;
        } catch (Exception var21) {
            logger.error("doPostSSL [{}] Exception:[{}].", httpPost.toString(), var21);
            return httpStr;
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var20) {
                    logger.error("doPostSSL [{}],close inputstream error:[{e}]", httpPost.toString(), var20);
                }
            }
        }

        return (String) var9;
    }

    public static String doPostSSLXml(String url, String xml) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;
        Object var9;
        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(xml, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity;
            if (statusCode != 200) {
                entity = null;
                return null;
            }
            entity = response.getEntity();
            if (entity != null) {
                httpStr = EntityUtils.toString(entity, "UTF-8");
                return httpStr;
            }
            var9 = null;
        } catch (Exception var21) {
            logger.error("doPostSSL [{}] Exception:[{}].", httpPost.toString(), var21);
            return httpStr;
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException var20) {
                    logger.error("doPostSSL [{}],close inputstream error:[{e}]", httpPost.toString(), var20);
                }
            }
        }
        return (String) var9;
    }

    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContexts.custom().loadTrustMaterial((KeyStore) null, new TrustSelfSignedStrategy()).build();
        } catch (Exception var3) {
            logger.error("SSLConnectionSocketFactory Exception:[{}].", var3);
        }
        HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
        return sslsf;
    }

    static {
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        configBuilder.setConnectTimeout(600000);
        configBuilder.setSocketTimeout(600000);
        configBuilder.setConnectionRequestTimeout(600000);
        requestConfig = configBuilder.build();
    }
}
