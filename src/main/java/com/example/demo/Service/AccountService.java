package com.example.demo.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.example.demo.DTO.AccountDTO;

public interface AccountService {
	
	//AccountDTO createAccount(AccountDTO accounts);

	AccountDTO createAccount(AccountDTO accountDTO);
	
	AccountDTO getById(long id) throws UserPrincipalNotFoundException;
	
	AccountDTO deposit(long id,Double amount);
	AccountDTO withdraw(long id,Double amount);
	List<AccountDTO>getAll();
	void deletacc(long id);

}
