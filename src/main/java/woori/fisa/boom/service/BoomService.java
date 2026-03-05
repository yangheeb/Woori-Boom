package woori.fisa.boom.service;

import org.springframework.stereotype.Service;
import woori.fisa.boom.dao.BoomDAO;
import woori.fisa.boom.domain.User;

import java.util.List;

@Service
public class BoomService {

    private final BoomDAO boomDAO;

    public BoomService(BoomDAO boomDAO) {
        this.boomDAO = boomDAO;
    }

    // 전체 플레이어 조회
    public List<User> findAllPlayers() {
        return boomDAO.findAll();
    }

    // 플레이어 추가
    public void add(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }

        boomDAO.addUser(name);
    }

    // 붐업 붐다
    public void vote(Long id, String direction) {

        User user = boomDAO.findById(id.intValue());

        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }

        if ("up".equals(direction)) {
            user.setCnt(user.getCnt() + 1);
        }
        else if ("down".equals(direction)) {
            user.setCnt(user.getCnt() - 1);
        }
    }

    // 전체 점수 초기화
    public void reset() {

        List<User> users = boomDAO.findAll();

        for (User user : users) {
            user.setCnt(0);
        }
    }
}