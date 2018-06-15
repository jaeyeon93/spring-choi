package dao;

import domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

    private static long nextId = 0;

    private Map<String, Member> map = new HashMap<>();


    public void insert(Member member) {
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    public void update(Member member) {
        map.put(member.getEmail(), member);
    }
    public Member selectByEmail(String email) {
        return map.get(email);
    }
}
