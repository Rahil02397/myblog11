import com.myblog.moblog11.entity.Role;
import com.myblog.moblog11.entity.User;
import com.myblog.moblog11.payload.SignUpDto;
import com.myblog.moblog11.repository.RoleRepository;
import com.myblog.moblog11.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

public class practice {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public ResponseEntity<String> signUpDto(
            @RequestBody SignUpDto signUpDto
            ){
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("username already taken", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("email already taken ", HttpStatus.BAD_REQUEST);
        }
        User user = modelMapper.map(signUpDto, User.class);
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role role = roleRepository.findByName(signUpDto.getName()).get();
        Set<Role> ConvertRoleToSet= new HashSet<>();
        ConvertRoleToSet.add(role);
        user.setRoles(ConvertRoleToSet);

        userRepository.save(user);

        return new ResponseEntity<>("sign up sucessful!!", HttpStatus.CREATED);

    }
}