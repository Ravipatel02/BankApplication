package com.masai.bankaccount.Controller;


import com.masai.bankaccount.Entity.Account;
import com.masai.bankaccount.Repository.IUserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountCreationController  {

    @Autowired
    public IUserRegistrationRepository usr;
    @GetMapping("/")
    public static String welcomeString(){
        return "Welcome";
    }

    @PostMapping("/post")
    public Account UserRegistration(@RequestBody Account account){
        return usr.save(account);
    }
    @PutMapping("/debit")
    public Account debit(@RequestParam Integer balance,@RequestParam Integer accountNo){
        Optional<Account> account=usr.findById(accountNo);
        if(account.isPresent()){
            Account a=account.get();
            a.setBalance(a.getBalance()-balance);
            return a;
        }
        else
            throw new RuntimeException("Account Not Found");
    }
    @PutMapping("/credit")
    public String credit(@RequestParam Integer balance){
        return "Balance has been added Successfully";
    }
}
