package programmers.level2;

public class JadenCaseSolution12951 {

    public static void main(String[] args) {
        JadenCaseSolution12951 solution12951 = new JadenCaseSolution12951();
        System.out.println(solution12951.solution("3people unFollowed me"));
        System.out.println(solution12951.solution("for the last week"));
    }
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            char tmpResult;
            if (' ' == tmp) {
                flag = false;
                sb.append(tmp);
            } else {
                if (!flag) {
                    if ('a' <= tmp && 'z' >= tmp) {
                        tmpResult = (char) (tmp - 32);
                        sb.append(tmpResult);
                    } else {
                        sb.append(tmp);
                    }
                    flag = true;
                } else {
                    if ('A' <= tmp && 'Z' >= tmp) {
                        tmpResult = (char) (tmp + 32);
                        sb.append(tmpResult);
                    } else {
                        sb.append(tmp);
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}
