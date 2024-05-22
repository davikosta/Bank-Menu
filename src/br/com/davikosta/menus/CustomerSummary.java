package br.com.davikosta.menus;

import br.com.davikosta.bank.BankAccount;

public class CustomerSummary {
    public void showCustomerData(BankAccount object) {
        System.out.printf("""
                ---------------------------------------------------------------------
                Resumo:
                
                Nome completo:         %s
                
                Cliente desde:         %d
                
                Tipo de conta:         %s
                
                Saldo:                 %.2f
                
                Número de
                operações realizadas:  %d
                """,object.getCustomerName(), object.getCustomerSince(), object.getAccountType(), object.getCustomerBalance(), object.getFinishedOperations());
    }
}
