module edu.westga.cs1302.task_tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
	requires javafx.base;

    opens edu.westga.cs1302.comic_collection.views to javafx.fxml;
    exports edu.westga.cs1302.comic_collection;
}
