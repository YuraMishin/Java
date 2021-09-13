package com.mishinyura.university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class IndexController.
 * Implements Index Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 09.09.2021
 */
@Controller
public class HomeController {
    /**
     * Method displays Index page.
     * GET: /, /index
     *
     * @return Index page
     */
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}
