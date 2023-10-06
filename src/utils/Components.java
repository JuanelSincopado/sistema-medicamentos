package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import controller.product.ProductController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import layout.HomeLayout;
import model.Product;

public class Components {

  public static VBox tableContainerBody() {
    TableView<Product> table = new TableView<>();

    TableColumn<Product, String> nameColumn = new TableColumn<>("Nombre");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Product, String> soldColumn = new TableColumn<>("Vendido");
    soldColumn.setCellValueFactory(new PropertyValueFactory<>("sold"));

    TableColumn<Product, String> stockColumn = new TableColumn<>("Stock");
    stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

    table.getColumns().add(0, nameColumn);
    table.getColumns().add(1, soldColumn);
    table.getColumns().add(2, stockColumn);

    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

    List<Product> products = ProductController.getProductsTop();

    products.forEach(product -> {
      table.getItems().add(product);
    });

    table.setMaxHeight(99);
    table.setMinWidth(350);

    VBox tableContainer = new VBox();

    Label title = new Label("Productos más vendidos");

    tableContainer.getChildren().addAll(title, table);

    return tableContainer;
  }

  public static Button createIconButtonWithText(String title, String iconFileName) {
    // Cargar la imagen del icono
    Image icon = new Image(Objects.requireNonNull(HomeLayout.class.getResourceAsStream(iconFileName)));

    // Crear un ImageView para mostrar el icono
    ImageView iconView = new ImageView(icon);
    iconView.setFitHeight(22);
    iconView.setFitWidth(22);

    // Crear un Label para el texto
    Label label = new Label(title);
    label.setTextFill(Paint.valueOf(Colors.side_color));
    label.setFont(new Font(16));

    // Crear un contenedor HBox para colocar el icono y el texto horizontalmente
    HBox hbox = new HBox(15); // Espacio entre el icono y el texto
    hbox.setAlignment(Pos.CENTER_LEFT);
    hbox.getChildren().addAll(iconView, label);

    // Crear un botón y establecer el HBox como su contenido gráfico
    Button button = new Button();
    button.setGraphic(hbox);

    button.setStyle("-fx-background-color: transparent; -fx-font-weight: bold; -fx-cursor: hand");
    button.setMaxWidth(Double.MAX_VALUE);
    button.setMaxHeight(20);

    return button;
  }
}
