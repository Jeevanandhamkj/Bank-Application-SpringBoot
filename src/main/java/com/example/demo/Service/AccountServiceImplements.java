package com.example.demo.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.Mapper.AccountMapper;
import com.example.demo.Model.Accounts;
import com.example.demo.REpo.AccountsRepo;
@Service
public class AccountServiceImplements implements AccountService {
	@Autowired
	AccountsRepo accountsRepo;
	

	
	
	



	public AccountDTO createAccount(AccountDTO accountDto) {
		//Entity to dto
		Accounts acco =AccountMapper.kj(accountDto);
		Accounts saceAccounts=accountsRepo.save(acco);
		//dto to Entity
		return AccountMapper.km(saceAccounts);
	}









	public AccountDTO getById(long id) throws UserPrincipalNotFoundException  {
		Accounts accounts=accountsRepo.findById(id)
				.orElseThrow(()->new UserPrincipalNotFoundException("user illa"));
		return AccountMapper.km(accounts);
	}

	public AccountDTO deposit(long id, Double amount) {
        Accounts account = accountsRepo.findById(id).orElse(null);
        if (account != null) {
            double total = account.getBalance() + amount;
            account.setBalance(total); // Update the balance
            Accounts savedAccount = accountsRepo.save(account); // Save the updated account
            return AccountMapper.km(savedAccount);
        }
        return null; // Handle if the account is not found
    }
 public  String delete(long id) {
	 accountsRepo.deleteById(id);
	return "Account deletet";
 }









@Override
public AccountDTO withdraw(long id, Double amount) {
	Accounts accounts=accountsRepo.findById(id).orElse(null);
	if(accounts.getBalance()<amount) {
		throw new RuntimeException("insufficient balance");
	}
	double total=accounts.getBalance()-amount;
	accounts.setBalance(total);
	Accounts saAccounts=accountsRepo.save(accounts);
	return AccountMapper.km(saAccounts);
}









@Override
public List<AccountDTO> getAll() {
    List<Accounts> accountsList = accountsRepo.findAll();
    return accountsList.stream()
            .map(AccountMapper::km)
            .collect(Collectors.toList());
}









@Override
public void deletacc(long id) {
	accountsRepo.deleteById(id);
	
}






	//@Override
//	public AccountDTO deposit(long id, Double amount) {
//		Accounts account=accountsRepo.findById(id).orElse(null);
//		double total=account.getBalance()+2500;
//		Accounts accounts=accountsRepo.save(total);
//		return AccountMapper.km(accounts);
//		
		
	}


