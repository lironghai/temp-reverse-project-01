package com.flow.controller;

import com.flow.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 账号控制器，提供账号相关的REST接口。
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 根据账号ID获取账号信息
     */
    @GetMapping("/{id}")
    public Map<String, Object> getAccount(@PathVariable("id") long id) {
        return accountService.getAccountById(id);
    }

    /**
     * 创建新账号
     */
    @PostMapping("")
    public void createAccount(@RequestBody Map<String, Object> accountInfo) {
        accountService.createAccount(accountInfo);
    }

    /**
     * 更新账号信息
     */
    @PutMapping("/{id}")
    public void updateAccount(@PathVariable("id") long id, @RequestBody Map<String, Object> accountInfo) {
        accountService.updateAccount(id, accountInfo);
    }

    /**
     * 删除账号
     */
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") long id) {
        accountService.deleteAccount(id);
    }
} 
