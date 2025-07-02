// Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Алексей Петров");
        BankAccount account2 = new BankAccount("Мария Иванова");
        
        System.out.println("Созданы счета:");
        System.out.println(account1);
        System.out.println(account2);
        
        // Пример операций
        account1.deposit(2000);
        account1.withdraw(500);
        account1.transfer(account2, 300);
        
        System.out.println("\nПосле операций:");
        System.out.println(account1);
        System.out.println(account2);
        
        // Проверка equals
        BankAccount testAccount = new BankAccount("Тест");
        testAccount.number = account1.number;
        System.out.println("\nПроверка equals: " + account1.equals(testAccount));
    }
}