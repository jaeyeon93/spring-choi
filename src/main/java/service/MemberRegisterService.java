package service;

import dao.MemberDao;
import domain.Member;
import domain.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import validation.AlreadyExistingMemberException;

import javax.annotation.Resource;
import java.nio.file.FileAlreadyExistsException;
import java.util.Date;

public class MemberRegisterService {
    @Resource(name = "memberDao")
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if (member != null)
            throw new AlreadyExistingMemberException("dup email " + req.getEmail());
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(), new Date());
        memberDao.insert(newMember);
    }
}
