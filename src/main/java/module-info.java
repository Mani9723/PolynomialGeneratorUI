module com.example.polynomialgeneratorfx {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.jfoenix;


	opens com.example.polynomialgeneratorfx to javafx.fxml;
	exports com.example.polynomialgeneratorfx;
	exports com.example.polynomialgeneratorfx.Controllers;
	opens com.example.polynomialgeneratorfx.Controllers to javafx.fxml;
}