package com.hajar.comptecqrses.Commands.Aggregates;

import com.hajar.comptecqrses.CommonApi.Commands.CreateAccountCommand;
import com.hajar.comptecqrses.CommonApi.Commands.CreditAccountCommand;
import com.hajar.comptecqrses.CommonApi.Commands.DebitAccountCommand;
import com.hajar.comptecqrses.CommonApi.Enum.AccountStatus;
import com.hajar.comptecqrses.CommonApi.Events.AccountActivatedEvent;
import com.hajar.comptecqrses.CommonApi.Events.AccountDebitedEvent;
import com.hajar.comptecqrses.CommonApi.Events.AccountCreatedEvent;
import com.hajar.comptecqrses.CommonApi.Events.AccountCreditedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String id;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate() {
    }
    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        if (command.getInitialBalance() < 0) {
            throw new RuntimeException("Initial balance cannot be negative");
        }

        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command.getInitialBalance(),
                command.getCurrency()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.id = event.getId();
        this.balance = event.getAccountBalance();
        this.currency = event.getCurrency();
        this.status = AccountStatus.CREATED;

        AggregateLifecycle.apply(new AccountActivatedEvent(
                event.getId(),
                AccountStatus.ACTIVATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent event) {
        this.status = event.getAccountStatus();
    }

    @CommandHandler
    public void handle(CreditAccountCommand command) {
        if (command.getCreditAmount() < 0) {
            throw new RuntimeException("Credit amount cannot be negative");
        }

        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getCreditAmount(),
                command.getCurrency()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent event) {
        this.balance += event.getCreditAmount();
    }   

    @CommandHandler
    public void handle(DebitAccountCommand command) {
        if (command.getDebitAmount() < 0) {
            throw new RuntimeException("Debit amount cannot be negative");
        }

        if (command.getDebitAmount() > this.balance) {
            throw new RuntimeException("Debit amount cannot be greater than balance");
        }

        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getId(),
                command.getDebitAmount(),
                command.getCurrency()
        ));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent event) {
        this.balance -= event.getDebitAmount();
    }
    
}
