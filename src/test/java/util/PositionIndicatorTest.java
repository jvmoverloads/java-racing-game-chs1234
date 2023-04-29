package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionIndicatorTest {

    @Test
    @DisplayName("숫자 n에 대하여 '-'가 n개 표시되어야 한다.")
    void indicate_character_by_position() {
        // given
        String expected = "----";
        int position = 4;

        // when
        String indicator = PositionIndicator.indicateCharacterByPosition(position);

        // then
        Assertions.assertEquals(expected.length(), position);
        Assertions.assertEquals(expected, indicator);
    }

}