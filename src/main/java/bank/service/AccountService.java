package bank.service;

import bank.pojo.Account;

import java.util.List;
import java.util.Scanner;

public interface AccountService {
    int insert(Account account);

    int deleteByActno(String actno);

    int update(Account account);

    String selectPasswordByActno(String actno);

    Account selectByActno(String actno);

    List<Account> selectAll();

    void transfer(String fromActno, String toActno, double money);

    List check_login(Scanner scanner);
}
