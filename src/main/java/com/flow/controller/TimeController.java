package com.flow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间控制器，提供本地时间查询接口。
 */
@RestController
public class TimeController {
    /**
     * 查询本地系统时间和时区
     * @param timezone 可选时区参数
     * @return 包含 time（ISO 8601）和 timezone 的 JSON
     */
    @GetMapping("/api/local-time")
    public Map<String, String> getLocalTime(@RequestParam(value = "timezone", required = false) String timezone) {
        ZonedDateTime now;
        if (timezone != null && !timezone.isEmpty()) {
            try {
                now = ZonedDateTime.now(ZoneId.of(timezone));
            } catch (Exception e) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Invalid timezone: " + timezone);
                return error;
            }
        } else {
            now = ZonedDateTime.now();
        }
        Map<String, String> result = new HashMap<>();
        result.put("time", now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        result.put("timezone", now.getZone().toString());
        return result;
    }
} 
