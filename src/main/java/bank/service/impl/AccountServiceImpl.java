package bank.service.impl;

import bank.mapper.AccountMapper;
import bank.pojo.Account;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int insert(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int update(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public String selectPasswordByActno(String actno) {
        return accountMapper.selectPasswordByActno(actno);
    }


    @Override
    public Account selectByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> selectAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountMapper.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }
        Account toAct = accountMapper.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountMapper.update(fromAct);
        count += accountMapper.update(toAct);
        if (count != 2) {
            throw new RuntimeException("转账失败");
        }
    }

    @Override
    public List<Object> check_login(Scanner scanner) {
        List<Object> list = new ArrayList<>();
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        if (accountMapper.selectByActno(username) != null) {
            System.out.println("请输入密码");
            String password = scanner.nextLine();
            if (accountMapper.selectPasswordByActno(username).equals(password)) {
                list.add(true);
                list.add(username);
                list.add(password);
                System.out.println("登陆成功");
                return list;
            } else {
                list.add(false);
                System.out.println("密码不正确，请重新输入");
                return list;
            }
        } else {
            System.out.println("用户名不存在，请重新输入");
            return list;
        }
    }



}
