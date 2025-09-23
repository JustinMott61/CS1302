module edu.westga.cs1302.project1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires javafx.base;

    opens edu.westga.cs1302.project1.views to javafx.fxml;
    exports edu.westga.cs1302.project1;
}
