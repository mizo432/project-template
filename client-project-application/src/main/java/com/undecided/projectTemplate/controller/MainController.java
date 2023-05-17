package com.undecided.projectTemplate.controller;

import com.undecided.projectTemplate.assembler.ResistanceInputElement;
import com.undecided.projectTemplate.business.command.ResistanceListResultsService;
import com.undecided.projectTemplate.business.command.ResistanceParallelCalculationService;
import com.undecided.projectTemplate.business.exception.MinimumResistancesInputReachedException;
import com.undecided.projectTemplate.util.ReadAndCalculateUtils;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Set;

public class MainController {

    @FXML
    public VBox refBox;

    @FXML
    public Label resultResistance;

    @FXML
    public Button addR;

    @FXML
    public Button removeR;

    @FXML
    public Button saveR;

    @FXML
    public VBox historyCalculation;

    private final ResistanceParallelCalculationService resistanceParallelCalculationService;

    private final ResistanceListResultsService resistanceListResultsService;

    public MainController(ResistanceParallelCalculationService resistanceParallelCalculationService,
        ResistanceListResultsService resistanceListResultsService) {
        this.resistanceParallelCalculationService = resistanceParallelCalculationService;
        this.resistanceListResultsService = resistanceListResultsService;
    }

    @FXML
    public void initialize() {

        Set<Node> rs = refBox.lookupAll(ResistanceInputElement.RESIS_SELECTOR);

        rs.stream()
            .filter(node -> node instanceof TextField)
            .forEach(node -> node.setOnKeyReleased(
                event -> ReadAndCalculateUtils.asParallel(refBox, resultResistance)));

        addR.setOnMouseClicked(e -> {

            ResistanceInputElement.create(refBox, resultResistance);

            ReadAndCalculateUtils.asParallel(refBox, resultResistance);
        });

        removeR.setOnMouseClicked(event -> {

            try {
                ResistanceInputElement.remove(refBox);

                ReadAndCalculateUtils.asParallel(refBox, resultResistance);

            } catch (MinimumResistancesInputReachedException e) {
                Alert dialogInfo = new Alert(Alert.AlertType.WARNING);
                dialogInfo.setTitle("Ooops!");
                dialogInfo.setHeaderText(e.getMessage());
                dialogInfo.showAndWait();
            }
        });

        saveR.setOnMouseClicked(event -> {
            resistanceParallelCalculationService.register(refBox, resultResistance);
            resistanceListResultsService.update(historyCalculation);
        });

        resistanceListResultsService.update(historyCalculation);
    }
}
