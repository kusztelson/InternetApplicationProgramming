package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
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

    @RequestMapping(value = "/rentUsers")
    public String showRentUsers(Model model, HttpServletRequest request) {
        int userId = ServletRequestUtils.getIntParameter(request, "userId", -1);

        if (userId > 0) {
            model.addAttribute("rentUser", userService.getUser(userId));
        }
        else
        {
            model.addAttribute("rentUser", new RentUser());
        }
        model.addAttribute("rentUserList", userService.listUser());

        return "rentUser";
    }

    @RequestMapping(value = "/addRentUser", method = RequestMethod.POST)
    public String addRentUser(@ModelAttribute("rentUser") RentUser rentUser) {
        System.out.println("First Name: " + rentUser.getName() +
                " Last Name: " + rentUser.getSurname() + " Login: " + rentUser.getLogin() +
                " Password: " + rentUser.getPassword()) ;

        if (rentUser.getId() == 0)
        {
            userService.addUser(rentUser);
        }
        else
        {
            userService.editUser(rentUser);
        }

        return "redirect:rentUsers";
    }

    @RequestMapping(value = "/rentUsers/delete/{rentUserId}")
    public String deleteRentUser(@PathVariable("rentUserId") Long rentUserId) {
        userService.deleteUser(rentUserId);
        return "redirect:/rentUsers";
    }
}
