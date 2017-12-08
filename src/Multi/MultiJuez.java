/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multi;

import com.acceso.Conector;
import Objetos.Juez;
import com.acceso.AccesoBD;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiJuez {
    AccesoBD conn;
    public void crear(String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) {

        String query;
        query = "EXECUTE [dbo].[pa_registrar_juez]'" + nombre
                + "','" + apellido1 + "','" + apellido2 + "','" + cedula + "','"
                + telefono + "','" + numero_sala + "','" + usuario + "','"
                + clave + "'";
        try {
            conn = new Conector().getConector();
            
            conn.ejecutarSQL(query);

        } catch (Exception ex) {
            Logger.getLogger(MultiJuez.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Juez> listarJuez() throws Exception {
        ArrayList<Juez> listJuez = new ArrayList<>();

        String query;
        query = "SELECT * FROM tJuez";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            Juez juez = new Juez(
                    rs.getInt("id_juez"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("numero_sala"),
                    rs.getString("usuario"),
                    rs.getString("clave"));

            listJuez.add(juez);
        }
        return listJuez;

    }
}
