package org.example.bankaccount;

public class BankAccount {

    private static final String ACCOUNT_CLOSED = "Account closed";
    private static final String ACCOUNT_NOT_OPEN = "Account not open";
    private static final String ACCOUNT_ALREADY_OPEN = "Account already open";
    private static final String INSUFFICIENT_BALANCE = "Cannot withdraw more money than is currently in the account";
    private static final String INVALID_TRANSACTION_AMOUNT = "Cannot deposit or withdraw negative amount";

    private int balance;
    private boolean isActive;

    void open() throws BankAccountActionInvalidException {
        if (isActive) throw new BankAccountActionInvalidException(ACCOUNT_ALREADY_OPEN);

        balance = 0;
        isActive = true;
    }

    void close() throws BankAccountActionInvalidException {
        if (!isActive) throw new BankAccountActionInvalidException(ACCOUNT_NOT_OPEN);

        this.balance = 0;
        this.isActive = false;
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        if (!isActive) throw new BankAccountActionInvalidException(ACCOUNT_CLOSED);

        return balance;
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (!isActive) throw new BankAccountActionInvalidException(ACCOUNT_CLOSED);
        if (amount < 0) throw new BankAccountActionInvalidException(INVALID_TRANSACTION_AMOUNT);

        balance += amount;
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (!isActive) throw new BankAccountActionInvalidException(ACCOUNT_CLOSED);
        if (amount < 0) throw new BankAccountActionInvalidException(INVALID_TRANSACTION_AMOUNT);
        if (amount > balance) throw new BankAccountActionInvalidException(INSUFFICIENT_BALANCE);

        balance -= amount;
    }
}
