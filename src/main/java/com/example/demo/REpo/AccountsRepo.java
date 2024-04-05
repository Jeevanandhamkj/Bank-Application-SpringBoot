package com.example.demo.REpo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Accounts;

public interface AccountsRepo extends JpaRepository<Accounts, Long>{

	Accounts save(Double total);

}
