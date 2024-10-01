import java.util.HashMap;
import java.util.Map;

public enum Moedas {
    USD, EUR, BRL, GBP, JPY;

    private static final Map<String, Double> TAXA_CONVERSAO = new HashMap<>();

    static {
        TAXA_CONVERSAO.put("USD_BRL", 5.45);
        TAXA_CONVERSAO.put("BRL_USD", 1 / 5.45);
        TAXA_CONVERSAO.put("USD_EUR", 0.90);
        TAXA_CONVERSAO.put("EUR_USD", 1.11);
        TAXA_CONVERSAO.put("USD_GBP", 0.75);
        TAXA_CONVERSAO.put("GBP_USD", 1.33);
        TAXA_CONVERSAO.put("USD_JPY", 143.82);
        TAXA_CONVERSAO.put("JPY_USD", 0.0070);
        TAXA_CONVERSAO.put("BRL_EUR", 0.17);
        TAXA_CONVERSAO.put("EUR_BRL", 6.02);
        TAXA_CONVERSAO.put("BRL_GBP", 0.14);
        TAXA_CONVERSAO.put("GBP_BRL", 7.24);
        TAXA_CONVERSAO.put("BRL_JPY", 26.46);
        TAXA_CONVERSAO.put("JPY_BRL", 0.038);
        TAXA_CONVERSAO.put("EUR_GBP", 0.83);
        TAXA_CONVERSAO.put("GBP_EUR", 1.20);
        TAXA_CONVERSAO.put("EUR_JPY", 159.28);
        TAXA_CONVERSAO.put("JPY_EUR", 0.0063);
        TAXA_CONVERSAO.put("GBP_JPY", 191.51);
        TAXA_CONVERSAO.put("JPY_GBP", 0.0052);
    }

    public static double convert(Moedas from, Moedas to, double amount) {
        if (from == to) {
            return amount;
        }
        String key = from.name() + "_" + to.name();
        Double rate = TAXA_CONVERSAO.get(key);
        if (rate != null) {
            return amount * rate;
        }
        return amount;
    }
}
