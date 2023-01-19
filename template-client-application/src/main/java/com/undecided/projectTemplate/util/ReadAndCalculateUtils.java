package com.undecided.projectTemplate.util;

import com.undecided.projectTemplate.assembler.ResistanceInputElement;
import java.util.Locale;
import java.util.Set;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReadAndCalculateUtils {

    public static void asParallel(VBox refBox, Label resultRef) {
        Set<Node> rs = refBox.lookupAll(ResistanceInputElement.RESIS_SELECTOR);
        double result = 0.0;
        for (Node t : rs) {
            String value = ((TextField) t).getText();

            if (value == null || value.isEmpty()) {
                result = 0.0;
                break;
            }

            double r = Double.parseDouble(value);

            if (result == 0) {
                result = r;
                continue;
            }

            result = ResistanceCalculatorUtils.parallel(result, r);
        }
        resultRef.setText(String.format(Locale.ENGLISH, "%.2f", result));
    }
}
