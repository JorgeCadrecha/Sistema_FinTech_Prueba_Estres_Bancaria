package org.example.Builder;


import org.example.Cuenta.Cuenta;

import java.util.Random;

public class HiloCliente implements Runnable {
    private final Cuenta cuenta;
    private final int depositos100;
    private final int depositos50;
    private final int depositos20;
    private final int retiros100;
    private final int retiros50;
    private final int retiros20;
    private final Random random;

    public HiloCliente(Cuenta cuenta, HiloClienteBuilder builder) {
        this.cuenta = cuenta;
        this.depositos100 = builder.depositos100;
        this.depositos50 = builder.depositos50;
        this.depositos20 = builder.depositos20;
        this.retiros100 = builder.retiros100;
        this.retiros50 = builder.retiros50;
        this.retiros20 = builder.retiros20;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < depositos100; i++) {
            cuenta.depositar(100);
        }

        for (int i = 0; i < depositos50; i++) {
            cuenta.depositar(50);
        }

        for (int i = 0; i < depositos20; i++) {
            cuenta.depositar(20);
        }

        for (int i = 0; i < retiros100; i++) {
            cuenta.retirar(100);
        }

        for (int i = 0; i < retiros50; i++) {
            cuenta.retirar(50);
        }

        for (int i = 0; i < retiros20; i++) {
            cuenta.retirar(20);
        }
    }
}

