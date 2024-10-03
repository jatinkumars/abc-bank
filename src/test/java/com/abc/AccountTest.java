/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;




/**
 *
 * @author Carrington
 */
public class AccountTest {

    public AccountTest() {
    }

    private Account savingsAccount;
    private Account maxiSavingsAccount;
    private Account superSavingsAccount;
    private Account checkingAccount;

    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        savingsAccount = new Account(Account.SAVINGS);
        maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
        superSavingsAccount = new Account(Account.SUPER_SAVINGS);
        checkingAccount = new Account(Account.CHECKING);
    }


    /*@Test
    public void testTransfer(){
        Account a1 = new Account(0);
        Account a2 = new Account(0);
        assertEquals(0,a1.sumTransactions(),0);
        a1.deposit(10000);
      //  a1.Transfer(a2, 5000);
      //  assertEquals(5000,a1.sumTransactions(),0);
      //  assertEquals(5000,a2.sumTransactions(),0);
    }*/


    @Test
    public void testSavingsAccountInterest() {
        savingsAccount.deposit(500);
        assertEquals(0.5, savingsAccount.interestEarned(),DELTA);

        savingsAccount.deposit(600); // Total $1100
        assertEquals(1 + (100) * 0.002, savingsAccount.interestEarned(),DELTA);
    }

    @Test
    public void testMaxiSavingsAccountInterest() {
        maxiSavingsAccount.deposit(500);
        assertEquals(10.0, maxiSavingsAccount.interestEarned(),DELTA);

        maxiSavingsAccount.deposit(600); // 1100
        assertEquals(20 + (100) * 0.05, maxiSavingsAccount.interestEarned(),DELTA); // 20 + 5

        maxiSavingsAccount.deposit(1000); // Total $2100
        assertEquals(70 + (100) * 0.1, maxiSavingsAccount.interestEarned(),DELTA); // 70 + 10
    }

    @Test
    public void testSuperSavingsAccountInterest() {
        superSavingsAccount.deposit(500);
        assertEquals(20.0, superSavingsAccount.interestEarned(),DELTA);

        superSavingsAccount.deposit(600); //  1100
        assertEquals(20 + (100) * 0.05 + 20, superSavingsAccount.interestEarned(),DELTA); // 20 + 5 + 20

        superSavingsAccount.deposit(1000); // 2100
        assertEquals(70 + (100) * 0.1 + 70, superSavingsAccount.interestEarned(),DELTA); // 70 + 10 + 70
    }

    @Test
    public void testCheckingAccountInterest() {
        checkingAccount.deposit(1000);
        assertEquals(1.0, checkingAccount.interestEarned(),DELTA); // 0.1% of 1000

        checkingAccount.deposit(500); // Total $1500
        assertEquals(1.5, checkingAccount.interestEarned(),DELTA); // 0.1% of 1500
    }

    @Test
    public void testDefaultAccountTypeInterest() {
        Account defaultAccount = new Account(999); // Invalid type
        defaultAccount.deposit(1000);
        assertEquals(1.0, defaultAccount.interestEarned(), DELTA); // Fallback to 0.1%
    }
}
