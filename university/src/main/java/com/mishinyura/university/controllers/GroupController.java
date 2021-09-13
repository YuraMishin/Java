package com.mishinyura.university.controllers;

import com.mishinyura.university.services.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class GroupController.
 * Implements Group Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.09.2021
 */
@Controller
public class GroupController {
    /**
     * GroupService.
     */
    private final GroupService groupService;

    /**
     * Constructor.
     *
     * @param groupService groupService
     */
    public GroupController(final GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * Method displays all groups.
     * GET: /groups
     *
     * @param model model
     * @return groups template page
     */
    @GetMapping("/groups")
    public String index(final Model model) {
        var groups = groupService.findAll();
        model.addAttribute("groups", groups);
        return "groups";
    }
}
