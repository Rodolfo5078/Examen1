/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import java.util.Scanner;
import Banco.CuentaBancaria;

/**
 *
 * @author Prueba
 */
class CuentaUsuario extends CuentaBancaria implements OperacionesFinancieras {
    //Atributos
    private static final int LONGITUD_MINIMA_CLAVE = 8;
    private static final String[] RESTRICCIONES_CLAVE = {"[A-Za-z]", "[0-9]{4}", "([A-Za-z0-9])\\1+"};

    public CuentaUsuario(String numeroCuenta, String clave, double fondosDisponibles) {
        //super(numeroCuenta, clave, fondosDisponibles);
    }
    
    //Metodo autenticar usuario, para autenticar al usuario al intentar ingresar al CA
    @Override
    public void autenticarUsuario() throws AutenticacionException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Cajero Automático");
        System.out.print("Introduce el número de cuenta: ");
        String numeroCuentaInput = scanner.nextLine();
        System.out.print("Introduce el PIN o contraseña: ");
        String claveInput = scanner.nextLine();

        if (numeroCuentaInput.equals(numeroCuenta) && claveInput.equals(clave)) {
            System.out.println("Autenticación exitosa. ¡Bienvenido!");
        } else {
            throw new AutenticacionException("Número de cuenta o PIN/contraseña incorrectos.");
        }
    }

    //Metodo para cambiar la clave
    @Override
    public void actualizarClave() throws RestriccionClaveException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu nueva contraseña: ");
        String nuevaClave = scanner.nextLine();

        if (nuevaClave.length() < LONGITUD_MINIMA_CLAVE) {
            throw new RestriccionClaveException("La contraseña debe tener al menos " + LONGITUD_MINIMA_CLAVE + " caracteres.");
        }

        boolean contieneMayuscula = nuevaClave.matches(".*[A-Z].*");
        boolean contieneMinuscula = nuevaClave.matches(".*[a-z].*");
        boolean contieneNumeros = nuevaClave.matches(".*\\d.*");
        boolean noConsecutivos = nuevaClave.matches("^(?!.*(?<x>[0-9A-Za-z])\\k<x>).*");

        if (!contieneMayuscula || !contieneMinuscula || !contieneNumeros || !noConsecutivos) {
            throw new RestriccionClaveException("La contraseña debe contener al menos una mayúscula, una minúscula, " +
                    "4 números y no puede contener caracteres consecutivos.");
        }

        clave = nuevaClave;
        System.out.println("Contraseña actualizada exitosamente.");
    }

    //Metodo para ver el balance total de la cuenta
    @Override
    public void verBalance() {
        System.out.println("El balance de tu cuenta es: " + balanceTotal);
    }

    //Metodo para sacar dinero de la cuenta, haciendo una validacion de si existen fondos dentro de la misma para poder hacer el retiro y reportando la cantidad extraida
    @Override
    public void sacarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad de dinero que deseas sacar: ");
        double cantidad = scanner.nextDouble();

        if (cantidad > fondosDisponibles) {
            System.out.println("No tienes suficientes fondos en tu cuenta.");
        } else {
            fondosDisponibles -= cantidad;
            balanceTotal -= cantidad;
            System.out.println("Has sacado " + cantidad + " de tu cuenta.");
        }
    }

    //Metodo para depositar dinero a la cuenta sumandole la cantidad depositada al balance existente dentro de la cuenta y reportando la cantidad ingresada
    @Override
    public void ingresarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad de dinero que deseas ingresar: ");
        double cantidad = scanner.nextDouble();

        balanceTotal += cantidad;
        System.out.println("Has ingresado " + cantidad + " a tu cuenta.");
    }
}