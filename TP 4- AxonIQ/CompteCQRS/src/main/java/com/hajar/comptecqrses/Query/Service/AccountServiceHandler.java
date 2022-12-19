package com.hajar.comptecqrses.Query.Service;

import com.hajar.comptecqrses.CommonApi.Enum.AccountStatus;
import com.hajar.comptecqrses.CommonApi.Events.AccountActivatedEvent;
import com.hajar.comptecqrses.CommonApi.Events.AccountCreatedEvent;
import com.hajar.comptecqrses.CommonApi.Events.AccountCreditedEvent;
import com.hajar.comptecqrses.CommonApi.Events.AccountDebitedEvent;
import com.hajar.comptecqrses.CommonApi.Query.GetAccountQuery;
import com.hajar.comptecqrses.CommonApi.Query.GetAllAccountsQuery;
import com.hajar.comptecqrses.Query.Entity.Account;
import com.hajar.comptecqrses.Query.Entity.OperationAccount;
import com.hajar.comptecqrses.Query.Entity.OperationType;
import com.hajar.comptecqrses.Query.Repository.AccountRepository;
import com.hajar.comptecqrses.Query.Repository.OperationAccountRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceHandler {
    private AccountRepository accountRepository;
    private OperationAccountRepository operationAccountRepository;

    public AccountServiceHandler(AccountRepository accountRepository, OperationAccountRepository operationAccountRepository) {
        this.accountRepository = accountRepository;
        this.operationAccountRepository = operationAccountRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        System.out.println("****************************");
        System.out.println("AccountCreatedEvent received");
        Account account = new Account();
        account.setId(event.getId());
        account.setBalance(event.getAccountBalance());
        account.setCurrency(event.getCurrency());
        account.setStatus(AccountStatus.CREATED);
        OperationAccount operationAccount = new OperationAccount();
        operationAccount.setDate(new Date());
        operationAccount.setMontant(event.getAccountBalance());
        operationAccount.setType(OperationType.CREDIT);
        operationAccount.setAccount(account);
        operationAccountRepository.save(operationAccount);
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent event) {
        System.out.println("****************************");
        System.out.println("AccountActivatedEvent received");
        Account account = accountRepository.findById(event.getId()).get();
        account.setStatus(event.getAccountStatus());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountCreditedEvent event) {
        System.out.println("****************************");
        System.out.println("AccountCreditedEvent received");
        Account account = accountRepository.findById(event.getId()).get();
        OperationAccount operationAccount = new OperationAccount();
        operationAccount.setMontant(event.getCreditAmount());
        operationAccount.setDate(new Date());
        operationAccount.setType(OperationType.CREDIT);
        operationAccount.setAccount(account);
        operationAccountRepository.save(operationAccount);
        account.setBalance(account.getBalance() + event.getCreditAmount());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountDebitedEvent event) {
        System.out.println("****************************");
        System.out.println("AccountDebitedEvent received");
        Account account = accountRepository.findById(event.getId()).get();
        OperationAccount operationAccount = new OperationAccount();
        operationAccount.setMontant(event.getDebitAmount());
        operationAccount.setDate(new Date());
        operationAccount.setType(OperationType.DEBIT);
        operationAccount.setAccount(account);
        operationAccountRepository.save(operationAccount);
        account.setBalance(account.getBalance() - event.getDebitAmount());
        accountRepository.save(account);
    }

    @QueryHandler
    public List<Account> on(GetAllAccountsQuery query) {
        return accountRepository.findAll();
    }

    @QueryHandler
    public Account on(GetAccountQuery query) {
        return accountRepository.findById(query.getId()).get();
    }
}
