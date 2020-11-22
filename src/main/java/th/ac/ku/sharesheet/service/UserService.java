package th.ac.ku.sharesheet.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import th.ac.ku.sharesheet.data.UserRepository;
import th.ac.ku.sharesheet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//เพิ่มคลาส UserService เพื่อเก็บและจัดการข้อมูลผู้ใช้ทั้งหมดแทน Controller
@Service
public class UserService {
    private UserRepository repository;

    private ArrayList<User> userList = new ArrayList<>();

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(User user) {
        String hashPin = hash(user.getPin());
        user.setPin(hashPin);
        repository.save(user);
    }

    public User findUser(int id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User checkPin(User inputUser) {
        User storedUser = findUser(inputUser.getId());

        if (storedUser != null) {
            String storedPin = storedUser.getPin();

            if (BCrypt.checkpw(inputUser.getPin(), storedPin))
                return storedUser;
        }
        return null;
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
}
