package demo.service;

import demo.dao.UserHardCodeRepository;
import demo.dao.UserRepository;
import demo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    UserService userService;

    private UserRepository userRepo;

    @BeforeEach
    void init() {
        this.userRepo = Mockito.mock(UserHardCodeRepository.class);
        this.userService = new UserServiceImpl(userRepo);
    }

    @Test
    void whenGetTotalNumbersForName_thenReturn2() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Tom"));
        users.add(new User(2, "Tom"));
        users.add(new User(3, "Philip"));

        when(userRepo.getUsers()).thenReturn(users);

        assertThat(userService.getTotalNumbersForName("Tom"), is(2));
        assertThat(userService.getTotalNumbersForName("Philip"), is(1));
        assertThat(userService.getTotalNumbersForName("Kathy"), is(0));
        assertThat(userService.getTotalNumbersForName(""), is(0));
        assertThat(userService.getTotalNumbersForName(null), is(0));
    }
}