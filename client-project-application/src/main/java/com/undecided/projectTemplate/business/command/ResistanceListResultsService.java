package com.undecided.projectTemplate.business.command;

import com.undecided.projectTemplate.model.electronicCalculation.CalculationMode;
import com.undecided.projectTemplate.model.electronicCalculation.ElectronicCalculation;
import com.undecided.projectTemplate.model.electronicCalculation.ElectronicCalculationRepository;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentType.RESISTOR;

@Service
public class ResistanceListResultsService {

    private final ElectronicCalculationRepository repository;

    private final ResistanceListResultsService resistanceListResultsService;

    private final ComponentCalculationService componentCalculationService;

    public ResistanceListResultsService(ElectronicCalculationRepository repository,
                                        ResistanceListResultsService resistanceListResultsService,
                                        ComponentCalculationService componentCalculationService) {
        this.repository = repository;
        this.resistanceListResultsService = resistanceListResultsService;
        this.componentCalculationService = componentCalculationService;
    }

    public void update(VBox historyCalculation) {

        List<ElectronicCalculation> list = repository.findAll();

        historyCalculation.getChildren().clear();

        list.stream()
                .filter(ec -> ec.getType().equals(RESISTOR) && ec.getMode().equals(CalculationMode
                        .PARALLEL))
                .forEach(ec -> {
                    StringBuilder data = new StringBuilder();
                    String ending = ec.getType().getUnit().getEnding();
                    ec.getComponents().forEach(r -> {
                        data.append(String.format(Locale.ENGLISH, "%.2f", r.getValue()));
                        data.append(ending);
                        data.append(", ");
                    });
                    data.append("turns to ");
                    data.append(String.format(Locale.ENGLISH, "%.2f", ec.getResult().getValue()));
                    data.append(ending);
                    Label l = new Label(data.toString());
                    l.setId(String.valueOf(ec.getId()));

                    Tooltip tp = new Tooltip("Double click to remove this...");
                    Tooltip.install(l, tp);

                    l.setOnMouseClicked(event -> {
                        if (event.getButton().equals(MouseButton.PRIMARY)) {
                            if (event.getClickCount() == 2) {

                                Alert dialogInfo = new Alert(Alert.AlertType.CONFIRMATION);
                                dialogInfo.setTitle("Would you like to remove this registration?");
                                dialogInfo.setHeaderText(((Label) event.getSource()).getText());
                                Optional<ButtonType> pressedButton = dialogInfo.showAndWait();
                                pressedButton.ifPresent(b -> {
                                    if (b.equals(ButtonType.OK)) {
                                        componentCalculationService.delete((Node) event.getSource());
                                        resistanceListResultsService.update(historyCalculation);
                                    }
                                });
                            }
                        }
                    });
                    l.getStyleClass().add("resultLabel");
                    historyCalculation.getChildren().add(l);
                });
    }
}
