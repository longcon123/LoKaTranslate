import com.gtranslate.Language;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.stage.WindowEvent;
import java.util.Map;

public class FXClass extends Application {
    private DictionaryManagements dm = new DictionaryManagements();
    private testApi api = new testApi();
    private String oldW;
    private String lang = "en";
    private boolean add = false;
    private boolean sence2 = false;
    private boolean dich = false;
    private boolean vi = false;
    private boolean en = true;
    List<String> historySearch = new ArrayList<>();
    private Parent scene1() {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(640,541);
        BackgroundImage bgi1 = new BackgroundImage(new Image("intro.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Image speaker = new Image("speaker.png");
        Image swap = new Image("swap1.png");
        BackgroundImage bgi2 = new BackgroundImage(new Image("translate.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg1 = new Background(bgi1);
        //BackgroundFill bgf = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background bg2 = new Background(bgi2);
        root.setBackground(bg1);
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webView.setPrefSize(606, 385);
        webView.setLayoutX(10);
        webView.setLayoutY(140);
        webView.setVisible(false);
        Image logoImg = new Image("lokabirs1.png");
        Image micImg = new Image("mic.png");
        Image mic1Img = new Image("micro1.png");
        Image lookUpImg = new Image("searchrs.png");
        Image pencilImg = new Image("pencil1.png");
        Image backImg = new Image("back1.png");
        Image speakerImg = new Image("speaker.png");
        ImageView pencilIcon = new ImageView(pencilImg);
        Image addImg = new Image("add.png");
        ImageView addIcon = new ImageView(addImg);
        ImageView appIcon = new ImageView();
        appIcon.setImage(logoImg);
        appIcon.setLayoutX(220);
        appIcon.setLayoutY(50);
        ImageView micIcon = new ImageView();
        micIcon.setImage(micImg);
        micIcon.setLayoutX(469);
        micIcon.setLayoutY(218);
        ImageView sIcon = new ImageView();
        sIcon.setImage(lookUpImg);
        sIcon.setLayoutX(270);
        sIcon.setLayoutY(290);
        TextField field = new TextField();
        field.setPromptText("Search....");
        field.setFont(Font.font(15));
        field.setLayoutX(145);
        field.setLayoutY(217);
        field.setPrefWidth(350);
        TextField newWordText = new TextField();
        newWordText.setPromptText("Điền từ vào đây...");
        newWordText.setFont(Font.font(15));
        newWordText.setLayoutX(230);
        newWordText.setLayoutY(103);
        newWordText.setPrefWidth(200);
        newWordText.setVisible(false);
        ImageView speakerIcon = new ImageView(speakerImg);
        Button sw = new Button("Vi-En");
        sw.setLayoutX(175);
        sw.setLayoutY(0);
        sw.setPrefSize(80, 30);
        sw.setStyle("-fx-background-color: transparent;");
        Button buttonTranslate = new Button("Lokabi Dịch");
        buttonTranslate.setLayoutX(300);
        buttonTranslate.setLayoutY(0);
        buttonTranslate.setPrefSize(80, 30);
        buttonTranslate.setStyle("-fx-background-color: transparent;");
        Button buttonSpeaker = new Button("", speakerIcon);
        buttonSpeaker.setLayoutX(400);
        buttonSpeaker.setLayoutY(143);
        buttonSpeaker.setPrefSize(20, 20);
        buttonSpeaker.setStyle("-fx-background-color: transparent;");
        buttonSpeaker.setVisible(false);
        ImageView backIcon = new ImageView(backImg);
        Button buttonBack1 = new Button("Back", backIcon);
        buttonBack1.setFont(Font.font(11));
        buttonBack1.setLayoutX(0);
        buttonBack1.setLayoutY(0);
        buttonBack1.setPrefSize(70, 20);
        buttonBack1.setStyle("-fx-background-color: transparent;");
        buttonBack1.setVisible(false);
        Button buttonHist = new Button("History");
        buttonHist.setFont(Font.font(11));
        buttonHist.setLayoutX(305);
        buttonHist.setLayoutY(290);
        buttonHist.setPrefSize(80, 30);
        Button button = new Button("Search");
        button.setFont(Font.font(11));
        button.setLayoutX(215);
        button.setLayoutY(290);
        button.setPrefSize(80, 30);
        Button buttonFix = new Button("Sửa", pencilIcon);
        buttonFix.setFont(Font.font(9));
        buttonFix.setLayoutX(450);
        buttonFix.setLayoutY(143);
        buttonFix.setPrefSize(70, 30);
        buttonFix.setStyle("-fx-background-color: transparent;");
        buttonFix.setVisible(false);
        Button buttonAdd = new Button("Thêm", addIcon);
        buttonAdd.setFont(Font.font(9));
        buttonAdd.setLayoutX(530);
        buttonAdd.setLayoutY(143);
        buttonAdd.setPrefSize(70, 30);
        buttonAdd.setStyle("-fx-background-color: transparent;");
        buttonAdd.setVisible(false);
        Button buttonOk = new Button("Ok");
        buttonOk.setFont(Font.font(11));
        buttonOk.setLayoutX(258);
        buttonOk.setLayoutY(490);
        buttonOk.setPrefSize(50, 15);
        buttonOk.setVisible(false);
        Button buttonCancel = new Button("Cancel");
        buttonCancel.setFont(Font.font(11));
        buttonCancel.setLayoutX(320);
        buttonCancel.setLayoutY(490);
        buttonCancel.setPrefSize(50, 15);
        buttonCancel.setVisible(false);
        ListView<String> listView = new ListView<>();
        listView.setLayoutX(147);
        listView.setLayoutY(245);
        listView.setPrefSize(300,170);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setVisible(false);
        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefSize(606, 260);
        htmlEditor.setLayoutX(9);
        htmlEditor.setLayoutY(265);
        htmlEditor.setVisible(false);
        root.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getTarget() != listView) {
                    listView.setVisible(false);
                }
                if(event.getTarget() != newWordText && !add && sence2) {
                    newWordText.setVisible(false);
                    field.setVisible(true);
                    buttonHist.setVisible(true);
                    buttonBack1.setVisible(true);
                    micIcon.setVisible(true);
                }
            }
        });

        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listView.getItems().removeAll(listView.getItems());
                if(!(t1.isEmpty())){
                    List<String> lstr = new ArrayList<>(dm.searchWordByChar(t1.toLowerCase()));
                    if(lstr.isEmpty()) {
                        listView.setVisible(false);
                    }
                    else {
                        listView.getItems().addAll(lstr);
                        listView.setVisible(true);
                    }
                }
                else {
                    listView.setVisible(false);
                }
            }
        });

        // TIM KIEM BANG CACH AN CHUOT
        listView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                sw.setVisible(false);
                buttonTranslate.setVisible(false);
                buttonSpeaker.setVisible(true);
                buttonHist.setLayoutX(280);
                buttonHist.setLayoutY(70);
                oldW = listView.getSelectionModel().getSelectedItem();
                String word = dm.getWordEx(oldW);
                appIcon.setVisible(false);
                micIcon.setLayoutY(41);
                field.setLayoutY(40);
                listView.setLayoutY(71);
                webView.setVisible(true);
                webEngine.loadContent(word);
                buttonFix.setVisible(true);
                buttonAdd.setVisible(true);
                listView.setVisible(false);
                buttonFix.setVisible(true);
                buttonBack1.setVisible(true);
                if (!historySearch.contains(field.getText().toLowerCase())) {
                    historySearch.add(0, oldW);
                }
                sence2 = true;
            }
        });

        micIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mo mic");
            }
        });
        micIcon.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                micIcon.setImage(mic1Img);
            }
        });
        micIcon.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                micIcon.setImage(micImg);
            }
        });

        // TIM KIEM BANG CACH AN NUT SEARCH
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sw.setVisible(false);
                buttonTranslate.setVisible(false);
                if (!field.getText().isEmpty()) {
                    buttonBack1.setVisible(true);
                    appIcon.setVisible(false);
                    buttonHist.setLayoutX(280);
                    buttonHist.setLayoutY(70);
                    micIcon.setLayoutY(41);
                    field.setLayoutY(40);
                    listView.setLayoutY(71);
                    webView.setVisible(true);
                    String s = dm.searchWordByEnter(field.getText().toLowerCase());
                    if(s.equals("-1")) {
                        buttonSpeaker.setVisible(false);
                        buttonFix.setVisible(false);
                        s = "<html><i> Chưa có từ này trong từ điển.</i></html>";
                    }
                    else {
                        oldW = field.getText();
                        buttonSpeaker.setVisible(true);
                        buttonFix.setVisible(true);
                        if(!historySearch.contains(field.getText().toLowerCase())) {
                            historySearch.add(0, oldW);
                        }
                    }
                    webEngine.loadContent(s);
                    buttonAdd.setVisible(true);
                    sence2 = true;
                }
            }
        });

        buttonFix.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonSpeaker.setVisible(false);
                micIcon.setVisible(false);
                field.setVisible(false);
                htmlEditor.setVisible(true);
                buttonOk.setVisible(true);
                buttonCancel.setVisible(true);
                buttonFix.setVisible(false);
                buttonAdd.setVisible(false);
                newWordText.setVisible(false);
                buttonBack1.setVisible(false);
                buttonHist.setVisible(false);
                webEngine.loadContent(dm.searchWordByEnter(field.getText().toLowerCase()));
                webView.setPrefSize(600, 125);
            }
        });

        buttonAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonSpeaker.setVisible(false);
                buttonBack1.setVisible(true);
                field.setVisible(false);
                newWordText.setVisible(true);
                webEngine.loadContent("");
                buttonFix.setVisible(false);
                micIcon.setVisible(false);
                buttonHist.setVisible(false);
                micIcon.setVisible(false);
                add = true;
            }
        });

        buttonOk.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                field.setVisible(true);
                buttonBack1.setVisible(true);
                micIcon.setVisible(true);
                buttonHist.setVisible(true);
                if(!htmlEditor.getHtmlText().isEmpty() && !add) {
                    buttonSpeaker.setVisible(true);
                    String st = htmlEditor.getHtmlText();
                    System.out.println(st);
                    if(st.contains("contenteditable=\"true\"")){
                        st=st.replace("contenteditable=\"true\"", "contenteditable=\"false\"");
                    }
                    dm.fixDefi(field.getText().toLowerCase(), st);
                    buttonAdd.setVisible(true);
                    buttonFix.setVisible(true);
                    webEngine.loadContent(dm.getWordEx(field.getText().toLowerCase()));
                    webView.setPrefSize(600, 360);
                }
                else if(!htmlEditor.getHtmlText().isEmpty() && add) {
                    dm.addNewWord(newWordText.getText(), htmlEditor.getHtmlText());
                    webEngine.loadContent("Đã thêm từ mới thành công!");
                    add = false;
                }
                htmlEditor.setVisible(false);
                buttonCancel.setVisible(false);
                buttonOk.setVisible(false);
            }
        });

        buttonCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                    buttonSpeaker.setVisible(true);
                    field.setVisible(true);
                    micIcon.setVisible(true);
                    buttonHist.setVisible(true);
                    htmlEditor.setVisible(false);
                    buttonOk.setVisible(false);
                    buttonCancel.setVisible(false);
                    buttonFix.setVisible(true);
                    buttonAdd.setVisible(true);
                    buttonBack1.setVisible(true);
                    webEngine.loadContent(dm.searchWordByEnter(field.getText().toLowerCase()));
                    webView.setPrefSize(600, 360);
            }
        });

        buttonHist.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!historySearch.isEmpty()) {
                    listView.getItems().removeAll(listView.getItems());
                    listView.getItems().addAll(historySearch);
                    listView.setVisible(true);
                    buttonTranslate.setVisible(false);
                }

            }
        });
        // TIM KIEM BANG CACH AN ENTER
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                sw.setVisible(false);
                buttonTranslate.setVisible(false);
                if(event.getCode() == KeyCode.ENTER) {
                    if (event.getTarget() == field && !field.getText().isEmpty()) {
                        buttonBack1.setVisible(true);
                        appIcon.setVisible(false);
                        buttonHist.setLayoutX(280);
                        buttonHist.setLayoutY(70);
                        micIcon.setLayoutY(41);
                        field.setLayoutY(40);
                        listView.setLayoutY(71);
                        webView.setVisible(true);
                        String s = dm.searchWordByEnter(field.getText().toLowerCase());
                        if(s.equals("-1")) {
                            buttonSpeaker.setVisible(false);
                            buttonFix.setVisible(false);
                            s = "<html><i> Chưa có từ này trong từ điển.</i></html>";
                        }
                        else {
                            buttonSpeaker.setVisible(true);
                            oldW = field.getText();
                            if(!historySearch.contains(field.getText().toLowerCase())) {
                                historySearch.add(0,oldW);
                            }
                            listView.setVisible(false);
                            buttonFix.setVisible(true);
                        }
                        webEngine.loadContent(s);
                        buttonAdd.setVisible(true);
                    }
                    else if (event.getTarget() == newWordText && !newWordText.getText().isEmpty()) {
                        buttonAdd.setVisible(false);
                        if(!dm.wordIsContain(newWordText.getText().toLowerCase())) {
                            buttonBack1.setVisible(false);
                            webEngine.loadContent("Bạn hãy định nghĩa cho từ vừa thêm dưới đây nhé:");
                            htmlEditor.setVisible(true);
                            buttonOk.setVisible(true);
                            buttonCancel.setVisible(true);
                        }
                        else {
                            webEngine.loadContent("Đã có từ này rồi, bạn có thể thay đổi nghĩa hoặc thêm từ khác!");
                            buttonAdd.setVisible(true);
                            htmlEditor.setVisible(false);
                            buttonOk.setVisible(false);
                            buttonCancel.setVisible(false);
                        }
                        newWordText.setVisible(false);
                    }
                }
                sence2 = true;
            }
        });

        buttonBack1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(add) {
                    newWordText.setVisible(false);
                    field.setVisible(true);
                    buttonHist.setVisible(true);
                    button.setVisible(true);
                    micIcon.setVisible(true);
                    if(dm.wordIsContain(oldW) && oldW.equals(field.getText())) {
                        buttonSpeaker.setVisible(true);
                        webEngine.loadContent(dm.getWordEx(oldW));
                    }
                    else {
                        webEngine.loadContent("<html><i> Chưa có từ này trong từ điển.</i></html>");
                    }
                    buttonFix.setVisible(true);
                    add = false;
                }
                else {
                    sw.setVisible(true);
                    buttonTranslate.setVisible(true);
                    buttonSpeaker.setVisible(false);
                    field.setLayoutX(145);
                    field.setLayoutY(217);
                    listView.setLayoutX(147);
                    listView.setLayoutY(245);
                    buttonHist.setLayoutX(305);
                    buttonHist.setLayoutY(290);
                    button.setLayoutX(215);
                    button.setLayoutY(290);
                    sIcon.setLayoutX(270);
                    sIcon.setLayoutY(290);
                    appIcon.setLayoutX(220);
                    appIcon.setLayoutY(50);
                    micIcon.setLayoutX(469);
                    micIcon.setLayoutY(218);
                    appIcon.setVisible(true);
                    webView.setVisible(false);
                    buttonAdd.setVisible(false);
                    buttonFix.setVisible(false);
                    buttonBack1.setVisible(false);
                    sence2 = false;
                }
            }
        });

        buttonSpeaker.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //api.translate("vi", "en", "Con chó");
                System.out.println(oldW);
                try {
                    api.tts(oldW, lang);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        sw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(en) {
                    try {
                        dm.clearData();
                        dm.insertFromFile("D:\\BTL_Dictionary\\src\\main\\resources\\V_E.txt");
                        System.out.println("vi");
                        en = false;
                        vi = true;
                        lang = "vi";
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(vi) {
                    try {
                        dm.clearData();
                        dm.insertFromFile("D:\\BTL_Dictionary\\src\\main\\resources\\E_V.txt");
                        System.out.println("en");
                        vi = false;
                        en = true;
                        lang = "en";
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Button transBt = new Button("Dịch");
        transBt.setLayoutX(565);
        transBt.setLayoutY(265);
        transBt.setStyle("-fx-background-color: transparent; -fx-text-fill: darkslateblue; -fx-font-size: 13pt;");
        transBt.setVisible(false);
        Button speakerBt1 = new Button("",new ImageView(speaker));
        speakerBt1.setLayoutX(25);
        speakerBt1.setLayoutY(71);
        speakerBt1.setStyle("-fx-background-color: transparent;");
        speakerBt1.setVisible(false);
        Button speakerBt2 = new Button("",new ImageView(speaker));
        speakerBt2.setLayoutX(25);
        speakerBt2.setLayoutY(305);
        speakerBt2.setStyle("-fx-background-color: transparent;");
        speakerBt2.setVisible(false);
        Button swapBt = new Button("",new ImageView(swap));
        swapBt.setLayoutX(310);
        swapBt.setLayoutY(42);
        swapBt.setStyle("-fx-background-color: transparent;");
        swapBt.setVisible(false);
        Map<String, String> lang = new HashMap<>();
        lang.put("Tiếng Anh","en");
        lang.put("Tiếng Việt","vi");
        //lang.put("Tiếng Trung","zh-CN");
        lang.put("Tiếng Nga","ru");
        lang.put("Tiếng Pháp","fr");
        lang.put("Tiếng Ý","it");
        lang.put("Tiếng Thái","th");
        lang.put("Tiếng Bồ Đào Nha","pt");
        lang.put("Tiếng Nhật", "ja");
        List<String> listLang = new ArrayList<>();
        listLang.add("Tiếng Anh");
        listLang.add("Tiếng Việt");
        //listLang.add("Tiếng Trung");
        listLang.add("Tiếng Nga");
        listLang.add("Tiếng Pháp");
        listLang.add("Tiếng Ý");
        listLang.add("Tiếng Thái");
        listLang.add("Tiếng Bồ Đào Nha");
        listLang.add("Tiếng Nhật");
        ComboBox combo_box1 = new ComboBox(FXCollections.observableArrayList(listLang));
        combo_box1.setStyle("-fx-background-color: transparent; -fx-text-fill: blue; -fx-font-size: 11pt;");
        combo_box1.setLayoutX(40);
        combo_box1.setLayoutY(45);
        combo_box1.setPrefWidth(150);
        combo_box1.setValue(combo_box1.getItems().get(0));
        combo_box1.setVisible(false);
        ComboBox combo_box2 = new ComboBox(FXCollections.observableArrayList(listLang));
        combo_box2.setStyle("-fx-background-color: transparent; -fx-text-fill: blue; -fx-font-size: 11pt;");
        combo_box2.setLayoutX(450);
        combo_box2.setLayoutY(45);
        combo_box2.setPrefWidth(150);
        combo_box2.setVisible(false);
        combo_box2.setValue(combo_box2.getItems().get(1));
        TextArea textArea = new TextArea();
        textArea.setLayoutX(10);
        textArea.setLayoutY(100);
        textArea.setPrefSize(620, 202);
        textArea.setStyle("-fx-background-color: transparent; -fx-font-size: 20pt;");
        textArea.setVisible(false);
        Text text = new Text();
        text.setLayoutX(22);
        text.setLayoutY(365);
        text.setWrappingWidth(600);
        text.setStyle("-fx-text-fill: white; -fx-font-size: 20pt;");
        text.setVisible(false);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        //text.setText("TEXT");
        /**textArea.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        try {
        System.out.println(api.translate("en", "vi", t1));
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        }
        });*/
        buttonTranslate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!dich) {
                    dich = true;
                    root.setBackground(bg2);
                    combo_box1.setVisible(true);
                    combo_box2.setVisible(true);
                    speakerBt1.setVisible(true);
                    speakerBt2.setVisible(true);
                    swapBt.setVisible(true);
                    textArea.setVisible(true);
                    text.setVisible(true);
                    transBt.setVisible(true);
                    field.setVisible(false);
                    micIcon.setVisible(false);
                    listView.setVisible(false);
                    buttonHist.setVisible(false);
                    sIcon.setVisible(false);
                    button.setVisible(false);
                }
                else {
                    dich = false;
                    root.setBackground(bg1);
                    combo_box1.setVisible(false);
                    combo_box2.setVisible(false);
                    speakerBt1.setVisible(false);
                    speakerBt2.setVisible(false);
                    swapBt.setVisible(false);
                    textArea.setVisible(false);
                    text.setVisible(false);
                    transBt.setVisible(false);
                    field.setVisible(true);
                    micIcon.setVisible(true);
                    //listView.setVisible(true);
                    buttonHist.setVisible(true);
                    sIcon.setVisible(true);
                    button.setVisible(true);
                }

            }
        });

        swapBt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Object temp = combo_box1.getValue();
                combo_box1.setValue(combo_box2.getValue());
                combo_box2.setValue(temp);
            }
        });
        transBt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(combo_box1.getValue().equals(combo_box2.getValue())) {
                    alert.setContentText("Cảnh báo! Bạn hãy chọn dịch ngôn ngữ khác ngôn ngữ của bạn.");
                    alert.show();
                }
                else if(combo_box1.getValue() == null || combo_box2.getValue() == null ) {
                    alert.setContentText("Cảnh báo! Bạn chưa chọn ngôn ngữ dịch.");
                    alert.show();
                }
                else {
                    try {
                        text.setText(api.translate(lang.get(combo_box1.getValue().toString()),lang.get(combo_box2.getValue().toString()), textArea.getText()));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        speakerBt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!textArea.getText().isEmpty()) {
                    try {
                        api.tts(textArea.getText(), lang.get(combo_box1.getValue().toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        speakerBt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!text.getText().isEmpty()) {
                    try {
                        api.tts(text.getText(), lang.get(combo_box2.getValue().toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        root.getChildren().addAll(
                field ,button, buttonHist, sIcon, micIcon,  buttonTranslate
                , webView, buttonSpeaker, listView, htmlEditor
                , buttonFix, buttonAdd, buttonOk, buttonCancel
                , newWordText, buttonBack1, speakerBt1, speakerBt2
                , swapBt, combo_box1, combo_box2, textArea, text, transBt, sw
        );
        return root;
    }
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        dm.insertFromFile("D:\\BTL_Dictionary\\src\\main\\resources\\V_E.txt");
        primaryStage.setScene(new Scene(scene1()));
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                dm.writeFile();
            }
        }
        );
        primaryStage.show();
    }
}
