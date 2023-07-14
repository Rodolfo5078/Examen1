/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Banco.CuentaBancaria;

/**
 *
 * @author Prueba
 */
class CuentaDolares extends CuentaBancaria implements OperacionesFinancieras {
    //Atributos
    private static final double TIPO_CAMBIO_DOLAR = 0.85;

    public CuentaDolares(String numeroCuenta, String clave, double fondosDisponibles) {
        //super(numeroCuenta, clave, fondosDisponibles);
    }

    //Metodo Desarrollado en la clase CuentaUsuario
    @Override
    public void autenticarUsuario() throws AutenticacionException {
        // Implementación específica para cuentas en dólares
    }

    //Metodo Desarrollado en la clase CuentaUsuario
    @Override
    public void actualizarClave() throws RestriccionClaveException {
        // Implementación específica para cuentas en dólares
    }

    //Metodo Desarrollado en la clase CuentaUsuario
    @Override
    public void verBalance() {
        // Implementación específica para cuentas en dólares
    }
    
    //Metodo Desarrollado en la clase CuentaUsuario
    @Override
    public void sacarDinero() {
        // Implementación específica para cuentas en dólares
    }

    //Metodo Desarrollado en la clase CuentaUsuario
    @Override
    public void ingresarDinero() {
        // Implementación específica para cuentas en dólares
    }
    
    //Metodo para la compra de dolares, haciendo una validacion si hay fondos en la cuenta para asi reaizar la comprar
    public void comprarDolares(double cantidad) {
        double costoDolares = cantidad * TIPO_CAMBIO_DOLAR;

        if (costoDolares > fondosDisponibles) {
            System.out.println("No tienes suficientes fondos en tu cuenta para realizar la compra.");
        } else {
            fondosDisponibles -= costoDolares;
            System.out.println("Has comprado " + cantidad + " dólares.");
        }
    }
    
    //Metodo para vender dolares, haciendo una validacion si hay fondos en la cuenta para asi realizar la venta 
    public void venderDolares(double cantidad) {
        double gananciaDolares = cantidad * TIPO_CAMBIO_DOLAR;

        if (cantidad > fondosDisponibles) {
            System.out.println("No tienes suficientes dólares en tu cuenta para realizar la venta.");
        } else {
            fondosDisponibles -= cantidad;
            balanceTotal += gananciaDolares;
            System.out.println("Has vendido " + cantidad + " dólares.");
        }
    }
}