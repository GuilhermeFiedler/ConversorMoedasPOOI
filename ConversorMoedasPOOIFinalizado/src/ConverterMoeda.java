public class ConverterMoeda {

    public double convert(double amount, Moedas from, Moedas to) {
        return Moedas.convert(from, to, amount);
    }
}
