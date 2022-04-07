package hellotdd.chapter02.v5.refactoring;

import hellotdd.chapter02.v5.PasswordStrength;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        if (s.length() < 8) return PasswordStrength.NORMAL;
        if (!meetsContainingNumberCriteria(s)) return PasswordStrength.NORMAL;
        if (!meetsContainingUppercaseCriteria(s)) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
