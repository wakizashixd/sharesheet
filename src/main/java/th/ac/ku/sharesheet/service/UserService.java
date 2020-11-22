package th.ac.ku.sharesheet.service;

import org.springframework.stereotype.Service;
import th.ac.ku.sharesheet.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
//เพิ่มคลาส UserService เพื่อเก็บและจัดการข้อมูลผู้ใช้ทั้งหมดแทน Controller
@Service
public class UserService {
    private List<User> userList;

    @PostConstruct
    public void postConstruct() {
        this.userList = new ArrayList<>();
    }

    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(this.userList);
    }

}