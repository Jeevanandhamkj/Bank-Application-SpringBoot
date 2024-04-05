package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.Model.Accounts;
@Component
public class AccountMapper {
	//entity to dto transfer
	public static Accounts kj(AccountDTO accountdto) {
		Accounts ac =new Accounts(
				accountdto.getId(),accountdto.getAccountHolderName()
				,accountdto.getBalance());
				return ac;
		
	}
	
	public static AccountDTO km(Accounts accounts) {
		AccountDTO ak =new AccountDTO( accounts.getId(),accounts.getAccountHolderName()
				,accounts.getBalance());
		return ak;
	}

	
	
	

}
