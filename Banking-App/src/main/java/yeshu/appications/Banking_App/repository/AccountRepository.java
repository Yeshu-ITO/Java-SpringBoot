package yeshu.appications.Banking_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yeshu.appications.Banking_App.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {


}
