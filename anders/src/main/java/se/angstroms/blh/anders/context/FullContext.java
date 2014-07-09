package se.angstroms.blh.anders.context;

import java.lang.reflect.Field;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import se.angstroms.blh.anders.context.value.annot.ValueAnnot;
import org.blh.core.uncategorized.BeerType;
import org.blh.core.unit.Factor;
import org.blh.core.unit.Percentage;
import org.blh.core.unit.alcohol.ABV;
import org.blh.core.unit.bitterness.IBU;
import org.blh.core.unit.color.ColorPotential;
import org.blh.core.unit.color.MaltColorUnit;
import org.blh.core.unit.distance.Meters;
import org.blh.core.unit.gravity.SpecificGravity;
import org.blh.core.unit.time.Minutes;
import org.blh.core.unit.volume.Liters;
import org.blh.core.unit.weight.Grams;
import org.blh.core.unit.weight.Kilograms;
import org.blh.recipe.uncategorized.IngredientsList;
import org.blh.recipe.uncategorized.InstructionsList;
import se.angstroms.blh.anders.context.value.InputtedOrCalculatedValue;
import se.angstroms.blh.anders.context.value.InputtedValue;
import se.angstroms.blh.anders.context.value.Value;

/**
 *
 * @author thinner
 */
public class FullContext {

    /////////////
    private final IngredientsList ingredientsList = new IngredientsList();
    private final InstructionsList instructionsList = new InstructionsList();
    private final ObjectProperty<BeerType> beerType = new SimpleObjectProperty<>();
    private final StringProperty name = new SimpleStringProperty();
    private final GeneralBreweryInfo brewery = new GeneralBreweryInfo();
    private final Equipment equipment = new Equipment();
    /////////////

    @ValueAnnot(id = Value.Id.PRE_MASH_VOLUME)
    private final InputtedOrCalculatedValue<Liters> preMashVolume = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.PRE_FERMENTATION_VOLUME)
    private final InputtedOrCalculatedValue<Liters> preFermentationVolume = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.BOIL_TIME)
    private final InputtedValue<Minutes> boilTime = new InputtedValue<>();
    private final InputtedOrCalculatedValue<SpecificGravity> preBoilGravity = new InputtedOrCalculatedValue<>();
    private final InputtedOrCalculatedValue<SpecificGravity> boilGravity = new InputtedOrCalculatedValue<>();
    private final InputtedOrCalculatedValue<SpecificGravity> postBoilGravity = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.OG)
    private final InputtedOrCalculatedValue<SpecificGravity> originalGravity = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.FG)
    private final InputtedOrCalculatedValue<SpecificGravity> finalGravity = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.ALCOHOL_CONTENT)
    private final InputtedOrCalculatedValue<ABV> alcoholContent = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.YEAST_ATTENUATION)
    private final InputtedOrCalculatedValue<Percentage> yeastApparentAttenuation = new InputtedOrCalculatedValue<>();
    private final InputtedOrCalculatedValue<MaltColorUnit> maltColorUnit = new InputtedOrCalculatedValue<>();
    private final InputtedOrCalculatedValue<ColorPotential> totalColorPotential = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.EXTRACTION_EFFICIENCY)
    private final InputtedOrCalculatedValue<Factor> extractionEfficiency = new InputtedOrCalculatedValue<>();

    private final InputtedOrCalculatedValue<Kilograms> totalGrainWeight = new InputtedOrCalculatedValue<>();
    private final InputtedOrCalculatedValue<Grams> totalHopWeight = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.BITTERNESS)
    private final InputtedOrCalculatedValue<IBU> bitterness = new InputtedOrCalculatedValue<>();
    ///////////////
    @ValueAnnot(id = Value.Id.ELEVATION)
    private final InputtedValue<Meters> elevation = new InputtedValue<>();
    /**
     * How many percent of the volume is lost when cooling.
     */
    @ValueAnnot(id = Value.Id.COOLING_LOSS)
    private final InputtedValue<Factor> coolingLoss = new InputtedValue<>();

    @ValueAnnot(id = Value.Id.PRE_BOIL_VOLUME)
    private final InputtedOrCalculatedValue<Liters> preBoilVolume = new InputtedOrCalculatedValue<>();

    @ValueAnnot(id = Value.Id.POST_BOIL_VOLUME)
    private final InputtedOrCalculatedValue<Liters> postBoilVolume = new InputtedOrCalculatedValue<>();

    public IngredientsList getIngredientsList() {
        return ingredientsList;
    }

    public InstructionsList getInstructionsList() {
        return instructionsList;
    }

    public ObjectProperty<BeerType> beerTypeProperty() {
        return beerType;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public InputtedOrCalculatedValue<IBU> getBitterness() {
        return bitterness;
    }

    public GeneralBreweryInfo getBrewery() {
        return brewery;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public InputtedOrCalculatedValue<Liters> getPreMashVolume() {
        return preMashVolume;
    }

    public InputtedOrCalculatedValue<Liters> getPreFermentationVolume() {
        return preFermentationVolume;
    }

    public InputtedValue<Minutes> getBoilTime() {
        return boilTime;
    }

    public InputtedOrCalculatedValue<SpecificGravity> getPreBoilGravity() {
        return preBoilGravity;
    }

    public InputtedOrCalculatedValue<SpecificGravity> getBoilGravity() {
        return boilGravity;
    }

    public InputtedOrCalculatedValue<SpecificGravity> getPostBoilGravity() {
        return postBoilGravity;
    }

    public InputtedOrCalculatedValue<SpecificGravity> getOriginalGravity() {
        return originalGravity;
    }

    public InputtedOrCalculatedValue<SpecificGravity> getFinalGravity() {
        return finalGravity;
    }

    public InputtedOrCalculatedValue<ABV> getAlcoholContent() {
        return alcoholContent;
    }

    public InputtedOrCalculatedValue<Percentage> getYeastApparentAttenuation() {
        return yeastApparentAttenuation;
    }

    public InputtedOrCalculatedValue<MaltColorUnit> getMaltColorUnit() {
        return maltColorUnit;
    }

    public InputtedOrCalculatedValue<ColorPotential> getTotalColorPotential() {
        return totalColorPotential;
    }

    public InputtedOrCalculatedValue<Factor> getExtractionEfficiency() {
        return extractionEfficiency;
    }

    public InputtedOrCalculatedValue<Kilograms> getTotalGrainWeight() {
        return totalGrainWeight;
    }

    public InputtedOrCalculatedValue<Grams> getTotalHopWeight() {
        return totalHopWeight;
    }

    public InputtedOrCalculatedValue<Liters> getPreBoilVolume() {
        return preBoilVolume;
    }

    public InputtedOrCalculatedValue<Liters> getPostBoilVolume() {
        return postBoilVolume;
    }

    public InputtedValue<Meters> getElevation() {
        return elevation;
    }

    public InputtedValue<Factor> getCoolingLoss() {
        return coolingLoss;
    }

    public SpecificGravity getBoilGravityAtMinutesLeft(Minutes time) {
        double timePercent = time.value() / boilTime.get().value();
        double totalGravityDifference = postBoilGravity.get().value() - preBoilGravity.get().value();

        return new SpecificGravity(totalGravityDifference * timePercent);
    }

    public Value<?> get(Value.Id type) {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ValueAnnot.class)) {
                ValueAnnot annotation = field.getAnnotation(ValueAnnot.class);
                if (annotation.id() == type) {
                    try {
                        return (Value<?>) field.get(this);
                    } catch (Exception ex) {
                        throw new RuntimeException("Unable to get value for " + field.getName(), ex);
                    }
                }
            }
        }

        throw new IllegalArgumentException("No field annotated with " + type + " found");
    }

}