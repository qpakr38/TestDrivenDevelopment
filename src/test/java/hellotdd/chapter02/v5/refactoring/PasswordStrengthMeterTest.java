package hellotdd.chapter02.v5.refactoring;

import hellotdd.chapter02.v5.PasswordStrength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    @DisplayName("모든 규칙을 충족하는 테스트")
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
    }


    @Test
    @DisplayName("길이만 8글자 미만이고 나머지 조건은 충족하는 테스트 코드")
    void meetsAllCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_number_the_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }


    @Test
    @DisplayName("값이 없는 경우")
    void nullInput_Then_Invalid() {
        PasswordStrength result1 = this.meter.meter("");
        assertEquals(PasswordStrength.INVALID, result1);
        PasswordStrength result2 = this.meter.meter(null);
        assertEquals(PasswordStrength.INVALID, result2);
        //assertEquals("",PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }


}