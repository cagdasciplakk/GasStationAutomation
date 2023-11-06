package application;

import java.net.URL;
import com.isteMySQL.Util.VeriTabaniUtil;
import java.sql.*;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class KullaniciSayfasiController {
     
	public KullaniciSayfasiController() {
		baglanti=VeriTabaniUtil.Baglan();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_depoguncelle;

    @FXML
    private Button btn_fiyat_guncelle;
    
    @FXML
    private Button btn_satisYap;

    @FXML
    private Button btn_satisYenile;
    
    @FXML
    private Button btn_tutarhesapla;
    
    
    @FXML
    private TableView<Satislar_Table> table_satisyap;
    
    @FXML
    private ComboBox<String> combo1;


    
    @FXML
    private TableColumn<DepoBilgileri_Table, Double> column_depoLPG;

    @FXML
    private TableColumn<DepoBilgileri_Table, Double> column_depobenzin95;

    @FXML
    private TableColumn<DepoBilgileri_Table, Double> column_depobenzin97;

    @FXML
    private TableColumn<DepoBilgileri_Table, Double> column_depodizel;

    @FXML
    private TableColumn<DepoBilgileri_Table, Double> column_depoeurodizel;
    
    @FXML
    private TableColumn<Fiyatlar_Table, Double> column_fiyatbenzin95;

    @FXML
    private TableColumn<Fiyatlar_Table, Double> column_fiyatbenzin97;

    @FXML
    private TableColumn<Fiyatlar_Table, Double> column_fiyatdizel;

    @FXML
    private TableColumn<Fiyatlar_Table, Double> column_fiyateurodizel;

    @FXML
    private TableColumn<Fiyatlar_Table, Double> column_fiyatlpg;
    
    @FXML
    private TableColumn<Satislar_Table, Double> column_GuncelLTfiyat;

    @FXML
    private TableColumn<Satislar_Table, Double> column_SatisLT;
    
    @FXML
    private TableColumn<Satislar_Table, String> column_satilanAkaryakitTuru;

    @FXML
    private TableColumn<Satislar_Table, Double> column_tutar;
    
    @FXML
    private Tab tab_depobilgileri;

    @FXML
    private Tab tab_fiyatbilgileri;

    @FXML
    private Tab tab_satisyap;
    
    @FXML
    private Button btn_depoyenile;
    
    @FXML
    private Button btn_fiyatyenile;
    
    @FXML
    private TextField txt_depoLPG;

    @FXML
    private TextField txt_depobenzin95;

    @FXML
    private TextField txt_depobenzin97;

    @FXML
    private TextField txt_depodizel;

    @FXML
    private TextField txt_depoeurodizel;

    @FXML
    private TextField txt_fiyatLPG;

    @FXML
    private TextField txt_fiyatbenzin95;

    @FXML
    private TextField txt_fiyatbenzin97;

    @FXML
    private TextField txt_fiyatdizel;

    @FXML
    private TextField txt_fiyateurodizel;
    
    @FXML
    private TextField txt_guncel_ltFiyat;

    @FXML
    private TextField txt_satisLT;
      
    @FXML
    private Label lbl_tutar;

    @FXML
    private TableView<DepoBilgileri_Table> table_depobilgileri;

    @FXML
    private TableView<Fiyatlar_Table> table_fiyatbilgileri;
    
    ToggleGroup grup1=new ToggleGroup();
    
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    public void DegerleriGetir2(TableView tablo) {
    	sql="select * from depobilgiler";
    	ObservableList<DepoBilgileri_Table> kayitlarliste2=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarliste2.add(new DepoBilgileri_Table(getirilen.getDouble("Benzin95"), getirilen.getDouble("Benzin97"), getirilen.getDouble("Dizel"), getirilen.getDouble("Eurodizel"), getirilen.getDouble("LPG")));
			}	
			column_depobenzin95.setCellValueFactory(new PropertyValueFactory<>("Benzin95"));
			column_depobenzin97.setCellValueFactory(new PropertyValueFactory<>("Benzin97"));
			column_depodizel.setCellValueFactory(new PropertyValueFactory<>("Dizel"));
			column_depoeurodizel.setCellValueFactory(new PropertyValueFactory<>("Eurodizel"));
			column_depoLPG.setCellValueFactory(new PropertyValueFactory<>("LPG"));
			
    	   	
			
			table_depobilgileri.setItems(kayitlarliste2);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage().toString());
		}
    	}
    public void DegerleriGetir3(TableView tablo) {
    	sql="select * from fiyatlar";
    	ObservableList<Fiyatlar_Table> kayitlarliste3=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarliste3.add(new Fiyatlar_Table(getirilen.getDouble("Benzin95"), getirilen.getDouble("Benzin97"), getirilen.getDouble("Dizel"), getirilen.getDouble("Eurodizel"), getirilen.getDouble("LPG")));
			}	
			column_fiyatbenzin95.setCellValueFactory(new PropertyValueFactory<>("Benzin95"));
			column_fiyatbenzin97.setCellValueFactory(new PropertyValueFactory<>("Benzin97"));
			column_fiyatdizel.setCellValueFactory(new PropertyValueFactory<>("Dizel"));
			column_fiyateurodizel.setCellValueFactory(new PropertyValueFactory<>("Eurodizel"));
			column_fiyatlpg.setCellValueFactory(new PropertyValueFactory<>("LPG"));
    	   	
			
			table_fiyatbilgileri.setItems(kayitlarliste3);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage().toString());
		}
    	}
    public void DegerleriGetir4(TableView tablo) {
    	sql="select * from satisbilgiler";
    	ObservableList<Satislar_Table> kayitlarliste4=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarliste4.add(new Satislar_Table(getirilen.getString("Akaryakit_Turu"), getirilen.getDouble("Satis_LT"), getirilen.getDouble("Guncel_LTfiyat"), getirilen.getDouble("Tutar")));
			}	
			column_satilanAkaryakitTuru.setCellValueFactory(new PropertyValueFactory<>("Akaryakit_Turu"));
			column_SatisLT.setCellValueFactory(new PropertyValueFactory<>("Satis_LT"));
			column_GuncelLTfiyat.setCellValueFactory(new PropertyValueFactory<>("Guncel_LTfiyat"));
			column_tutar.setCellValueFactory(new PropertyValueFactory<>("Tutar"));
		
    	   	
			
			table_satisyap.setItems(kayitlarliste4);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage().toString());
		}
    	}
      
        
    
    @FXML
    void table_mouseClicked(MouseEvent event) {
  DepoBilgileri_Table kayit2=new DepoBilgileri_Table();
        kayit2=(DepoBilgileri_Table) table_depobilgileri.getItems().get(table_depobilgileri.getSelectionModel().getSelectedIndex());       
        txt_depobenzin95.setText(String.valueOf(kayit2.getBenzin95()));
        txt_depobenzin97.setText(String.valueOf(kayit2.getBenzin97()));
        txt_depodizel.setText(String.valueOf(kayit2.getDizel()));
        txt_depoeurodizel.setText(String.valueOf(kayit2.getEurodizel()));
        txt_depoLPG.setText(String.valueOf(kayit2.getLPG()));
        
    }
    
    
    @FXML
    void tablefiyat_MouseClicked(MouseEvent event) {
    	Fiyatlar_Table kayit2=new Fiyatlar_Table();
    	kayit2=(Fiyatlar_Table) table_fiyatbilgileri.getItems().get(table_fiyatbilgileri.getSelectionModel().getSelectedIndex());
    	txt_fiyatbenzin95.setText(String.valueOf(kayit2.getBenzin95()));
    	txt_fiyatbenzin97.setText(String.valueOf(kayit2.getBenzin97()));
    	txt_fiyatdizel.setText(String.valueOf(kayit2.getDizel()));
    	txt_fiyateurodizel.setText(String.valueOf(kayit2.getEurodizel()));
    	txt_fiyatLPG.setText(String.valueOf(kayit2.getLPG()));
    	

    }
    
    @FXML
    void btn_depoguncelle_click(ActionEvent event) {
    	sql="update depobilgiler set Benzin95=? , Benzin97=? , Dizel=? , Eurodizel=? , LPG=? ";
   	 try {
	    	sorguIfadesi=baglanti.prepareStatement(sql);
	    	sorguIfadesi.setString(1, txt_depobenzin95.getText().trim());
	    	sorguIfadesi.setString(2, txt_depobenzin97.getText().trim());
	    	sorguIfadesi.setString(3, txt_depodizel.getText().trim());
	    	sorguIfadesi.setString(4, txt_depoeurodizel.getText().trim());
	    	sorguIfadesi.setString(5, txt_depoLPG.getText().trim());
	    	
			sorguIfadesi.executeUpdate();
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Onay Mesaji");
			alert.setContentText("Depo Bilgileri Güncellendi...");
			alert.showAndWait();
		} catch (Exception e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Akaryakit otomasyonu");
			alert.setHeaderText("Hata Mesaji");
			alert.setContentText("Depo Bilgileri Güncellenilirken Hata Ýle Karþýlaþýldý...");
			alert.showAndWait();
		}
    }

    @FXML
    void btn_fiyat_guncelle_click(ActionEvent event) {
    	sql="update fiyatlar set Benzin95=? , Benzin97=? , Dizel=? , Eurodizel=? , LPG=? ";
      	 try {
   	    	sorguIfadesi=baglanti.prepareStatement(sql);
   	    	sorguIfadesi.setString(1, txt_fiyatbenzin95.getText().trim());
   	    	sorguIfadesi.setString(2, txt_fiyatbenzin97.getText().trim());
   	    	sorguIfadesi.setString(3, txt_fiyatdizel.getText().trim());
   	    	sorguIfadesi.setString(4, txt_fiyateurodizel.getText().trim());
   	    	sorguIfadesi.setString(5, txt_fiyatLPG.getText().trim());
   	    	
   			sorguIfadesi.executeUpdate();
   			Alert alert=new Alert(AlertType.INFORMATION);
   			alert.setTitle("Akaryakit otomasyonu");
   			alert.setHeaderText("Onay Mesaji");
   			alert.setContentText("Depo Bilgileri Güncellendi...");
   			alert.showAndWait();
   		} catch (Exception e) {
   			Alert alert=new Alert(AlertType.ERROR);
   			alert.setTitle("Akaryakit otomasyonu");
   			alert.setHeaderText("Hata Mesaji");
   			alert.setContentText("Depo Bilgileri Güncellenilirken Hata Ýle Karþýlaþýldý...");
   			alert.showAndWait();
   		}
    }
    

    @FXML
    void btn_satisyap_click(ActionEvent event) {
    	sql="insert into satisbilgiler (Akaryakit_Turu, Satis_LT,Guncel_LTfiyat, Tutar) values (?,?,?,?)";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, combo1.getSelectionModel().getSelectedItem());
    		sorguIfadesi.setString(2, txt_satisLT.getText().trim());
    		sorguIfadesi.setString(3, txt_guncel_ltFiyat.getText().trim());
    		sorguIfadesi.setString(4, lbl_tutar.getText().trim());
    		
    		sorguIfadesi.executeUpdate();
    		Alert alert=new Alert(AlertType.INFORMATION);
   			alert.setTitle("Akaryakit otomasyonu");
   			alert.setHeaderText("Onay Mesaji");
   			alert.setContentText("Satýþ Bilgileri Eklendi...");
   			alert.showAndWait();
			
		} catch (Exception e) {
			Alert alert=new Alert(AlertType.ERROR);
   			alert.setTitle("Akaryakit otomasyonu");
   			alert.setHeaderText("Hata Mesaji");
   			alert.setContentText("Satýþ Bilgileri Eklenirken Hata Ýle Karþýlaþýldý...");
   			alert.showAndWait();
		}
    }

    @FXML
    void satisyap_yenile_click(ActionEvent event) {
    	DegerleriGetir4(table_satisyap);
    }
    

    @FXML
    void btn_depo_yenile_click(ActionEvent event) {
    	DegerleriGetir2(table_depobilgileri);
    }
    
    @FXML
    void btn_fiyat_yenile_click(ActionEvent event) {
    	DegerleriGetir3(table_fiyatbilgileri);
    }
    

    @FXML
    void btn_tutarhesapla_click(ActionEvent event) {
        double sayi1= Double.parseDouble(txt_satisLT.getText());
    	double sayi2=Double.parseDouble(txt_guncel_ltFiyat.getText());
    	double sonuc=sayi1*sayi2;
    	
    	lbl_tutar.setText(Double.toString(sonuc));
             
    }

    @FXML
    void initialize() {
        DegerleriGetir2(table_depobilgileri);
        DegerleriGetir3(table_fiyatbilgileri);
        DegerleriGetir4(table_satisyap);
        
String[] dizi= {"Benzin95", "Benzin97", "Dizel", "Eurodizel", "LPG"};
        
        combo1.getItems().addAll(dizi);
      
    }

}
