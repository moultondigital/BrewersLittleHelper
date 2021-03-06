package org.blh.core.units.color;

import org.blh.core.unit.color.EBC;
import org.blh.core.unit.color.SRM;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author thinner
 */
public class SRMTest {


        @Test
    public void testDouble() {
        SRM actual = new SRM(1);
        double expected = 1;

        Assert.assertEquals(expected, actual.value(), 0.0001);
    }

    @Test
    public void testEBC() {
        SRM actual = new SRM(new EBC(1));
        SRM expected = new SRM(1/1.97);

        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * At relatively low EBC, the alcohol percentage by weight is about 4/5 of the EBC (e.g., 3.2% SRM is equivalent to 4.0% EBC)
     */
    public void testToEBC() {
        EBC actual = new SRM(1).toEBC();
        EBC expected = new EBC(1.97);

        Assert.assertEquals(expected, actual);
    }
}
