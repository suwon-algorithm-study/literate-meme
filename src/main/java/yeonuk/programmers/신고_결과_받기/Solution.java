package yeonuk.programmers.신고_결과_받기;

import java.util.*;

class Solution {

    public int[] solution(String[] idList, String[] reports, int k) {
        UserInfo userInfo = new UserInfo();
        ReportInfo reportInfo = new ReportInfo();
        for (String id : idList) {
            User user = new User(id);
            userInfo.addUser(user);
            reportInfo.putUser(user);
        }

        for (String report : reports) {
            String[] ids = report.split(" ");
            User plaintiff = userInfo.getUser(ids[0]);
            User defendant = userInfo.getUser(ids[1]);

            reportInfo.putReport(defendant, plaintiff);
        }

        reportInfo.sendMail(k);

        return userInfo.getMailCount();
    }
}

class ReportInfo {


    private Map<User, List<User>> info = new HashMap<>();

    public void putUser(User user) {
        info.put(user, new ArrayList<>());
    }

    public void putReport(User defendant, User plaintiff) {
        List<User> plaintiffs = info.get(defendant);

        if (!plaintiffs.contains(plaintiff)) {
            plaintiffs.add(plaintiff);
            info.put(defendant, plaintiffs);
        }
    }

    public void sendMail(int k) {
        info.values()
                .stream()
                .filter(users -> users.size() >= k)
                .flatMap(Collection::stream)
                .forEach(User::receiveMail);
    }
}

class UserInfo {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저 id=" + id));
    }

    public int[] getMailCount() {
        return users.stream()
                .mapToInt(User::getMailCount)
                .toArray();
    }
}

class User {

    private final String id;

    private int mailCount;

    public User(String id) {
        this.id = id;
        this.mailCount = 0;
    }

    public void receiveMail() {
        this.mailCount += 1;
    }

    public String getId() {
        return id;
    }

    public int getMailCount() {
        return mailCount;
    }
}