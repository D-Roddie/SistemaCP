/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;


import multi.MultiSecretario;
import objetos.Secretario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class GestorSecretario {

    static MultiSecretario secretarioNuevo = new MultiSecretario();

    public void registrarSecretario(String nombre, String apellido1, String apellido2, String telefono, String usuario, String clave) throws ClassNotFoundException, SQLException, Exception {

        secretarioNuevo.crear(nombre, apellido1, apellido2, telefono, usuario, clave);
    }

    public ArrayList<Secretario> listarSecretario() throws Exception {
        ArrayList<Secretario> listSecretarioMulti = secretarioNuevo.listarSecretario();

        return listSecretarioMulti;

    }

}
