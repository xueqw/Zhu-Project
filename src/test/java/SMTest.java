import bank.pojo.Account;
import bank.service.AccountService;
import bank.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class SMTest {
    @Test
    public void testSM() {
//        Manager.login();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的选择 1.创建用户 2.登陆");
        String choice = scanner.nextLine();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        switch (choice) {
            /*插入数据*/
            case "1" -> {
                System.out.println("请输入用户名：");
                String username = scanner.nextLine();
                System.out.println("请输入密码：");
                String password = scanner.nextLine();
                System.out.println("请输入初始存款金额：");
                double money = scanner.nextDouble();
                Account account = new Account(username, password, money);
                accountService.insert(account);
            }
            /*转账*/
            case "2" -> {
                List info = accountService.check_login(scanner);
                if ((boolean) info.get(0)){
                    String username = (String) info.get(1);
                    String password = (String) info.get(2);
                    manage_data(accountService,scanner,username,password);
                }
            }

        }
    }

    public static void manage_data(AccountService accountService, Scanner scanner,String username,String password) {
        System.out.println("请输入你的选择 1.转账 2.删除用户");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                System.out.println("输入收款方");
                String toActno = scanner.nextLine();
                System.out.println("输入转账金额");
                double money = scanner.nextDouble();
                try {
                    accountService.transfer(username, toActno, money);
                    System.out.println("转账成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("转账失败");
                }
            }
            /*删除数据*/
            case "2"-> {
                System.out.println("输入要删除账户");
                String actno = scanner.nextLine();
                accountService.deleteByActno(actno);
            }
        }

    }



}
