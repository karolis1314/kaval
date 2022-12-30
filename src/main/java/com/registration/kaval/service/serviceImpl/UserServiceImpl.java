package com.registration.kaval.service.serviceImpl;

import com.registration.kaval.dto.UserDto;
import com.registration.kaval.model.User;
import com.registration.kaval.repository.AppointmentRepository;
import com.registration.kaval.repository.UserRepository;
import com.registration.kaval.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private AppointmentRepository appointmentRepository;

    private ModelMapper mapper = new ModelMapper();

    public UserServiceImpl(UserRepository userRepository, AppointmentRepository appointmentRepository) {
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void saveUser(UserDto userDto){
        userRepository.save(mapper.map(userDto, User.class));
    }

    public void changeEmail(String email, String newEmail){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            user.get().setEmail(newEmail);
            userRepository.save(user.get());
        }
    }

    public void changePassword(String email, String newPassword){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            user.get().setPassword(newPassword);
            userRepository.save(user.get());
        }
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return userRepository.findByEmail(email) != null ?
                mapper.map(userRepository.findByEmail(email), UserDto.class) : null;
    }

    @Override
    public List<UserDto> findAllUser() {
        return userRepository.findAll().stream()
                .map((user -> mapper.map(user, UserDto.class)))
                .collect(Collectors.toList());
    }

    public UserDto findUserById(Long id) {
        return userRepository.findById(id).isPresent() ?
                mapper.map(userRepository.findById(id).get(), UserDto.class) : null;
    }



}
