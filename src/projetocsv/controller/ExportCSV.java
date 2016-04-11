/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocsv.controller;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetocsv.framePrincipal;
import projetocsv.controller.Oracle;

/**
 *
 * @author Winston
 */
public class ExportCSV {
        public void gerar(String fileName, Oracle resultSet){

            CSVWriter writer = null;
            try {
                writer = new CSVWriter(new FileWriter("teste.csv"), '\t', ';');
            } catch (IOException ex) {
                Logger.getLogger(framePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Boolean includeHeaders = false;

            java.sql.ResultSet myResultSet = resultSet.executar("select * from testtable");

            try {
                writer.writeAll(myResultSet, includeHeaders);
            } catch (SQLException ex) {
                Logger.getLogger(framePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(framePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(framePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

}
