/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

/**
 *
 * @author Prueba
 */
abstract class CuentaBancaria {
    //Atributos
    protected String numeroCuenta;
    protected String clave;
    protected double fondosDisponibles;
    protected double balanceTotal;
    
    //Constructor lleno
    public CuentaBancaria(String numeroCuenta, String clave, double fondosDisponibles, double balanceTotal) {
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
        this.fondosDisponibles = fondosDisponibles;
        this.balanceTotal = balanceTotal;
    }
    
    //Contructor vacio
    public CuentaBancaria() {
        this.numeroCuenta = "";
        this.clave = "";
        this.fondosDisponibles = 0;
        this.balanceTotal = 0;
    }

    //Metodos get y set
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getFondosDisponibles() {
        return fondosDisponibles;
    }

    public void setFondosDisponibles(double fondosDisponibles) {
        this.fondosDisponibles = fondosDisponibles;
    }

    public double getBalanceTotal() {
        return balanceTotal;
    }

    public void setBalanceTotal(double balanceTotal) {
        this.balanceTotal = balanceTotal;
    }
    
    //Metodos para autenticar usuario y actualizar clave abstractos
    public abstract void autenticarUsuario() throws AutenticacionException;
    
    public abstract void actualizarClave() throws RestriccionClaveException;
    
    public String toString(){
        return "Numero de Cuenta" + numeroCuenta + "Fondos Disponibles" + fondosDisponibles + "Clave" + clave;
    }
}
