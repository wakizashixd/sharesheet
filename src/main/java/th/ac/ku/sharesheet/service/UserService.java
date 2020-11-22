package th.ac.ku.sharesheet.service;

import org.mindrot.jbcrypt.BCrypt;
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

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
    public void createUser(User user) {
        // .... hash pin ....
        String hashPin = hash(user.getPin());
        user.setPin(hashPin);

        userList.add(user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(this.userList);
    }



}