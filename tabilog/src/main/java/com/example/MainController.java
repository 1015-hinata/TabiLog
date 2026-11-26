package com.example;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MainController {
    private static final List<String> PREFECTURES = List.of(
            "北海道",
            "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県",
            "茨城県", "栃木県", "群馬県", "埼玉県", "千葉県", "東京都", "神奈川県",
            "新潟県", "富山県", "石川県", "福井県", "山梨県", "長野県", "岐阜県",
            "静岡県", "愛知県", "三重県", "滋賀県", "京都府", "大阪府", "兵庫県",
            "奈良県", "和歌山県", "鳥取県", "島根県", "岡山県", "広島県", "山口県",
            "徳島県", "香川県", "愛媛県", "高知県", "福岡県", "佐賀県", "長崎県",
            "熊本県", "大分県", "宮崎県", "鹿児島県", "沖縄県"
    );

    @FXML
    private ComboBox<String> prefectureComboBox;

    @FXML
    private Button searchButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextArea outputArea;

    @FXML
    private void initialize() {
        prefectureComboBox.getItems().addAll(PREFECTURES);
        prefectureComboBox.getSelectionModel().selectFirst();

        searchButton.setOnAction(_ -> {
            String selected = prefectureComboBox.getValue();
            if (selected == null || selected.isBlank()) {
                return;
            }

            String line = formatTourismLabel(selected);
            if (!outputArea.getText().isEmpty()) {
                outputArea.appendText("\n");
            }
            outputArea.appendText(line);
        });

        clearButton.setOnAction(_ -> outputArea.clear());
    }

    private String formatTourismLabel(String prefecture) {
        String regionName = switch (prefecture) {
            case "北海道", "東京都", "京都府", "大阪府" -> prefecture;
            default -> prefecture.endsWith("県") ? prefecture : prefecture + "県";
        };
        return regionName + "の観光スポット";
    }
}