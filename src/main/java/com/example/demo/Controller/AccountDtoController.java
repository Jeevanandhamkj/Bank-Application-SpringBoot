package com.example.demo.Controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.Service.AccountService;

@RestController
@RequestMapping("/kj/account")
public class AccountDtoController {
	@Autowired
	AccountService accountService;
	
	
	@PostMapping("/add")
	public AccountDTO create(@RequestBody AccountDTO accountDTO) {
		return accountService.createAccount(accountDTO);
	}
	@GetMapping("/{id}")
	public AccountDTO getAccount(@PathVariable long id) throws UserPrincipalNotFoundException {
		return accountService.getById(id);
	}
	
	@PutMapping("/{id}/depo")
    public AccountDTO deposit(@PathVariable long id, @RequestBody Map<String, Object> request) {
		 Integer amountInteger = (Integer) request.get("amount"); // Assuming "amount" is the key in the request body
		    Double amountDouble = amountInteger.doubleValue(); // // Assuming "amount" is the key in the request body
        return accountService.deposit(id, amountDouble);
    }
	
	
	@PutMapping("/{id}/with")
    public AccountDTO withdraw(@PathVariable long id, @RequestBody Map<String, Object> request) {
		 Integer amountInteger = (Integer) request.get("amount"); // Assuming "amount" is the key in the request body
		    Double amountDouble = amountInteger.doubleValue(); // // Assuming "amount" is the key in the request body
        return accountService.withdraw(id, amountDouble);
	}
        
	@GetMapping("/all")
	public List<AccountDTO> getall(){
		return accountService.getAll();
	}
	@DeleteMapping("/del/{id}")
	public void del(@PathVariable long id) {
		accountService.deletacc(id);
	}
	
		
	}


