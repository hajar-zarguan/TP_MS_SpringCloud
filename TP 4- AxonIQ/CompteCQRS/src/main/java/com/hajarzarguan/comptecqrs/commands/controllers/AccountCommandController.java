package com.hajarzarguan.comptecqrs.commands.controllers;
import com.hajarzarguan.comptecqrs.commons.command.CreateAccountCommand;
import com.hajarzarguan.comptecqrs.commons.dtos.CreateAccountRequestDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/commands/account")
@AllArgsConstructor @NoArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;
    @PostMapping(path = "/")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO requestDTO){
       CompletableFuture<String> commandResponse = commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                requestDTO.getInitialBalance(),
                requestDTO.getCurrency()));
       return  commandResponse;
    }
}
