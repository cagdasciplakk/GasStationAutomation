package application;


import java.net.URL;
import java.util.ResourceBundle;

import com.isteMySQL.Util.VeriTabaniUtil;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;

public class YoneticiKontrolSayfasiController {
	
	public YoneticiKontrolSayfasiController() {
		baglanti=VeriTabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Kayitlar_Table> Kayitlar_table;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_yenile;

    @FXML
    private Button btn_sil;

    @FXML
    private Label lbl_id;
    
    @FXML
    private TextField txt_yetki;
    
    @FXML
    private TableColumn<Kayitlar_Table, String> column_kuladi;

    @FXML
    private TableColumn<Kayitlar_Table, String> column_sifre;

    @FXML
    private TableColumn<Kayitlar_Table, String> column_yetki;
    @FXML
    private TableColumn<Kayitlar_Table, Integer> column_id;
 
    @FXML
    private TextField txt_kuladi;

    @FXML
    private TextField txt_sifre;
    
    
    public void DegerleriGetir(TableView tablo) {
    	sql="select * from login";
    	ObservableList<Kayitlar_Table> kayitlarliste=FXCollections.observableArrayList();
    	
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarliste.add(new Kayitlar_Table(getirilen.getInt("kID"), getirilen.getString("kul_adi"), getirilen.getString("sifre"), getirilen.getInt("Yetki")));
			}
			column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			column_kuladi.setCellValueFactory(new PropertyValueFactory<>("sutun_kulad"));
			column_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
			column_yetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));
			
			Kayitlar_table.setItems(kayitlarliste);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage().toString());
		}
    	
    }

    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_ekle_click(ActionEvent event) {
    	sql="insert into login(kul_adi, sifre,Yetki) values (?,?,?)";
        try {
        	sorguIfadesi=baglanti.prepareStatement(sql);
        	sorguIfadesi.setString(2, VeriTabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
        	sorguIfadesi.setString(1, txt_kuladi.getText().trim());
        	sorguIfadesi.setString(3, "0");
    		sorguIfadesi.executeUpdate();
    		Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Onay Mesaji");
			alert.setContentText("Kullanýcý Eklendi...");
			alert.showAndWait();
    	} catch (Exception e) {
    		Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Hata Mesaji");
			alert.setContentText("Kullanýcý  Hata Ýle Karþýlaþýldý...");
			alert.showAndWait();
    	
    }
    }
    @FXML
    void btn_yenile_click(ActionEvent event) {
    DegerleriGetir(Kayitlar_table);
    }
    @FXML
    void btn_guncelle_click(ActionEvent event) {
   	 sql="update login set sifre=? where kul_adi=?";
	    try {
	    	sorguIfadesi=baglanti.prepareStatement(sql);
	    	sorguIfadesi.setString(1, VeriTabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
	    	sorguIfadesi.setString(2, txt_kuladi.getText().trim());
			sorguIfadesi.executeUpdate();
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Onay Mesaji");
			alert.setContentText("Kullanýcý Bilgileri Güncellendi...");
			alert.showAndWait();
		} catch (Exception e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Hata Mesaji");
			alert.setContentText("Kullanýcý Bilgileri Güncellenilirken Hata Ýle Karþýlaþýldý...");
			alert.showAndWait();
		}
    }

    @FXML
    void tableview_mouseClick(MouseEvent event) {
    Kayitlar_Table kayit=new Kayitlar_Table();
    kayit=(Kayitlar_Table) Kayitlar_table.getItems().get(Kayitlar_table.getSelectionModel().getSelectedIndex());
    txt_kuladi.setText(kayit.getSutun_kulad());
    txt_sifre.setText(kayit.getSifre());
    lbl_id.setText(String.valueOf(kayit.getId()));
    
    }
    @FXML
    void btn_sil_click(ActionEvent event) {
    	sql="delete from login where kul_adi=? and sifre=?";
        try {
        	sorguIfadesi=baglanti.prepareStatement(sql);
        	sorguIfadesi.setString(2, VeriTabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
        	sorguIfadesi.setString(1, txt_kuladi.getText().trim());
      		sorguIfadesi.executeUpdate();
    		Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Onay Mesaji");
			alert.setContentText("Kullanýcý Silindi...");
			alert.showAndWait();
			
    	} catch (Exception e) {
    		Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Hata Mesaji");
			alert.setContentText("Kullanýcý Silindi...");
			alert.showAndWait();
    	}
    }

    @FXML
    void initialize() {
     DegerleriGetir(Kayitlar_table);
    }

}

