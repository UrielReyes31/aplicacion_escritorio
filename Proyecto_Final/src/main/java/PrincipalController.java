import DAO.DAO;
import Modelos.*;
import conection.myConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
public class PrincipalController {
    /*
    registro
     */
    @FXML
    public TextField txt_apellidoM_R;
    @FXML
    public TextField txt_edad_R;
    @FXML
    public TextField txt_tel_R;
    @FXML
    public TextField txt_sexo_R;
    @FXML
    public TextField txt_correo_R;
    @FXML
    public TextField txt_calle_R;
    @FXML
    public TextField txt_num_R;
    @FXML
    public TextField txt_nombre_R;
    @FXML
    public TextField txt_apellidoP_R;
    @FXML
    public ComboBox comboTipoUsuario;
    @FXML
    public ComboBox comboColonia;
    @FXML
    public ComboBox ComboCiudad;
    @FXML
    public TextField txt_Codigo_postal;
    @FXML
    public TextField txt_ocupacion;

    /*
    eliminarproducto
     */
    @FXML
    public TextField txt_IDproductoEliminar;
    /*
    actualizar producto
     */
    @FXML
    public TextField txt_idProductoActualizar;
    @FXML
    public TextField txt_nuevo_precio;


    private Integer idcolonia;
    private Integer idciudad;
    private Integer idcategoria;
    private Integer idmarca;
    String tipou = null;

    /*
    tabla envios
     */
    @FXML
    public TableView <Envios>enviosTable;
    @FXML
    public TableColumn<Envios, Integer> columna_id_envio;
    @FXML
    public TableColumn<Envios, Double> columna_precio_envio;
    @FXML
    public TableColumn<Envios,String> columna_fechaP_envio;
    @FXML
    public TableColumn<Envios,String> columna_fechaE_envio;
    @FXML
    public TableColumn<Envios,Integer> columna_idSer_envio;
    @FXML
    public TableColumn<Envios,Integer> columna_idClien_envio;
    ////////////////////////////////////////////////////////////////////
    /*
    tabla clientes
     */
    @FXML
    public TableView<UCliente> table_Ucliente;
    @FXML
    public TableColumn<UCliente,String> colum_Nomclien;
    @FXML
    public TableColumn<UCliente,Integer> colum_edadcliet;
    @FXML
    public TableColumn<UCliente,String> colum_sexclien;
    @FXML
    public TableColumn<UCliente,String> colum_calleclien;
    @FXML
    public TableColumn<UCliente,String> colum_colclien;
    @FXML
    public TableColumn<UCliente,String> colum_ciudadclien;
    /*
       tabla usuario personal
        */
    @FXML
    public TableView <UPersonal>table_Uper;
    @FXML
    public TableColumn <UPersonal,String>colum_NomPer;
    @FXML
    public TableColumn <UPersonal,Integer>colum_edadPer;
    @FXML
    public TableColumn <UPersonal,String>colum_sexPer;
    @FXML
    public TableColumn <UPersonal,String>colum_empPer;
    @FXML
    public TableColumn <UPersonal,String>colum_callePer;
    @FXML
    public TableColumn <UPersonal,String>colum_colPer;
    @FXML
    public TableColumn <UPersonal,String>colum_ciudadPer;
    @FXML
    public TableColumn <UPersonal,Integer>colum_idPer;


    /////////////////////////////////

    /*
    tabla productos
     */
    @FXML
    public TableView <MProducto>Tabla_Productos;
    @FXML
    public TableColumn <MProducto,Integer> colum_idProd;
    @FXML
    public TableColumn <MProducto,String>colum_nomProd;
    @FXML
    public TableColumn <MProducto,Double>colum_precioProd;
    @FXML
    public TableColumn <MProducto,String>colum_modeloProd;
    @FXML
    public TableColumn <MProducto,String>colum_marcaProd;
    @FXML
    public TableColumn <MProducto,String>colum_cateProd;
/////////////////////////////////

    /*
    tabla ventas
     */
    @FXML
    public TableView <Venta>tabla_ventas;
    @FXML
    public TableColumn <Venta,Integer> columna_Vidclient;
    @FXML
    public TableColumn <Venta,String> columna_VNombreC;
    @FXML
    public TableColumn <Venta,String> columna_VFV;
    @FXML
    public TableColumn <Venta,String> columna_VNomProd;
    @FXML
    public TableColumn <Venta,String> columna_VNomCat;
    @FXML
    public TableColumn <Venta,String> columna_VNomMarc;
    @FXML
    public TableColumn <Venta,String> columna_VMetodoP;
    //////////////////////////////////////////////////////////////
    /*
    Registrar producto
     */
    @FXML
    public ComboBox combo_marca;
    @FXML
    public ComboBox combo_categoria;
    @FXML
    public TextField txt_nombreProducto;
    @FXML
    public TextField txt_modeloproducto;
    @FXML
    public TextField txt_precioProducto;
    /*
    paneles
     */
    @FXML
    public AnchorPane panel_registro;
    @FXML
    public AnchorPane panel_envios;
    @FXML
    public AnchorPane panel_Datos_cliente;
    @FXML
    public AnchorPane panel_UPersonal;
    @FXML
    public AnchorPane panel_MProductos;
    @FXML
    public AnchorPane panel_ventas;
    @FXML
    public AnchorPane Panel_registrarProducto;
    @FXML
    public AnchorPane panel_welcome;
    @FXML
    public AnchorPane panel_eliminarProducto;
    @FXML
    public AnchorPane panel_actualizarProd;
    private static final String LIMPIAR ="";



    //////////////////////////////////////////////////////
    private Connection connectionn= null;
    private DAO dao = new DAO();
    ObservableList<Envios> envios = FXCollections.observableArrayList();
    ObservableList<UCliente> uclientes = FXCollections.observableArrayList();
    ObservableList<UPersonal> upersonal = FXCollections.observableArrayList();
    ObservableList<MProducto> mproducto = FXCollections.observableArrayList();
    ObservableList<Venta> ventas = FXCollections.observableArrayList();
    ObservableList<Colonia> colonias = FXCollections.observableArrayList();
    ObservableList<Ciudad> ciudades = FXCollections.observableArrayList();
    ObservableList<Marca> marcas = FXCollections.observableArrayList();
    ObservableList<Categoria> categorias = FXCollections.observableArrayList();

    /*
    Funcion que muestra el pnel para registrar un usuario
     */
    @FXML
    public void Registrar_usuario(ActionEvent actionEvent) throws SQLException {
        panel_registro.setVisible(true);
        panel_envios.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(false);
        try {
            connectionn = myConnection.connection();
            colonias = dao.selectAllcolonias(connectionn);//se llena de todas las colonias y si id
            ciudades = dao.selectAllciudad(connectionn);//se llena de todas las ciudades con su id
            iniciarcomboRegistro();


        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
        }
    }
    @FXML
    public void Mostrar_envios(ActionEvent actionEvent) throws SQLException {
        panel_envios.setVisible(true);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(false);
        enviosTable.getItems().clear();
        try {
            connectionn = myConnection.connection();
            envios = dao.selectAllEnvios(connectionn);
            columna_id_envio.setCellValueFactory(new PropertyValueFactory("idEnvio"));
            columna_precio_envio.setCellValueFactory(new PropertyValueFactory("precio"));
            columna_fechaP_envio.setCellValueFactory(new PropertyValueFactory("fecha_envio"));
            columna_fechaE_envio.setCellValueFactory(new PropertyValueFactory("fecha_entrega"));
            columna_idSer_envio.setCellValueFactory(new PropertyValueFactory("idserv"));
            columna_idClien_envio.setCellValueFactory(new PropertyValueFactory("idclien"));
            enviosTable.setItems(envios);
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
            }
    }
    /*
    Funcion que saca los datos de los txt y los almacena en variables locales y las manda al dao para hacer el insert
     */
    @FXML
    public void registrar_usuario(ActionEvent actionEvent) throws SQLException {

        for (Colonia e: colonias) {
            if (comboColonia.getValue() == e.getNombre_colonia()){
                idcolonia = e.getIdcol();
            }
        }
        for (Ciudad e: ciudades) {
            if (ComboCiudad.getValue() == e.getNombre_ciudad()){
                idciudad= e.getIdciuad();
            }
        }
        if (comboTipoUsuario.getValue()=="Cliente"){
            tipou = "Cliente";
            System.out.println(tipou);
        }else if(comboTipoUsuario.getValue()=="Personal"){
            tipou = "Personal";
            System.out.println(tipou);
        }
        try {
            String calle = txt_calle_R.getText();
            Integer numero = Integer.valueOf(txt_num_R.getText());
            Integer codpost = Integer.valueOf(txt_Codigo_postal.getText());
            String Nombre = txt_nombre_R.getText();
            String paterno = txt_apellidoP_R.getText();
            String materno = txt_apellidoM_R.getText();
            Integer edad = Integer.valueOf(txt_edad_R.getText());
            Integer telefono = Integer.valueOf(txt_tel_R.getText());
            String sexo = txt_sexo_R.getText();
            String correo = txt_correo_R.getText();
            String ocupacion = txt_ocupacion.getText();

            connectionn = myConnection.connection();
            if (dao.insertusuario(connectionn,calle,numero,codpost,idcolonia,idciudad,Nombre,paterno,materno,edad,telefono,sexo,correo,tipou,ocupacion)==0){
                JOptionPane.showMessageDialog(null, "No se logro agregar");
            }else {
                JOptionPane.showMessageDialog(null, "Se agrego correctamente");
            }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
            txt_calle_R.setText(LIMPIAR);
            txt_num_R.setText(LIMPIAR);
            txt_Codigo_postal.setText(LIMPIAR);
            txt_nombre_R.setText(LIMPIAR);
            txt_apellidoP_R.setText(LIMPIAR);
            txt_apellidoM_R.setText(LIMPIAR);
            txt_edad_R.setText(LIMPIAR);
            txt_tel_R.setText(LIMPIAR);
            txt_sexo_R.setText(LIMPIAR);
            txt_correo_R.setText(LIMPIAR);
            txt_ocupacion.setText(LIMPIAR);
        }
    }

    /*
    funcion que inicia los combo box
     */
    public void iniciarcomboRegistro(){
        ObservableList  col = FXCollections.observableArrayList();
        for (Colonia e: colonias) {
            col.addAll(e.getNombre_colonia());
        }
        comboColonia.setItems(col);
        ObservableList  cid = FXCollections.observableArrayList();
        for (Ciudad e: ciudades) {
            cid.addAll(e.getNombre_ciudad());
        }
        ComboCiudad.setItems(cid);
        ObservableList usua = FXCollections.observableArrayList (
                "Personal", "Cliente");
        comboTipoUsuario.setItems(usua);
    }
    /*
    Funcion que muestra los usuarios_cliente de la base de datos en una tabla
     */
    @FXML
    public void Mostrar_uclient(ActionEvent actionEvent) throws SQLException {
        panel_envios.setVisible(false);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(true);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(false);
        try {
            connectionn = myConnection.connection();
            uclientes = dao.selectAllUCliente(connectionn);
            colum_Nomclien.setCellValueFactory(new PropertyValueFactory("Nombre"));
            colum_edadcliet.setCellValueFactory(new PropertyValueFactory("edad"));
            colum_sexclien.setCellValueFactory(new PropertyValueFactory("sexo"));
            colum_calleclien.setCellValueFactory(new PropertyValueFactory("calle"));
            colum_colclien.setCellValueFactory(new PropertyValueFactory("Nom_col"));
            colum_ciudadclien.setCellValueFactory(new PropertyValueFactory("Nom_ciu"));
            table_Ucliente.setItems(uclientes);
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
        }

    }
    /*
    Funcion que muestra los usuarios_personal de la base de datos en una tabla
     */
    @FXML
    public void Mostrar_Uper(ActionEvent actionEvent) throws SQLException {
        panel_envios.setVisible(false);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(true);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(false);
        try {
            connectionn = myConnection.connection();
            upersonal = dao.selectAllPersonal(connectionn);
            colum_NomPer.setCellValueFactory(new PropertyValueFactory("Nombre"));
            colum_edadPer.setCellValueFactory(new PropertyValueFactory("edad"));
            colum_sexPer.setCellValueFactory(new PropertyValueFactory("sexo"));
            colum_empPer.setCellValueFactory(new PropertyValueFactory("tipo_emp"));
            colum_callePer.setCellValueFactory(new PropertyValueFactory("calle"));
            colum_colPer.setCellValueFactory(new PropertyValueFactory("colonia"));
            colum_ciudadPer.setCellValueFactory(new PropertyValueFactory("ciudad"));
            colum_idPer.setCellValueFactory(new PropertyValueFactory("idper"));
            table_Uper.setItems(upersonal);
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
        }
    }
    /*
    Funcion que muestra todos los productos de la base de datos en una tabla
     */
    @FXML
    public void Mostrar_productos(ActionEvent actionEvent) throws SQLException {
        panel_envios.setVisible(false);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(true);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(false);
        try {
            connectionn = myConnection.connection();
            mproducto = dao.selectAllProducto(connectionn);
            colum_idProd.setCellValueFactory(new PropertyValueFactory("id_pro"));
            colum_nomProd.setCellValueFactory(new PropertyValueFactory("nombre"));
            colum_precioProd.setCellValueFactory(new PropertyValueFactory("precio"));
            colum_modeloProd.setCellValueFactory(new PropertyValueFactory("modelo"));
            colum_marcaProd.setCellValueFactory(new PropertyValueFactory("marca"));
            colum_cateProd.setCellValueFactory(new PropertyValueFactory("categoria"));
            Tabla_Productos.setItems(mproducto);
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
        }
    }
    /*
    Funcion que muestra ttodas las ventas de la base de datos en una tabla
     */
    @FXML
    public void mostrar_ventas(ActionEvent actionEvent) throws SQLException {
        panel_envios.setVisible(false);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(true);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(false);
        try {
            connectionn = myConnection.connection();
            ventas = dao.selectAllVentas(connectionn);
            columna_Vidclient.setCellValueFactory(new PropertyValueFactory("id_cliente"));
            columna_VNombreC.setCellValueFactory(new PropertyValueFactory("nombre"));
            columna_VFV.setCellValueFactory(new PropertyValueFactory("fecha_venta"));
            columna_VNomProd.setCellValueFactory(new PropertyValueFactory("nom_prod"));
            columna_VNomCat.setCellValueFactory(new PropertyValueFactory("nom_cat"));
            columna_VNomMarc.setCellValueFactory(new PropertyValueFactory("nom_marca"));
            columna_VMetodoP.setCellValueFactory(new PropertyValueFactory("Mpago"));
            tabla_ventas.setItems(ventas);
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
        }
    }
    /*
    esta funcion muestra el apanel para registrar un producto
     */
    @FXML
    public void Registrar_producto(ActionEvent actionEvent) throws SQLException {
        panel_envios.setVisible(false);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(true);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(false);
        try {
            connectionn = myConnection.connection();
            marcas = dao.selectAllmarcas(connectionn);//se llena de todas las marcas y si id
            categorias = dao.selectAllcategorias(connectionn);//se llena de todas las categorias con su id
            iniciarcomboRegistroProducro();


        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
        }
    }

    private void iniciarcomboRegistroProducro() {
        ObservableList  marc = FXCollections.observableArrayList();
        for (Marca e: marcas) {
            marc.addAll(e.getNombre_marca());
        }
        combo_marca.setItems(marc);

        ObservableList  cat = FXCollections.observableArrayList();
        for (Categoria e: categorias) {
            cat.addAll(e.getNombre_categoria());
        }
        combo_categoria.setItems(cat);
    }

    @FXML
    public void Guardar_producto(ActionEvent actionEvent) throws SQLException {
        for (Marca e: marcas) {
            if (combo_marca.getValue() == e.getNombre_marca()){
                idmarca = e.getIDmarca();
            }
        }
        for (Categoria e: categorias) {
            if (combo_categoria.getValue() == e.getNombre_categoria()){
                idcategoria= e.getIDcategoria();
            }
        }
        try {
            double Precio = Double.parseDouble(txt_precioProducto.getText());
            String Nombre_producto = txt_nombreProducto.getText();
            String Modelo = txt_modeloproducto.getText();
            connectionn = myConnection.connection();
            if (dao.insertprod(connectionn,Precio,Nombre_producto,Modelo,idcategoria,idmarca)==0){
                JOptionPane.showMessageDialog(null, "No se logro agregar");
            }else {
                JOptionPane.showMessageDialog(null, "Se agrego correctamente correctamente");
            }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
            txt_precioProducto.setText(LIMPIAR);
            txt_modeloproducto.setText(LIMPIAR);
            txt_nombreProducto.setText(LIMPIAR);
        }
    }
    /*
    Esta funcion muestra el panel eliminar producto
     */
    @FXML
    public void MostEliminar_producto(ActionEvent actionEvent) {
        panel_envios.setVisible(false);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(true);
        panel_actualizarProd.setVisible(false);
    }
    /*
    Esta funcion es para el botonn que esta dentro del panel "panel_eliminarProducto"
    elimina el producto con los datos de los text
     */
    @FXML
    public void Eliminar_idproducto(ActionEvent actionEvent) throws SQLException {
        try {
            Integer idProducto = Integer.valueOf(txt_IDproductoEliminar.getText());
            connectionn = myConnection.connection();
            if (dao.deleteprod(connectionn,idProducto)==0){
                JOptionPane.showMessageDialog(null, "No se logro eliminar");
            }else {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
            txt_IDproductoEliminar.setText(LIMPIAR);
        }
    }
    /*
    esta funcion muestra el panel para actualizar un producto
     */
    @FXML
    public void MosActualizarProducto(ActionEvent actionEvent) {
        panel_envios.setVisible(false);
        panel_registro.setVisible(false);
        panel_Datos_cliente.setVisible(false);
        panel_UPersonal.setVisible(false);
        panel_MProductos.setVisible(false);
        panel_ventas.setVisible(false);
        Panel_registrarProducto.setVisible(false);
        panel_welcome.setVisible(false);
        panel_eliminarProducto.setVisible(false);
        panel_actualizarProd.setVisible(true);
    }
    @FXML
    public void boton_Actualizar(ActionEvent actionEvent) throws SQLException {
        try {
            Integer idProducto = Integer.valueOf(txt_idProductoActualizar.getText());
            Integer precionew = Integer.valueOf(txt_nuevo_precio.getText());
            connectionn = myConnection.connection();
            if (dao.updateprod(connectionn,idProducto,precionew)==0){
                JOptionPane.showMessageDialog(null, "No se logro actializar");
            }else {
                JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
            }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            connectionn.close();
            txt_idProductoActualizar.setText(LIMPIAR);
            txt_nuevo_precio.setText(LIMPIAR);
        }
    }
}
