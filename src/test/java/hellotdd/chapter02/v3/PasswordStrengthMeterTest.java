package hellotdd.chapter02.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PasswordStrengthMeterTest {


    @Test
    @DisplayName("모든 규칙을 충족하는 테스트")
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(result, PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("길이만 8글자 미만이고 나머지 조건은 충족하는 테스트 코드")
    void meetsAllCriteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(result, PasswordStrength.NORMAL);
        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(result2, PasswordStrength.NORMAL);
    }
    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_number_the_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(result, PasswordStrength.NORMAL);
    }
}