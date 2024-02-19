package example;

import java.util.List;

public class FooData implements Data<List<String>> {

    private List<String> value;

    @Override
    public List<String> get() {
        return value;
    }

    @Override
    public void set(List<String> value) {
        this.value = value;
    }
}
