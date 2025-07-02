public class Main {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("Алексей Петров");
        BankAccount account2 = new BankAccount("Мария Иванова");
        
        System.out.println("Создан счет: " + account1.getNumber() + 
                         ", владелец: " + account1.getName());
        System.out.println("Создан счет: " + account2.getNumber() + 
                         ", владелец: " + account2.getName());
        
        System.out.println("\nОперации:");
        System.out.print("Пополнение 2000р: ");
        System.out.println(account1.deposit(2000) ? "Успешно" : "Ошибка");
        
        System.out.print("Снятие 500р: ");
        System.out.println(account1.withdraw(500) ? "Успешно" : "Ошибка");
        
        System.out.print("Перевод 300р: ");
        System.out.println(account1.transfer(account2, 300) ? "Успешно" : "Ошибка");
        
        System.out.println("\nИтоговые балансы:");
        System.out.println("Счет " + account1.getNumber() + ": " + 
                         String.format("%.2fр", account1.getBalance()));
        System.out.println("Счет " + account2.getNumber() + ": " + 
                         String.format("%.2fр", account2.getBalance()));
        
        BankAccount testAccount = new BankAccount("Тест");
        testAccount.number = account1.getNumber();
        System.out.println("\nПроверка: счета " + account1.getNumber() + " и " + 
                         testAccount.getNumber() + " - " + 
                         (account1.equals(testAccount) ? "одинаковые" : "разные"));
    }
}
