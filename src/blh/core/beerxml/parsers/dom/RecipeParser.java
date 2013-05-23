package blh.core.beerxml.parsers.dom;

import blh.core.beerxml.ParseException;
import blh.core.beerxml.types.Equipment;
import blh.core.beerxml.types.Fermentable;
import blh.core.beerxml.types.Hop;
import blh.core.beerxml.types.MashProfile;
import blh.core.beerxml.types.Misc;
import blh.core.beerxml.types.Recipe;
import blh.core.beerxml.types.Style;
import blh.core.beerxml.types.Water;
import blh.core.beerxml.types.Yeast;
import blh.core.beerxml.types.builders.RecipeBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author thinner
 */
public class RecipeParser extends RecordSetParser<Recipe> {

    private RecipeBuilder builder;
    private RecordSetParser<Style> styleParser;
    private RecordSetParser<Equipment>equipmentParser;
    private RecordSetParser<Hop>hopsParser;
    private RecordSetParser<Fermentable>fermentablesParser;
    private RecordSetParser<Misc>miscsParser;
    private RecordSetParser<Yeast>yeastsParser;
    private RecordSetParser<Water>waterParser;
    private RecordSetParser<MashProfile> mashProfileParser;

    public RecipeParser(RecipeBuilder builder, RecordSetParser<Style> styleParser, RecordSetParser<Equipment> equipmentParser, RecordSetParser<Hop> hopsParser, RecordSetParser<Fermentable> fermentablesParser, RecordSetParser<Misc> miscsParser, RecordSetParser<Yeast> yeastsParser, RecordSetParser<Water> waterParser, RecordSetParser<MashProfile> mashProfileParser) {
        super(builder);
        this.builder = builder;
        this.styleParser = styleParser;
        this.equipmentParser = equipmentParser;
        this.hopsParser = hopsParser;
        this.fermentablesParser = fermentablesParser;
        this.miscsParser = miscsParser;
        this.yeastsParser = yeastsParser;
        this.waterParser = waterParser;
        this.mashProfileParser = mashProfileParser;
    }
    

    @Override
    public Recipe parseRecord(NodeList values) throws ParseException {
        for (int i = 0; i < values.getLength(); i++) {
            Node node = values.item(i);
            
            if(node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            switch (node.getNodeName().toUpperCase()) {
                case "VERSION": break;
                case "STYLE":
                    builder.setStyle(styleParser.parseRecord(node.getChildNodes()));
                    break;
                case "EQUIPMENT":
                    builder.setEquipment(equipmentParser.parseRecord(node.getChildNodes()));
                    break;
                case "HOPS":
                    builder.setHops(hopsParser.parseRecordSet(node.getChildNodes()).getRecords());
                    break;
                case "FERMENTABLES":
                    builder.setFermentables(fermentablesParser.parseRecordSet(node.getChildNodes()).getRecords());
                    break;
                case "MISCS":
                    builder.setMiscs(miscsParser.parseRecordSet(node.getChildNodes()).getRecords());
                    break;
                case "YEASTS":
                    builder.setYeasts(yeastsParser.parseRecordSet(node.getChildNodes()).getRecords());
                    break;
                case "WATERS":
                    builder.setWaters(waterParser.parseRecordSet(node.getChildNodes()).getRecords());
                    break;
                case "MASH":
                    builder.setMashProfile(mashProfileParser.parseRecord(node.getChildNodes()));
                    break;

                default:
                    builder.set(node.getNodeName(), node.getTextContent());
                    break;
            }
        }
        return builder.create();
    }
}
