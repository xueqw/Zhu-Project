package bank.pojo;

public class Account {
    private String actno;

    private String password;

    private double balance;


    public Account() {
    }

    public Account(String actno, String password, double balance) {
        this.actno = actno;
        this.password = password;
        this.balance = balance;
    }

    /**
     * 获取
     * @return actno
     */
    public String getActno() {
        return actno;
    }

    /**
     * 设置
     * @param actno
     */
    public void setActno(String actno) {
        this.actno = actno;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Account{actno = " + actno + ", password = " + password + ", balance = " + balance + "}";
    }
}
