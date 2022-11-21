package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MovingTest {
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void 정상값_view(String str) {
        List<String> cellNames = Stream.of(BridgeCell.values())
                .map(BridgeCell::name)
                .collect(Collectors.toList());
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(str.getBytes()));
        assertThat(cellNames).contains(inputView.readMoving());
    }
}