package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.p.iap.domain.RentUser;
import pl.lodz.p.iap.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RentUserController {
    private UserService userService;

    @Autowired
    public RentUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/rentUser/{rentUserId}")
    public RentUser showRentUser(HttpServletRequest request, @PathVariable("rentUserId") Long rentUserId) {
        RentUser foundRentUser = null;
        foundRentUser = userService.getUser(rentUserId);
        return foundRentUser;
    }

    @RequestMapping(value = "/rentUsers")
    public List<RentUser> showRentUsers(HttpServletRequest request) {
        List<RentUser> RentUserList = userService.listUser();
        return RentUserList;
    }

    @RequestMapping(value = "/addRentUser", method = RequestMethod.POST)
    public Object addRentUser(@ModelAttribute("rentUser") RentUser rentUser) {
        System.out.println("First Name: " + rentUser.getName() +
                " Last Name: " + rentUser.getSurname() + " Login: " + rentUser.getLogin() +
                " Password: " + rentUser.getPassword()) ;

        try
        {
            if (rentUser.getId() == 0)
            {
                userService.addUser(rentUser);
            }
            else
            {
                userService.editUser(rentUser);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<Void>(HttpStatusCode.valueOf(404));
        }

        return rentUser;
    }

    @RequestMapping(value = "/rentUsers/delete/{rentUserId}")
    public void deleteRentUser(@PathVariable("rentUserId") Long rentUserId) {
        userService.deleteUser(rentUserId);
        //return "redirect:/rentUsers";
    }
}
