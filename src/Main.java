import java.util.Arrays;

public class Main {

    // Q1d
    public static Operator[] squiz(Operator[] arr) {
        int count = 1;
        for (int i=1; i<arr.length; i++) {
            if (!arr[i-1].isSame(arr[i])) {
                count++;
            }
        }
        Operator[] rslt = new Operator[count];
        int index = 0;
        rslt[index] = new Operator(arr[0]);
        for (int i=1; i<arr.length; i++) {
            if (rslt[index].isSame(arr[i])) {
                rslt[index] = rslt[index].combine(arr[i]);
            } else {
                index++;
                rslt[index] = new Operator(arr[i]);
            }
        }
        return rslt;
    }

    // Q2a
    public static boolean starts_ends(String str) {
        if (str.equals("") || !str.contains(" ")) {
            return false;
        }
        int i = 0;
        String first = "", last = "";
        while (str.charAt(i) != ' ') {
            first += str.charAt(i);
            i++;
        }
        i = str.length()-1;
        while (str.charAt(i) != ' ') {
            last = str.charAt(i)+last;
            i--;
        }
        return first.equals(last);
    }

    // Q2b
    public static String remove_endDup(String str) {
        String rslt = "";
        if (str.equals("")) {
            return rslt;
        }
        for (int i=0; i<str.length(); i++) {
            if (rslt.contains(String.valueOf(str.charAt(i)))) {
                rslt = rslt.replace(String.valueOf(str.charAt(i)), "");
            }
            rslt += str.charAt(i);
        }
        return rslt;
    }

    // Q3a
    public static boolean alteringParity(int num) {
        if (num < 10) {
            return true;
        }
        return (num%10)%2 != ((num/10)%10)%2 && alteringParity(num/10);
    }

    // Q3b
    public static String decode(int num) {
        if (num < 10) {
            return String.valueOf((char)(65+num));
        }
        return decode(num/10)+String.valueOf((char)(65+(num%10)));
    }

    public static void main(String[] args) {
        // Q1d
        Operator a1 = new Operator('*', 2);
        Operator a2 = new Operator('*', 3);
        Operator a3 = new Operator('+', 4);
        Operator a4 = new Operator('+', -1);
        Operator a5 = new Operator('*', 5);
        Operator[] arr = {a1, a2, a3, a4, a5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(squiz(arr)));
        // Q2b
//        System.out.println(starts_ends("Red is favorite color Red"));
//        System.out.println(starts_ends("me making a meme"));
//        System.out.println(starts_ends("me taking a picture of me"));
        // Q2b
//        System.out.println(remove_endDup("aaabbb"));
//        System.out.println(remove_endDup("abcabcabc"));
//        System.out.println(remove_endDup("wamacasabbwbsm"));
        // Q3a
//        System.out.println(alteringParity(254781));
//        System.out.println(alteringParity(247859));
//        System.out.println(alteringParity(1432));
//        System.out.println(alteringParity(3));
        // Q3b
//        System.out.println(decode(1));
//        System.out.println(decode(123));
//        System.out.println(decode(9054));
    }
}