package com.example.lab9.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab9.model.Account;
import com.example.lab9.service.AccountService;
import com.example.lab9.service.DepositService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final DepositService depositService;

    public AccountController(AccountService accountService,
                              DepositService depositService) {
        this.accountService = accountService;
        this.depositService = depositService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/{id}/deposit")
    public Map<String, String> deposit(@PathVariable Long id, @RequestBody DepositRequest request) {
        depositService.deposit(id, request.getAmount());
        return Map.of("message", "Deposit successful");
    }

    // class เล็กๆ สำหรับรับ JSON body ของ deposit เช่น { "amount": 1000 }
    static class DepositRequest {
        private Double amount;

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }
    }
}