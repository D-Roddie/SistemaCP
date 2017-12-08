/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import multi.MultiJuez;
import objetos.Juez;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class GestorJuez {

    static MultiJuez juezNuevo = new MultiJuez();

    public  void registrarJuez(String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) throws ClassNotFoundException, SQLException, Exception {

        juezNuevo.crear(nombre, apellido1, apellido2, cedula, telefono, numero_sala, usuario, clave);
    }

    public ArrayList<Juez> listarJuez() throws Exception {
        ArrayList<Juez> listJuezMulti = juezNuevo.listarJuez();

        return listJuezMulti;

    }
}
