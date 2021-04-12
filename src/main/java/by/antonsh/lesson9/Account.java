package by.antonsh.abstractbranch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Account balance class with history
 */

public class Account {
    private List<Operation> accountTransaction = new ArrayList<>(); // History of transaction
    private long balance; // actual balance

    public Account() {
        this.balance = 1000L;
        accountTransaction.add(
                new Operation(OperationType.RECEIPT, 1000L, "Starting value of account balance"));
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public List<Operation> getAccountTransaction() {
        return accountTransaction;
    }

    public long getBalance() {
        return balance;
    }

    /**
     * This method add transaction
     * @param operation of transaction
     */
    public void addOperationWithAccount(Operation operation) {
        if (operation.type == OperationType.PAYMENT || operation.type == OperationType.WITHDRAWING) {
            minusOperationWithAccount(operation);
        } else if (operation.type == OperationType.RECEIPT) {
            accumulateAccount(operation);
        } else {
            System.out.println("Not supported operation.");
        }
    }

    /**
     * Operation with accumulate balance
     * @param operation
     */
    private void accumulateAccount(Operation operation) {
        balance += operation.getChangeAccountBalance();
        accountTransaction.add(operation);
        System.out.println("Transaction completed." + " balance is: " + balance);
    }

    /**
     * Expenditure account
     * @param operation
     */
    private void minusOperationWithAccount(Operation operation) {
        if (operation.changeAccountBalance <= balance) {
            balance -= operation.getChangeAccountBalance();
            accountTransaction.add(operation);
            System.out.println("Transaction completed." + " balance is: " + balance);
        } else {
            System.out.println("Not enough money");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountTransaction=" + accountTransaction +
                ", balance=" + balance +
                '}';
    }

    enum OperationType {
        RECEIPT, WITHDRAWING, PAYMENT
    }

    class Operation {
        private OperationType type;
        private long changeAccountBalance;
        private String description;

        public OperationType getType() {
            return type;
        }

        public void setType(OperationType type) {
            this.type = type;
        }

        public long getChangeAccountBalance() {
            return changeAccountBalance;
        }

        public void setChangeAccountBalance(long changeAccountBalance) {
            this.changeAccountBalance = changeAccountBalance;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Operation() {
        }

        public Operation(OperationType type, long changeAccountBalance, String description) {
            this.type = type;
            this.changeAccountBalance = changeAccountBalance;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "type=" + type +
                    ", changeAccountBalance=" + changeAccountBalance +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Account account = new Account();
        Account.Operation operation1 = account.new Operation(Account.OperationType.WITHDRAWING, 500, "ATM");
        account.addOperationWithAccount(operation1);
        Account.Operation operation2 = account.new Operation(Account.OperationType.RECEIPT, 100, "FROM ACCOUNT");
        account.addOperationWithAccount(operation2);
        Account.Operation operation3 = account.new Operation(Account.OperationType.PAYMENT, 400, "FROM INTERNET OPERATION");
        account.addOperationWithAccount(operation3);
        System.out.println(account);


    }
}