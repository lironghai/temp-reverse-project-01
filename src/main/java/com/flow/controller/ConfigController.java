package com.flow.controller;

import com.flow.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * 配置控制器，提供配置相关的REST接口。
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    /**
     * 判断IP是否为白名单
     */
    @GetMapping("/whitelist/{ip}")
    public boolean isWhiteList(@PathVariable("ip") String ip) {
        return configService.chenckIpIsWhiteList(ip);
    }

    /**
     * 查询所有游戏充值单位
     */
    @GetMapping("/charge-units")
    public List<Map<String, Object>> allGameChargeUnit() {
        return configService.allGameChargeUnit();
    }
} 
