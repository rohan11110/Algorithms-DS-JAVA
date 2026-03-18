public class Strings {

    public static boolean validPalindrome(String str) {
        int st = 0;
        int ed = str.length() - 1;

        while (st < ed) {
            if (str.charAt(st) != str.charAt(ed)) {
                return false;
            }
            st++;
            ed--;
        }
        return true;
    }

    public static void shortestPath(String str) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'N') {
                y++;
            } else if (ch == 'E') {
                x++;
            } else if (ch == 'W') {
                x--;
            } else if (ch == 'S') {
                y--;
            }
        }

        System.out.print("(" + x + "," + y + ")");
    }

    public static void convertUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') {
                sb.append(ch);
                sb.append(Character.toUpperCase(str.charAt(i + 1)));
                i++;
            } else {
                sb.append(ch);
            }
        }
        System.out.print(sb.toString());
    }

    public static void stringCompression(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            int count = 1;

            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count);
            }
        }

        System.out.print(sb.toString());

    }

    public static void main(String[] args) {
        // System.out.print(validPalindrome("madama"));
        stringCompression("aaabccdddde");
    }
}
