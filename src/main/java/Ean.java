public class Ean {

    private String value;

    private final String prefix84 = "84";
    private final String prefix23 = "23";

    public String getMercaCode(String value) {
        if (value.startsWith(prefix84)) {
            return value.substring(7,12);
        } else if (value.startsWith(prefix23) && value.length() == 24) {
            return value.substring(3,8);
        }
        return value.substring(2,7);
    }

    public String getSupplierCode(String value) {
        return value.substring(2,7);
    }

    public String getPvp(String value) {
        String priceInCents = value.substring(13, 18);
        double priceInEuros = Double.valueOf(priceInCents)/100;
        return String.valueOf(priceInEuros);
    }

    public String getTotalPrice(String value) {
        String priceInCents = value.substring(18, 23);
        double priceInEuros = Double.valueOf(priceInCents)/100;
        return String.valueOf(priceInEuros);
    }
}
