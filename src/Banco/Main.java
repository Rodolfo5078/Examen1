/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Banco.CuentaBancaria;
import Banco.CuentaUsuario;

/**
 *
 * @author Prueba
 */
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaUsuario = new CuentaUsuario("1234567890", "1234", 1000);
        CuentaBancaria cuentaDolares = new CuentaDolares("0987654321", "5678", 2000);

        try {
            cuentaUsuario.autenticarUsuario();
            cuentaUsuario.actualizarClave();

            OperacionesFinancieras operacionesUsuario = (OperacionesFinancieras) cuentaUsuario;
            operacionesUsuario.verBalance();
            operacionesUsuario.sacarDinero();
            operacionesUsuario.ingresarDinero();

            cuentaDolares.autenticarUsuario();
            
            if (cuentaDolares instanceof CuentaDolares) {
                CuentaDolares cuentaDolaresEspecifica = (CuentaDolares) cuentaDolares;
                cuentaDolaresEspecifica.comprarDolares(100.0);
                cuentaDolaresEspecifica.venderDolares(50.0);
            }
        } catch (AutenticacionException e) {
            System.out.println("Error de autenticación: " + e.getMessage());
        } catch (RestriccionClaveException e) {
            System.out.println("Error al actualizar la contraseña: " + e.getMessage());
        }
    }
}
