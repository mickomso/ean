import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EanTest {

    @DisplayName("Test for parsing the merca code with prefix 84 in EAN code")
    @Test
    public void test_merca_code_84() {
        String value = "8480000078623";
        Ean ean = new Ean();
        String mercaCode = ean.getMercaCode(value);
        assertEquals(mercaCode,"07862");
    }

    @DisplayName("Test for parsing the merca code with prefix 23 in EAN code (13 digits)")
    @Test
    public void test_merca_code_23_shorter() {
        String value = "2369664001999";
        Ean ean = new Ean();
        String mercaCode = ean.getMercaCode(value);
        assertEquals(mercaCode,"69664");
    }

    @DisplayName("Test for parsing the merca code with prefix 23 in EAN code (24 digits)")
    @Test
    public void test_merca_code_23_longer() {
        String value = "230036490033000165000542";
        Ean ean = new Ean();
        String mercaCode = ean.getMercaCode(value);
        assertEquals(mercaCode,"03649");
    }

    @DisplayName("Test for parsing the supplier code for Mercadona")
    @Test
    public void test_supplier_mercadona_84() {
        String value = "8480000078623";
        Ean ean = new Ean();
        String supplierCode = ean.getSupplierCode(value);
        assertEquals(supplierCode,"80000");
    }

    @DisplayName("Test for parsing the pvp product")
    @Test
    public void test_pvp_23_longer() {
        String value = "230036490033000165000542";
        Ean ean = new Ean();
        String price = ean.getPvp(value);
        assertEquals(price,"1.65");
    }

    @DisplayName("Test for parsing the total price")
    @Test
    public void test_total_price_23_longer() {
        String value = "230036490033000165000542";
        Ean ean = new Ean();
        String price = ean.getTotalPrice(value);
        assertEquals(price,"0.54");
    }
}
