package com.zhang.db.controller;

import com.zhang.db.service.RetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RetryController {
    @Resource
    private RetryService retryService;
    @GetMapping("/retry")
    public String getRetry() throws Exception {
        return retryService.retry();
    }
}
