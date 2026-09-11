package com.example.lab9.service;

import org.springframework.stereotype.Service;

import com.example.lab9.model.Account;
import com.example.lab9.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    // ใช้ Constructor Injection แทน @Autowired บน field
    // ข้อดี: บังคับให้ dependency ต้องมีตอนสร้าง object (ไม่มีทาง null)
    // และทำ unit test ได้ง่ายกว่า (mock เข้ามาทาง constructor ได้ตรงๆ)
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }
}