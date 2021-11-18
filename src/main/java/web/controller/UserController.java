package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "allusers";
    }

    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user";
    }

    @GetMapping("/admin/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "new";
    }

    @PostMapping("/admin/users")
    public String create(@ModelAttribute("user") User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        user.setRoles(roleService.makeSet(checkBoxRoles));
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "update";
    }

    @PatchMapping("/admin/edit/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam(value = "checkBoxRoles") List<String> checkBoxRoles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : checkBoxRoles) {
            roleSet.add(roleService.loadRoleByName(role));
        }
        user.setRoles(roleSet);
        userService.update(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/remove/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
