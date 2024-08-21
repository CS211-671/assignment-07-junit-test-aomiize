package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        UserList userList = new UserList();
        userList.addUser("6xxxxxxx1", "pass1");
        userList.addUser("6xxxxxxx2", "pass2");
        userList.addUser("6xxxxxxx3", "pass3");

        // TODO: find one of them
        User user = userList.findUserByUsername("6xxxxxxx1");
        assertEquals("6xxxxxxx1", user.getUsername());
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        UserList userList = new UserList();
        userList.addUser("6xxxxxxx1", "pass1");
        userList.addUser("6xxxxxxx2", "pass2");
        userList.addUser("6xxxxxxx3", "pass3");

        // Change password of one user
        boolean isChanged = userList.changePassword("6xxxxxxx1", "pass1", "newPass1");

        // Assert that the password change was successful
        assertTrue(isChanged);

        // Assert that the user's new password is correct
        User user = userList.findUserByUsername("6xxxxxxx1");
        assertNotNull(user);
        assertEquals("newPass1", user.getPassword());
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        UserList userList = new UserList();
        userList.addUser("6xxxxxxx1", "pass1");
        userList.addUser("6xxxxxxx2", "pass2");
        userList.addUser("6xxxxxxx3", "pass3");

        // Call login() with correct username and password
        User user = userList.login("6xxxxxxx1", "pass1");

        // Assert that the correct User object is returned
        assertNotNull(user);
        assertEquals("6xxxxxxx1", user.getUsername());
        assertEquals("pass1", user.getPassword());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        UserList userList = new UserList();
        userList.addUser("6xxxxxxx1", "pass1");
        userList.addUser("6xxxxxxx2", "pass2");
        userList.addUser("6xxxxxxx3", "pass3");

        // Call login() with incorrect password
        User user = userList.login("6xxxxxxx1", "wrongPass");

        // Assert that the method returns null
        assertNull(user);
    }

}