package hellotdd.chapter02.v3;

public enum PasswordStrength {
    STRONG, NORMAL;

    public static class PasswordStrengthMeter {
        public hellotdd.chapter02.v4.PasswordStrength meter(String s) {
            if (s.length() < 8) {
                return hellotdd.chapter02.v4.PasswordStrength.NORMAL;
            }
            if (!meetsContainingNumberCriteria(s)) {
                return hellotdd.chapter02.v4.PasswordStrength.NORMAL;
            }
            return hellotdd.chapter02.v4.PasswordStrength.STRONG;
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
}
