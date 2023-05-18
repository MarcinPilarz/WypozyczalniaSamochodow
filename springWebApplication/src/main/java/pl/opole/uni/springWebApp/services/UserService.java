//package pl.opole.uni.springWebApp.services;
//
// import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import pl.opole.uni.springWebApp.models.Role;
//import pl.opole.uni.springWebApp.models.User;
//import pl.opole.uni.springWebApp.repositories.UserRepository;
//
//import java.util.List;
//import java.util.Optional;
//
////@Service
////public class UserService implements UserDetailsService {
////
////    private final UserRepository userRepository;
////
////    public UserService(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
////
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user = userRepository.findByUsername(username)
////                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
////
////        return org.springframework.security.core.userdetails.User.builder()
////                .username(user.getUsername())
////                .password(user.getPasswordHash())
////                .authorities(user.getRoles().stream().map(Role::getName).toArray(String[]::new))
////                .build();
////    }
////
////    public void saveUser(User user) {
////        userRepository.save(user);
////    }
////
////    public User findByUsername(String username) {
////        return userRepository.findByUsername(username).orElse(null);
////    }
////}