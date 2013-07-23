package org.blh.beerxml.types;

import org.blh.beerxml.Utils;
import org.blh.core.units.Percentage;
import org.blh.core.units.color.Lovibond;
import org.blh.core.units.weight.Kilograms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author thinner
 */
public class Fermentable implements BeerXMLRecord {

    public static final String NAME = "NAME";
    public static final String TYPE = "TYPE";
    public static final String AMOUNT = "AMOUNT";
    public static final String YIELD = "YIELD";
    public static final String COLOR = "COLOR";
    public static final String ADD_AFTER_BOIL = "ADD_AFTER_BOIL";
    public static final String ORIGIN = "ORIGIN";
    public static final String SUPPLIER = "SUPPLIER";
    public static final String NOTES = "NOTES";
    public static final String MAX_IN_BATCH = "MAX_IN_BATCH";
    public final String name;
    public final FERMENTABLE_TYPE type;
    public final Kilograms amount;
    public final Percentage yield;
    /**
     * Is SRM for liquid extracts
     */
    public final Lovibond color;
    public final boolean addAfterBoil;
    public final String origin;
    public final String supplier;
    public final String notes;
    public final Percentage maxInBatch;

    /**
     * Note that according to the BeerXML standard, EXTRACT is liquid extract
     */
    public static enum FERMENTABLE_TYPE {

        GRAIN, SUGAR, EXTRACT, DRY_EXTRACT, ADJUNCT
    }

    public Fermentable(String name, FERMENTABLE_TYPE type, Kilograms amount,
            Percentage yield, Lovibond color, boolean addAfterBoil,
            String origin, String supplier, String notes, Percentage maxInBatch) {

        if (type.equals(FERMENTABLE_TYPE.ADJUNCT) || type.equals(FERMENTABLE_TYPE.GRAIN) || type.equals(FERMENTABLE_TYPE.EXTRACT)) {
            throw new IllegalArgumentException("Please use proper class for extracts, adjuncts and grains");
        }

        this.name = name;
        this.type = type;
        this.amount = amount;
        this.yield = yield;
        this.color = color;
        this.addAfterBoil = addAfterBoil;
        this.origin = origin;
        this.supplier = supplier;
        this.notes = notes;
        this.maxInBatch = maxInBatch;
    }

    protected Fermentable(int a, String name, FERMENTABLE_TYPE type, Kilograms amount,
            Percentage yield, Lovibond color, boolean addAfterBoil,
            String origin, String supplier, String notes, Percentage maxInBatch) {

        this.name = name;
        this.type = type;
        this.amount = amount;
        this.yield = yield;
        this.color = color;
        this.addAfterBoil = addAfterBoil;
        this.origin = origin;
        this.supplier = supplier;
        this.notes = notes;
        this.maxInBatch = maxInBatch;
    }

    @Override
    public Map<String, String> getBeerXMLTagsAndValues() {
        Map<String, String> tagsAndValues = new HashMap<>();

        tagsAndValues.put(NAME, Utils.toStringOrNull(name));
        tagsAndValues.put(TYPE, Utils.toStringOrNull(type));
        tagsAndValues.put(AMOUNT, Utils.toStringOrNull(amount));
        tagsAndValues.put(YIELD, Utils.toStringOrNull(yield));
        tagsAndValues.put(COLOR, Utils.toStringOrNull(color));
        tagsAndValues.put(ADD_AFTER_BOIL, Utils.toStringOrNull(addAfterBoil));
        tagsAndValues.put(ORIGIN, Utils.toStringOrNull(origin));
        tagsAndValues.put(SUPPLIER, Utils.toStringOrNull(supplier));
        tagsAndValues.put(NOTES, Utils.toStringOrNull(notes));
        tagsAndValues.put(MAX_IN_BATCH, Utils.toStringOrNull(maxInBatch));

        return tagsAndValues;
    }

    @Override
    public List<BeerXMLRecord> getSubRecords() {
        return null;
    }

    @Override
    public List<BeerXMLRecordSet> getSubRecordSets() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fermentable other = (Fermentable) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.yield, other.yield)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (this.addAfterBoil != other.addAfterBoil) {
            return false;
        }
        if (!Objects.equals(this.origin, other.origin)) {
            return false;
        }
        if (!Objects.equals(this.supplier, other.supplier)) {
            return false;
        }
        if (!Objects.equals(this.notes, other.notes)) {
            return false;
        }
        if (!Objects.equals(this.maxInBatch, other.maxInBatch)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 97 * hash + Objects.hashCode(this.amount);
        hash = 97 * hash + Objects.hashCode(this.yield);
        hash = 97 * hash + Objects.hashCode(this.color);
        hash = 97 * hash + (this.addAfterBoil ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.origin);
        hash = 97 * hash + Objects.hashCode(this.supplier);
        hash = 97 * hash + Objects.hashCode(this.notes);
        hash = 97 * hash + Objects.hashCode(this.maxInBatch);
        return hash;
    }
}
