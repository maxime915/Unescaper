public final class Unescaper {

    public static void main(String[] args) {
        // some test to show the work done
        compare("\nyolo\bfoo\rbar\\samp\'string'test\"");
    }

    public static String unescape(String s) {
        return unescape(s.getBytes());
    }

    public static String unescape(byte[] chars) {
        String output = "";

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
            case '\b':
                output += "\\b";
                break;
            case '\t':
                output += "\\t";
                break;
            case '\n':
                output += "\\n";
                break;
            case '\f':
                output += "\\f";
                break;
            case '\r':
                output += "\\r";
                break;
            case '\"':
                output += "\\\"";
                break;
            case '\'':
                output += "\\'";
                break;
            case '\\':
                output += "\\\\";
                break;
            case '\0':
                if (i != chars.length - 1)
                    output += "\\0";
                break;
            default:
                if (chars[i] >= 32 && chars[i] < 127)
                    output += new String(new byte[] { chars[i] });
                else // not recognize
                    output += '\uFFFF';
                break;
            }
        }

        return output;
    }

    public static void compare(String s) {
        System.out.println(s);
        System.out.println(unescape(s));
    }
}
