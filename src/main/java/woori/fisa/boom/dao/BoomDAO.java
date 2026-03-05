package woori.fisa.boom.dao;

import org.springframework.stereotype.Repository;
import woori.fisa.boom.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoomDAO {
    private final List<User> list = new ArrayList<>();
    private int nextId = 1;

    public BoomDAO() {
        list.add(new User(nextId++, "이건희"));
        list.add(new User(nextId++, "선지원"));
        list.add(new User(nextId++, "백민정"));
    }

    public List<User> findAll(){
        return list;
    }

    public User findById(int id) {
        return list.stream()
                .filter(p -> p.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    public User addUser(String name) {
        User user = new User(nextId++, name);
        list.add(user);
        return user;
    }

    public boolean deleteById(int id) {
        return list.removeIf(p -> p.getUserId() == id);
    }
}