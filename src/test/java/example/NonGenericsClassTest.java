package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonGenericsClassTest {

    private NonGenericsClass nonGenericsClass;

    @BeforeEach
    void setUp() {
        nonGenericsClass = new NonGenericsClass();
    }

    @Test
    void genericsMethod_GetFooData() throws RequestException {
        Response<FooData> result = nonGenericsClass.genericsMethod(RequestType.FOO, FooData.class);
        assertInstanceOf(FooData.class, result.getData());
    }

    @Test
    void genericsMethod_GetBarData() throws RequestException {
        Response<BarData> result = nonGenericsClass.genericsMethod(RequestType.BAR, BarData.class);
        assertInstanceOf(BarData.class, result.getData());
    }

    @Test
    void genericsMethod_UnexpectedReturnType() {
        assertThrows(RequestException.class,
                () -> nonGenericsClass.genericsMethod(RequestType.FOO, BarData.class));
    }

    @Test
    void genericsMethod_NullRequestType() {
        assertThrows(NullPointerException.class,
                () -> nonGenericsClass.genericsMethod(null, null));
    }
}