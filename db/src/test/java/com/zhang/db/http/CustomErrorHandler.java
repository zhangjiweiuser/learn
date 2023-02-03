package com.zhang.db.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/30 14:22
 */
@Slf4j
public class CustomErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        int rawStatusCode = response.getRawStatusCode();
        HttpStatus status = HttpStatus.resolve(rawStatusCode);
        return null != status ? status.isError() : hasError(rawStatusCode);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        log.error("=======================ERROR============================");
        log.error("HOST:{},URI：{}", url.getHost(), url.getPath());
        log.error("Method Type：{}", method.name());
        log.error("Exception：{}", response.getStatusCode());
        log.error("========================================================");
    }

    protected boolean hasError(int unknownStatusCode) {
        HttpStatus.Series series = HttpStatus.Series.resolve(unknownStatusCode);
        return (series == HttpStatus.Series.CLIENT_ERROR || series == HttpStatus.Series.SERVER_ERROR);
    }
}
