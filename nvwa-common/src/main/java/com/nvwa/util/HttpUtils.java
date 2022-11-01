package com.nvwa.util;

import com.nvwa.remote.response.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Desc: Http工具类
 * @Author: 泽露
 * @Date: 2022/11/1 7:08 PM
 * @Version: 1.initial version; 2022/11/1 7:08 PM
 */

@Slf4j
public class HttpUtils {

    public static final String POST_ERROR = "post_error";

    /**
     * 发送http请求
     *
     * @param headers
     * @param url
     * @return
     */
    public static RestResult<Object> doPost(HttpHeaders headers, Map<String, Object> body, String url) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        RestResult<Object> result = RestResult.buildFail(POST_ERROR);
        try {
            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
            result = RestResult.builder()
                    .data(response.getBody())
                    .errno(response.getStatusCode().value())
                    .errMsg(response.getStatusCode().getReasonPhrase())
                    .build();
        } catch (Exception e) {
            log.error("[HttpUtil]|doPost|exception:{}", e.getMessage());
            throw e;
        }
        return result;
    }

    /**
     * doPost
     * @param body
     * @param url
     * @return
     * @throws Exception
     */
    public static RestResult<Object> doPost(Map<String, Object> body, String url) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return doPost(headers, body, url);
    }
}
