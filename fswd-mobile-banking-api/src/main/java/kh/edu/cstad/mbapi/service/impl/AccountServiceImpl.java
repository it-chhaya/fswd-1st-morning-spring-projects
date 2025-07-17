package kh.edu.cstad.mbapi.service.impl;

import kh.edu.cstad.mbapi.domain.Account;
import kh.edu.cstad.mbapi.domain.AccountType;
import kh.edu.cstad.mbapi.domain.Customer;
import kh.edu.cstad.mbapi.dto.AccountResponse;
import kh.edu.cstad.mbapi.dto.CreateAccountRequest;
import kh.edu.cstad.mbapi.mapper.AccountMapper;
import kh.edu.cstad.mbapi.repository.AccountRepository;
import kh.edu.cstad.mbapi.repository.AccountTypeRepository;
import kh.edu.cstad.mbapi.repository.CustomerRepository;
import kh.edu.cstad.mbapi.service.AccountService;
import kh.edu.cstad.mbapi.util.CurrencyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponse createNew(CreateAccountRequest createAccountRequest) {

        Customer customer = customerRepository
                .findByPhoneNumber(createAccountRequest.phoneNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer phone number not found"));

        AccountType accountType = accountTypeRepository
                .findByType(createAccountRequest.accountType())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account type not found"));

        Account account = accountMapper.toAccount(createAccountRequest);
        account.setAccountType(accountType);
        account.setCustomer(customer);

        if (account.getActNo().isBlank()) { // Auto generate
            String actNo;
            do {
                actNo = String.format("%09d", new Random().nextInt(1_000_000_000)); // Max: 999,999,999
            } while (accountRepository.existsByActNo(actNo));
            account.setActNo(actNo);
        } else { // From DTO, check validation actNo
            if (accountRepository.existsByActNo(account.getActNo())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "Account number already exists");
            }
        }

        account.setIsHide(false);
        account.setIsDeleted(false);
        account.setActCurrency(createAccountRequest.actCurrency().name());

        if (account.getCustomer().getCustomerSegment().getSegment().equals("REGULAR")) {
            account.setOverLimit(BigDecimal.valueOf(5000));
        } else if (account.getCustomer().getCustomerSegment().getSegment().equals("SILVER")) {
            account.setOverLimit(BigDecimal.valueOf(50000));
        } else {
            account.setOverLimit(BigDecimal.valueOf(100000));
        }

        // Validate balance
        switch (createAccountRequest.actCurrency()) {
            case CurrencyUtil.DOLLAR -> {
                if (createAccountRequest.balance().compareTo(BigDecimal.TEN) < 0) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance must be greater than 10 dollars");
                }
            }
            case CurrencyUtil.RIEL -> {
                if (createAccountRequest.balance().compareTo(BigDecimal.valueOf(40000)) < 0) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance must be greater than 40000 riels");
                }
            }
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Currency is not available");
        }

        account = accountRepository.save(account);

        return accountMapper.fromAccount(account);
    }

}
