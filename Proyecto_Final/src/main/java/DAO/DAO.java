package DAO;

import Modelos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class DAO {
    public ObservableList<Envios> selectAllEnvios(Connection myConn) throws SQLException {
         try {
                if (myConn != null) {
                    String query = "SELECT idEnvios,Precio_envio,fecha_pedido, Fecha_entrega,idServicio_fk,idCliente_fk FROM envios;";
                    Statement stmt = myConn.createStatement();
                    ResultSet rst = stmt.executeQuery(query);
                    ObservableList< Envios> list = FXCollections.observableArrayList();
                        while (rst.next()) {
                            list.add(new Envios(rst.getInt(1), rst.getInt(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getInt(6)));
                        }

                        rst.close();
                        stmt.close();
                        return list;
                }
         } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

    public ObservableList<UCliente> selectAllUCliente(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "select concat(nombre,' ',paterno,' ',materno)Nombre,\n" +
                        "edad,\n" +
                        "sexo,\n" +
                        "calle,\n" +
                        "Nombre_colonia,\n" +
                        "Nombre_ciudad\n" +
                        "from usuario inner join cliente \n" +
                        "on id = Usuario_idUsuario inner join direccion \n" +
                        "on  Direccion_idDireccion = id inner join ciudad \n" +
                        "on id = Ciudad_idCiudad inner join colonia \n" +
                        "on id = Colonia_idColonia";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<UCliente> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new UCliente(rst.getString(1), rst.getInt(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<UPersonal> selectAllPersonal(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "select concat(nombre,' ',paterno,' ',materno)Nombre,\n" +
                        "edad,\n" +
                        "sexo,\n" +
                        "Tipo_empleado,\n" +
                        "calle,\n" +
                        "Nombre_colonia,\n" +
                        "Nombre_ciudad,\n" +
                        "idPersonal \n" +
                        "from usuario inner join personal \n" +
                        "on id = Usuario_idUsuario inner join direccion \n" +
                        "on  Direccion_idDireccion = id inner join ciudad \n" +
                        "on id = Ciudad_idCiudad inner join colonia \n" +
                        "on id = Colonia_idColonia";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<UPersonal> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new UPersonal(rst.getString(1), rst.getInt(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getInt(8)));
                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<MProducto> selectAllProducto(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "select id, \n" +
                        "Nombre_producto,\n" +
                        "Precio,\n" +
                        "Modelo,\n" +
                        "Nombre_marca,\n" +
                        "Nombre_categoria\n" +
                        "from productos inner join marcas\n" +
                        "on idMarca_fk = id inner join categorias\n" +
                        "on idCategoria_fk = id;";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<MProducto> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new MProducto(rst.getInt(1), rst.getString(2),rst.getInt(3),rst.getString(4),rst.getString(5),rst.getString(6)));
                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Venta> selectAllVentas(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "SELECT t2.idCliente, concat( t1.Nombre,' ', t1.Paterno,' ', t1.Materno)nombre, \n" +
                        "t3.Fecha_venta,\n" +
                        "t4.Nombre_producto,\n" +
                        "t5.Nombre_categoria,\n" +
                        "t6.Nombre_marca,\n" +
                        "t7.Forma_pago \n" +
                        "FROM usuario as t1 \n" +
                        "inner join cliente as t2\n" +
                        "on id = Usuario_idUsuario inner join ventas as t3\n" +
                        "on t3.idCliente_fk = t2.idCliente inner join productos as t4\n" +
                        "on idProducto_fk = id inner join categorias as t5\n" +
                        "on idCategoria_fk = id inner join marcas as t6\n" +
                        "on idMarca_fk = id inner join pago as t7\n" +
                        "on idPago_fk =idPago ;";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<Venta> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new Venta(rst.getInt(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7)));
                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Colonia> selectAllcolonias(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "select id, Nombre_colonia from colonia";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<Colonia> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new Colonia(rst.getInt(1), rst.getString(2)));
                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Ciudad> selectAllciudad(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "select id, Nombre_ciudad from ciudad";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<Ciudad> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new Ciudad(rst.getInt(1), rst.getString(2)));

                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int insertusuario (Connection myConn,String calle,Integer numero,Integer codpostal, Integer idcol, Integer idCid, String nombre, String paterno, String materno,Integer edad,Integer telefono, String sexo, String correo,String tipoU,String ocupacion){
        Integer ultimoUs = null;
        try {
            if (myConn != null) {
                String query = "INSERT INTO direccion (Calle,numero,codigo_postal,Colonia_idColonia,Ciudad_idCiudad) VALUES (?,?,?,?,?)";
                PreparedStatement stmt = myConn.prepareStatement(query);
                stmt.setString(1,calle);
                stmt.setInt(2,numero);
                stmt.setInt(3,codpostal);
                stmt.setInt(4,idcol);
                stmt.setInt(5,idCid);
                int ret = stmt.executeUpdate();
                String query2 = "select max(idDireccion) from direccion";
                PreparedStatement stmt2 = myConn.prepareStatement(query2);
                ResultSet rst = stmt2.executeQuery();
                Integer ultimoID = null;
                while (rst.next()) {
                   ultimoID = rst.getInt(1);
                }
                String query3 = "INSERT INTO usuario (Nombre,Paterno,Materno,Edad,Telefono,Tienda_idTienda,Direccion_idDireccion,Sexo,Correo) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt3 = myConn.prepareStatement(query3);
                stmt3.setString(1,nombre);
                stmt3.setString(2,paterno);
                stmt3.setString(3,materno);
                stmt3.setInt(4,edad);
                stmt3.setInt(5,telefono);
                stmt3.setInt(6,1);
                stmt3.setInt(7,ultimoID);
                stmt3.setString(8,sexo);
                stmt3.setString(9,correo);
                int ret2 = stmt3.executeUpdate();

                String querymax = "select max(idUsuario) from usuario";
                PreparedStatement stmtmax = myConn.prepareStatement(querymax);
                ResultSet rstmax = stmtmax.executeQuery();

                while (rstmax.next()) {
                    ultimoUs = rstmax.getInt(1);
                }
                int ret3 = 0;
                if (tipoU.equals("Cliente")){
                    String query4 = "insert into cliente(Usuario_idUsuario)values(?);";
                    PreparedStatement stmt4 = myConn.prepareStatement(query4);
                    stmt4.setInt(1,ultimoUs);
                    ret3 = stmt4.executeUpdate();
                    System.out.println("Se registro en cliente");
                    stmt4.close();
                }if (tipoU.equals("Personal")){
                    String query4 = "insert into personal(Tipo_empleado,Usuario_idUsuario,idUnidad_administrativa_fk)values(?,?,?);";
                    PreparedStatement stmt4 = myConn.prepareStatement(query4);
                    stmt4.setString(1,ocupacion);
                    stmt4.setInt(2,ultimoUs);
                    stmt4.setInt(3,1);
                    ret3 = stmt4.executeUpdate();
                    System.out.println("Se registro en Personal");
                    stmt4.close();
                }
                stmt.close();
                stmt2.close();
                stmt3.close();
                rst.close();
                rstmax.close();
                stmtmax.close();
                return ret3;
            }else {
                System.out.println("fallo de coneccion");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public ObservableList<Marca> selectAllmarcas(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "select id, Nombre_marca from marcas";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<Marca> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new Marca(rst.getInt(1), rst.getString(2)));
                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Categoria> selectAllcategorias(Connection myConn) throws SQLException {
        try {
            if (myConn != null) {
                String query = "select id, Nombre_categoria from categorias ";
                Statement stmt = myConn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                ObservableList<Categoria> list = FXCollections.observableArrayList();
                while (rst.next()) {
                    list.add(new Categoria(rst.getInt(1), rst.getString(2)));
                }
                rst.close();
                stmt.close();
                return list;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int insertprod (Connection myConn, double precio,String nombreP,String modelo,Integer idcat, Integer idmarca){
        try {
            if (myConn != null) {
                String query = " insert into producto(Precio,Nombre_producto,Modelo,idCategoria_fk,idMarca_fk)values(?,?,?,?,?);";
                PreparedStatement stmt = myConn.prepareStatement(query);
                stmt.setDouble(1,precio);
                stmt.setString(2,nombreP);
                stmt.setString(3,modelo);
                stmt.setInt(4,idcat);
                stmt.setInt(5,idmarca);
                int ret = stmt.executeUpdate();
                stmt.close();
                return ret;
            }else {
                System.out.println("fallo de coneccion");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteprod(Connection myConn, Integer idp){
        try {
            if (myConn != null) {
                String query = "DELETE FROM producto WHERE id = ?";
                PreparedStatement stmt = myConn.prepareStatement(query);
                stmt.setInt(1,idp);
                int rest = stmt.executeUpdate();
                stmt.close();
                return rest;
            }else {
                System.out.println("fallo de coneccion");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int updateprod(Connection myConn, Integer idp, double precionew){
        try {
            if (myConn != null) {
                String query = "UPDATE productos set Precio = ? where id = ?";
                PreparedStatement stmt = myConn.prepareStatement(query);
                stmt.setDouble(1,precionew);
                stmt.setInt(2,idp);
                int ret =stmt.executeUpdate();
                stmt.close();
                return ret;
            }else {
                System.out.println("fallo de coneccion");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
