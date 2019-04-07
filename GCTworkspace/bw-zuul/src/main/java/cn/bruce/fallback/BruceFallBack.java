package cn.bruce.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component  //zuul环境中启动它作为一个断路器
public class BruceFallBack implements ZuulFallbackProvider {


    @Override
    public String getRoute() {
        return "*";   //路由 通用
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override//状态码
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override//状态码的值
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override//状态文字描述
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override//关闭
            public void close() {

            }

            @Override //返回内容
            public InputStream getBody() throws IOException {
                String msg = "jameszuul"; //可以构建对象json串
                return new ByteArrayInputStream(msg.getBytes());
            }

            @Override//头信息
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

                return headers;
            }
        };
    }
}
