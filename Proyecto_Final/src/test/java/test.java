import DAO.DAO;
import Modelos.MProducto;
import conection.myConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class test {
    DAO dao = new DAO();
    Connection conn;
    @Test
    void prueba_insertar_producto() throws SQLException {
        conn = myConnection.connection();
        try {
            int mProducto = dao.insertprod(conn,1300.0,"alexa,","SDED", 2,5);
            assertEqualss(mProducto != 0);
            assertNotEquals(0,mProducto);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            conn.close();
        }

    }

    private void assertEqualss(boolean b) {
        if (b == true){
            System.out.println("se agrego correctamente");
        }else
            System.out.println("no se agrego");
    }
    @Test
    void prueba_eliminar_producto() throws SQLException {
        conn = myConnection.connection();
        int id = 32;
        try {
            int mProducto = dao.deleteprod(conn,id);
            assertEqualsEliminarProd(mProducto != 0);
            assertNotEquals(0,mProducto,"producto no encontrado");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            conn.close();
        }

    }

    private void assertEqualsEliminarProd(boolean b) {
        if (b == true){
            System.out.println("se elimino correctamente");
        }else
            System.out.println("no se logro eliminar");
    }
    @Test
    void prueba_Actualizar_Producro() throws SQLException {
        conn = myConnection.connection();
        int id = 32;
        try {
            int mProducto = dao.updateprod(conn,id,1559.0);
            assertEqualsActualizarProd(mProducto != 0);
            assertNotEquals(0,mProducto,"producto no encontrado");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            conn.close();
        }
    }

    private void assertEqualsActualizarProd(boolean b) {
        if (b == true){
            System.out.println("se actualizo correctamente");
        }else
            System.out.println("no se actualizo");
    }
    @Test
    void prueba_selectAll() throws SQLException {
        ObservableList<MProducto> mproducto = FXCollections.observableArrayList();
        try {
            conn = myConnection.connection();
            mproducto = dao.selectAllProducto(conn);
            assertEquals(mproducto != null);
            for (MProducto e: mproducto) {
                System.out.println(e.getId_pro());
            }

        }catch (Exception e){
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    private void assertEquals(boolean b) {
        if (b == true){
            System.out.println("se leyeron todos los datos");
        }else
            System.out.println("no se lograron leer todos los datos");
    }
}
