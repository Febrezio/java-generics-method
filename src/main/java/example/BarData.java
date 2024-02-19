package example;

public class BarData implements Data<String> {
    private String value;
    @Override
    public String get() {
        return value;
    }

    @Override
    public void set(String value) {
        this.value = value;
    }
}
