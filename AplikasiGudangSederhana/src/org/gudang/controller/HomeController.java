package org.gudang.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private Label cobaTF;
//    @FXML
//    private TextField nomorResiTF;
//    @FXML
//    private Label statusL;

    //private PengirimanDao pengirimanDao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //pengirimanDao = new PengirimanDaoImplHibernate();
    }

//    @FXML
//    public void btnCariNomorResi(ActionEvent event) 
//    {
//        String nomorResi = nomorResiTF.getText();
//        
////        List<Pengiriman> pengirimans = pengirimanDao.getAllPengiriman();
////        for (Pengiriman p : pengirimans)
////        {
////            if(nomorResi.equals(p.getNomorResi()))
////            {
////                statusL.setText("Status : "+p.getStatus());
////            }
////            else if(!nomorResi.equals(p.getNomorResi()))
////            {
////                statusL.setText("No. Resi tidak ditemukan");
////            }
////        }
//    }
    @FXML
    public void btnTambahMasterBarang(ActionEvent event) throws IOException {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            Stage stage = new Stage();
            Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/TambahMasterBarang.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("apa " + e);
        }
    }
    
    @FXML
    public void btnPenerimaanBarang(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/PenerimaanBarang.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void btnReservasi(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/Reservasi.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btnPengeluaranBarang(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/PengeluaranBarang.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
//    
//    @FXML
//    public void btnMobil(ActionEvent event) throws IOException
//    {
//        ((Node)(event.getSource())).getScene().getWindow().hide();
//        Stage stage = new Stage();
//        Pane myPane = FXMLLoader.load(getClass().getResource("/org/jasapengiriman/view/Mobil.fxml"));
//        Scene scene = new Scene(myPane);
//        stage.setScene(scene);
//        stage.show();
//    }
//    
//    @FXML
//    public void btnKurir(ActionEvent event) throws IOException
//    {
//        ((Node)(event.getSource())).getScene().getWindow().hide();
//        Stage stage = new Stage();
//        Pane myPane = FXMLLoader.load(getClass().getResource("/org/jasapengiriman/view/Kurir.fxml"));
//        Scene scene = new Scene(myPane);
//        stage.setScene(scene);
//        stage.show();
//    }
//    
    @FXML
    public void btnLogout(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/Login.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    
//    
//    @FXML
//    public void btnCompplain(ActionEvent event) throws IOException
//    {
//        ((Node)(event.getSource())).getScene().getWindow().hide();
//        Stage stage = new Stage();
//        Pane myPane = null;
//        myPane = FXMLLoader.load(getClass().getResource("/org/jasapengiriman/view/Complain.fxml"));
//        Scene scene = new Scene(myPane);
//        stage.setScene(scene);
//        stage.show();
//    }

}
