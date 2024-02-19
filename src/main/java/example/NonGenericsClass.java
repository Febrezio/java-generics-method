package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NonGenericsClass {

    /**
     * Processes the request.
     * @param requestType The type of request
     * @param clazz The expected response data type.
     * @return Response with the expected data type.
     * @throws RequestException if the request was not processed successfully.
     */
    public <T extends Data<?>> Response<T> genericsMethod(RequestType requestType, Class<T> clazz)
            throws RequestException {

        Objects.requireNonNull(requestType);
        Objects.requireNonNull(clazz);

        Response<T> response = new Response<>();
        T data;

        try {
            if (RequestType.FOO == requestType) {
                data = clazz.cast(getFooData());
            } else if (RequestType.BAR == requestType) {
                data = clazz.cast(getBarData());
            } else {
                throw new RequestException("Request type not supported: " + requestType);
            }

            response.setData(data);
        } catch (ClassCastException e) {
            throw new RequestException("Data retrieved was not expected type: " + e.getMessage());
        }

        return response;
    }

    private FooData getFooData() {
        FooData fooData = new FooData();
        List<String> fooValue = new ArrayList<>();
        fooValue.add("Hello, World!");
        fooData.set(fooValue);

        return fooData;
    }

    private BarData getBarData() {
        BarData barData = new BarData();
        String barValue = "Hello, World!";
        barData.set(barValue);

        return barData;
    }

}
