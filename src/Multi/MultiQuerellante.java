/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multi;

import com.acceso.Conector;
import Objetos.Querellante;
import com.acceso.AccesoBD;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class MultiQuerellante {

    AccesoBD conn;

    public void registarQuerellante(String nombre, String apellido1, String apellido2, String cedula, String telefono, String direccion) {

        String query;
        query = "EXECUTE [dbo].[pa_registrar_querellante]'" + nombre
                + "','" + apellido1 + "','" + apellido2 + "','" + cedula + "','" + telefono + "','" + direccion + "'";

        try {
            conn = new Conector().getConector();

            conn.ejecutarSQL(query);

        } catch (Exception ex) {
            Logger.getLogger(MultiQuerellante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Querellante> listarQuerellante() throws Exception {
        ArrayList<Querellante> listQuerellante = new ArrayList<>();

        String query;
        query = "SELECT * FROM tQuerellante";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            Querellante querellante = new Querellante(
                    rs.getInt("id_querellante"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("direccion"));

            listQuerellante.add(querellante);
        }
        return listQuerellante;

    }
}
