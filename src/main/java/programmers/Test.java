package programmers;

public class Test {
    public static void main(String[] args) {
//        Kmp.KMP_old("ABDEGH", "DE");
//        Kmp.KMP_old("ababacabacaaba", "abacaaba");
        String origin = "ABDEGH";
        String origin2 = "ababacabacaaba";
        System.out.println(origin.indexOf("DE"));
        System.out.println(origin2.indexOf("abacaaba"));
    }
}
