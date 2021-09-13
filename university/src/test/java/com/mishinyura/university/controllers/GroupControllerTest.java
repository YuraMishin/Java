package com.mishinyura.university.controllers;

import com.mishinyura.university.domain.Group;
import com.mishinyura.university.services.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Class GroupControllerTest.
 * Tests com.mishinyura.university.controllers.GroupController class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.09.2021
 */
@WebMvcTest(GroupController.class)
class GroupControllerTest {
    /**
     * MockMvc.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * GroupService.
     */
    @MockBean
    GroupService groupService;

    /**
     * Tests index() method.
     */
    @Test
    void shouldReturnIndexPage() throws Exception {
        // given
        var path = "/groups";
        var viewName = "groups";
        var groups = new ArrayList<Group>();
        Collections.addAll(groups,
            new Group(1L, "Group1"),
            new Group(2L, "Group2")
        );
        when(groupService.findAll()).thenReturn(groups);

        // when-then
        mockMvc
            .perform(get(path))
            .andExpect(status().isOk())
            .andExpect(model().attribute("groups", hasSize(groups.size())))
            .andExpect(view().name(viewName));

        verify(groupService).findAll();
    }
}
