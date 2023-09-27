package org.example.Builder;

import org.example.Cuenta.Cuenta;

public class HiloClienteBuilder {
    private Cuenta cuenta;
    int depositos100;
    int depositos50;
    int depositos20;
    int retiros100;
    int retiros50;
    int retiros20;

    public HiloClienteBuilder(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public HiloClienteBuilder numDepositos100(int num) {
        this.depositos100 = num;
        return this;
    }

    public HiloClienteBuilder numDepositos50(int num) {
        this.depositos50 = num;
        return this;
    }

    public HiloClienteBuilder numDepositos20(int num) {
        this.depositos20 = num;
        return this;
    }

    public HiloClienteBuilder numRetiros100(int num) {
        this.retiros100 = num;
        return this;
    }

    public HiloClienteBuilder numRetiros50(int num) {
        this.retiros50 = num;
        return this;
    }

    public HiloClienteBuilder numRetiros20(int num) {
        this.retiros20 = num;
        return this;
    }

    public HiloCliente build() {
        return new HiloCliente(this.cuenta, this);
    }
}

