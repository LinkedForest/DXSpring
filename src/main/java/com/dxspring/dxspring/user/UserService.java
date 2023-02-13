package com.dxspring.dxspring.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        Optional<User> UserEmail = userRepository.findByEmail(user.getEmail());
        if (UserEmail.isPresent()) {
            throw new IllegalStateException("User Email Is Exist");
        }
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).stream().findFirst().orElseThrow(() -> new IllegalStateException("User Not Exist"));
    }

    @Transactional
    public void updateUser(Integer id, String firstname, String lastname, String email, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User Not Exist"));
        if (firstname != null && firstname.length() > 0 && !Objects.equals(user.getFirstname(), firstname)) {
            user.setFirstname(firstname);
        }
        if (lastname != null && lastname.length() > 0 && !Objects.equals(user.getLastname(), lastname)) {
            user.setLastname(lastname);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<User> UserEmail = userRepository.findByEmail(user.getEmail());
            if (UserEmail.isPresent()) {
                throw new IllegalStateException("User Email Is Exist");
            }
            user.setEmail(email);
        }
        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }
    }

    public void deleteUser(Integer UserId) {
        boolean UserExist = userRepository.existsById(UserId);
        if (!UserExist) {
            throw new IllegalStateException("User Not Exist");
        }
        userRepository.deleteById(UserId);
    }
}
