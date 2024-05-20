package bank.mapper;

import bank.pojo.Account;

import java.util.List;

public interface AccountMapper {
    int insert(Account account);

    int deleteByActno(String actno);

    int update(Account account);

    String selectPasswordByActno(String actno);

    Account selectByActno(String actno);

    List<Account> selectAll();


}
