package se.angstroms.blh.anders.view.recipe.details.data.value;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import se.angstroms.blh.anders.view.util.CustomControl;

/**
 *
 * @author Thinner
 */
public class CalculatedValuePresenter extends HBox {

    @FXML
    private Label value;

    public CalculatedValuePresenter() {
        CustomControl.setup(this);
        this.setMinHeight(25); // TODO: zomg, this is le ugly hack

        value.minHeightProperty().bind(this.minHeightProperty());
    }

	public String getValue() {
		return value.getText();
	}

	public void setValue(String text) {
		value.setText(text);
	}

	public StringProperty valueProperty() {
		return value.textProperty();
	}
}
