package org.example.thread;

import org.example.Builder.HiloCliente;
import org.example.Builder.HiloClienteBuilder;
import org.example.Cuenta.Cuenta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lanzador {
    public static void run() {
        Cuenta cuenta = new Cuenta(10000);

        //  ThreadPool de 10 hilos
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Crear hilos de clientes usando el builder
        for (int i = 0; i < 10; i++) {
            HiloCliente hiloCliente = new HiloClienteBuilder(cuenta)
                    .numDepositos100(400)
                    .numDepositos50(200)
                    .numDepositos20(600)
                    .numRetiros100(400)
                    .numRetiros50(200)
                    .numRetiros20(600)
                    .build();
            // Si se cambia algun valor de los depositos o retiros, el saldo final no será correcto

            // Ejecutar la ThreadPool
            executorService.execute(hiloCliente);
        }

        // Apagar la ThreadPool y esperar a que todos los hilos terminen
        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar el saldo final
        int saldoFinal = cuenta.getSaldo();
        if (saldoFinal == 10000) {
            System.out.println("La simulación ha funcionado correctamente. Saldo final: " + saldoFinal + " euros.");
        } else {
            System.out.println("La simulación ha fallado. Saldo final incorrecto: " + saldoFinal + " euros.");
        }
    }
}

