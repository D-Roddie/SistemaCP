/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi;

import com.acceso.Conector;
import objetos.Secretario;
import com.acceso.AccesoBD;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class MultiSecretario {

    AccesoBD conn;

    public void crear(String nombre, String apellido1, String apellido2, String telefono, String usuario, String clave) {

        String query;
        query = "EXECUTE [dbo].[pa_registrar_secretario]'" + nombre
                + "','" + apellido1 + "','" + apellido2 + "','" + telefono + "','"
                + telefono + "','" + usuario + "','" + clave + "'";
        try {
            conn = new Conector().getConector();

            conn.ejecutarSQL(query);

        } catch (Exception ex) {
            Logger.getLogger(MultiSecretario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Secretario> listarSecretario() throws Exception {
        ArrayList<Secretario> listSecretario = new ArrayList<>();

        String query;
        query = "SELECT * FROM tJuez";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        while (rs.next()) {
            Secretario secretario = new Secretario(
                    rs.getInt("id_juez"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("telefono"),
                    rs.getString("usuario"),
                    rs.getString("clave"));

            listSecretario.add(secretario);
        }
        return listSecretario;

    }
}
