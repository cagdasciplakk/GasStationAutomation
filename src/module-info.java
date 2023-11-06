module BenzinIstasyonOtomasyonu {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
