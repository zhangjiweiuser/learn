package learn.chapter2021.chapter07.chapter0702;

public enum MaskType {
    /**
     * 默认掩码类型
     */
    DEFAULT(5, 5, 3),
    /**
     * 手机号码
     */
    MOBILE(3, 4, 0),
    /**
     * 银行卡号
     */
    BANK_CARD(6, 4, 0),
    /**
     * 身份证号
     */
    ID_CARD(1, 1, 0),
    /**
     * 姓名
     */
    NAME(0, 0, 0) {
        @Override
        protected char[] internalMask(String str) {
            char[] chs = str.toCharArray();
            chs[0] = Mask.MASK_CHAR;
            return chs;
        }
    },

    /**
     * 信用卡
     */
    CVV(0, 0, 0) {
        @Override
        protected char[] internalMask(String str) {
            return Mask.MASK_3;
        }
    };


    private int before;
    private int after;
    private int mask;

    MaskType(int before, int after, int mask) {
        this.before = before;
        this.after = after;
        this.mask = mask;
    }

    public final String mask(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        return new String(internalMask(str));
    }

    public final char[] maskToChars(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return Mask.EMPTY_CHARS;
        }
        return internalMask(str);
    }

    protected char[] internalMask(String str) {
        return Mask.maskToChars(str, before, after, mask);
    }
}
