package hust.soict.globalict.aims.screen.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.screen.App;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController {

    private Cart cart;
    private Store store;
    private Stage stage;

    @FXML
    private MenuItem storeScreen;

    @FXML
    private MenuItem addBook;

    @FXML
    private MenuItem addCD;

    @FXML
    private MenuItem addDVD;
    
    @FXML
    private Label lbTotalCost;
    
    @FXML
    private Button btnOrder;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartScreenController(Store store, Cart cart) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );
        
        lbTotalCost.setText(cart.totalCost() + " $");
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
            lbTotalCost.setText(cart.totalCost() + " $");
        });
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().size() > 0) {
            cart.placeOrder();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order Created!", ButtonType.OK);
            alert.setTitle("Order");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No items in the cart!", ButtonType.OK);
            alert.setTitle("Order");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.NONE, media.playMedia(), ButtonType.OK);
        alert.setTitle("Playing");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void addBookMenu(ActionEvent event) {
        stage.close();
        new App(store, cart);
    }

    @FXML
    void addCDMenu(ActionEvent event) {

    }

    @FXML
    void addDVDMenu(ActionEvent event) {

    }

    @FXML
    void storeScreenMenu(ActionEvent event) {

    }
}
