package com.hajar.comptecqrses.Query.Repository;

import com.hajar.comptecqrses.Query.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}

