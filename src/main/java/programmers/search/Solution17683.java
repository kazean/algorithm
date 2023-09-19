package programmers.search;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Solution17683 {

    static int[] table;
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Music> musicList = new ArrayList<>();

        List<String> mList = makeCode(m);
        table = new int[mList.size()];
        makeTable(mList);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            String startTime = musicinfo[0];
            String endTime = musicinfo[1];
            String title = musicinfo[2];
            List<String> codeList = makeCode(musicinfo[3]);

            LocalTime startLt = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime endLt = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime diffLt = endLt.minusHours(startLt.getHour()).minusMinutes(startLt.getMinute());
            int playTime = diffLt.getHour() * 60 + diffLt.getMinute();
            int idx = 0;

            List<String> dupCodeList = new ArrayList<>();
            int tmpPlayTime = playTime;
            while (tmpPlayTime > 0) {
                dupCodeList.add(codeList.get(idx++));
                tmpPlayTime--;
                if (idx == codeList.size()) {
                    idx = 0;
                }
            }
            musicList.add(new Music(title, dupCodeList, playTime));
        }

        Optional<Music> first = musicList.stream()
                .filter(i -> kmp(i.code, mList))
                .sorted(new Comparator<Music>() {
                    @Override
                    public int compare(Music o1, Music o2) {
                        return o1.compareTo(o2);
                    }
                }.reversed())
                .findFirst();
        answer = first.orElseGet(()-> {
            return new Music("(None)", null, 0);
        }).title;
        return answer;
    }

    static boolean kmp(List<String> parent, List<String> pattern) {
        boolean answer = false;
        int n1 = parent.size();
        int n2 = pattern.size();

        int idx = 0;
        for (int i = 0; i < n1; i++) {
            while (idx > 0 && !parent.get(i).equals(pattern.get(idx))) {
                idx = table[idx - 1];
            }

            if (parent.get(i).equals(pattern.get(idx))) {
                if (idx == n2 - 1) {
                    idx = table[idx];
                    answer = true;
                    break;
                } else {
                    idx++;
                }
            }
        }
        return answer;
    }

    static List<String> makeCode(String m) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < m.length(); i++) {
            if (i + 1 != m.length() && m.charAt(i + 1) == '#') {
//                list.add(String.valueOf(m.charAt(i) + "#"));
                list.add(m.charAt(i) + "#");
                i++;
            } else {
                list.add(String.valueOf(m.charAt(i)));
            }
        }
        return list;
    }

    static void makeTable(List<String> mList) {
        int idx = 0;
        for (int i = 1; i < mList.size(); i++) {
            while (idx > 0 && mList.get(idx) != mList.get(i)) {
                idx = table[idx - 1];
            }

            if (mList.get(idx) != mList.get(i)) {
                idx++;
                table[i] = idx;
            }
        }
    }

    static class Music implements Comparable<Music>{
        String title;
        List<String> code;
        int playTime;

        public Music(String title, List<String> code, int playTime) {
            this.title = title;
            this.code = code;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(Music o) {
            return Integer.compare(this.playTime, o.playTime);
        }
    }

}
