import io.timewase.spring.TimeWase.model.User;
import io.timewase.spring.TimeWase.repository.UserRepository;
import io.timewase.spring.TimeWase.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class TimeWaseServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService UserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user2.setUsername("user2");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = UserService.getAllUsers();
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getUsername());
        assertEquals("user2", users.get(1).getUsername());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("user1");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = UserService.getUserById(1L);
        assertTrue(foundUser.isPresent());
        assertEquals("user1", foundUser.get().getUsername());

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("user1");

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = UserService.saveUser(user);
        assertEquals("user1", savedUser.getUsername());

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        UserService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}
