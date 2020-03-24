package main;

import javafx.collections.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import java.util.*;

public class Controller {
    public Button delete_button;
    public Button insert_button;
    public Button begin_button;
    public Button clear_button;
    public ListView choose_list;
    public Button initbutton;
    ObservableList<String> strList = FXCollections.observableArrayList();

    public void insertchoose(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("请输入");
        dialog.setHeaderText("请输入您的选项");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            strList.add(result.get());
        }
    }

    public void deletechoose(ActionEvent actionEvent) {
        ObservableList<String> list1 = choose_list.getSelectionModel().getSelectedItems();
        strList.removeAll(list1);
    }

    public void startchoose(ActionEvent actionEvent) {
        int max=strList.size();
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        choose_list.getSelectionModel().select(s);
    }

    public void clearchoose(ActionEvent actionEvent) {
        strList.clear();
    }

    public void initlistevent(ActionEvent actionEvent) {
        choose_list.setItems(strList);
        choose_list.setCellFactory(TextFieldListCell.forListView());
        choose_list.setEditable(true);
        begin_button.setDisable(false);
        delete_button.setDisable(false);
        insert_button.setDisable(false);
        clear_button.setDisable(false);
    }
}