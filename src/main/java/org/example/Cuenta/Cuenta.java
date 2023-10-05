package org.example.Cuenta;

public class Cuenta {
    private int saldo;

    public Cuenta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(int cantidad) {
        System.out.println("Deposito de " + cantidad + " euros. Saldo actual: " + saldo + " euros.");
        saldo += cantidad;
    }

    public synchronized void retirar(int cantidad) {
        System.out.println("Retiro de " + cantidad + " euros. Saldo actual: " + saldo + " euros.");
        saldo -= cantidad;
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}


