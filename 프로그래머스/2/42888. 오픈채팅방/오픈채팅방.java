import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();

        for (String s : record) {
            String[] words = s.split(" ");
            String command = words[0];
            String userId = words[1];

            switch (command) {
                case "Leave": break;
                default: map.put(userId, words[2]);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (String s : record) {
            String[] words = s.split(" ");
            String command = words[0];
            String userId = words[1];
            String nickname = map.get(userId);
            switch (command) {
                case "Enter": list.add(nickname + "님이 들어왔습니다."); break;
                case "Leave": list.add(nickname + "님이 나갔습니다."); break;
            }
        }

        answer = list.toArray(new String[list.size()]);
        return answer;
    }
}