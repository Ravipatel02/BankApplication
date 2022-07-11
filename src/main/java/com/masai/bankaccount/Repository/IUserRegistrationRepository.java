package com.masai.bankaccount.Repository;

import com.masai.bankaccount.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRegistrationRepository extends JpaRepository<Account,Integer> {
}
