package com.example.empik.view;

import com.example.empik.domain.entity.GitUserInfo;
import com.example.empik.service.GitUserService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private GitUserService gitUserService;

    private TextField id = new TextField("Id");
    private TextField login = new TextField("Login");
    private TextField name = new TextField("Name");
    private TextField type = new TextField("type");
    private TextField avatar_url = new TextField("Avatar Url");
    private TextField created_at = new TextField("Created At");
    private TextField calculations = new TextField("Calculations");

    private TextField usersLogin = new TextField("User's login");


    private Binder<GitUserInfo> binder = new Binder(GitUserInfo.class);
    private Grid<GitUserInfo> grid = new Grid<>(GitUserInfo.class);


    public MainView(GitUserService gitUserService) {
        this.gitUserService = gitUserService;
        add(getForm(), grid);
    }

    private Component getForm() {
        var layout = new HorizontalLayout();
        layout.setAlignItems(Alignment.BASELINE);

        var addButton = new Button("Get info about user");
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.add(usersLogin, addButton);


        binder.bindInstanceFields(this);

        addButton.addClickListener(event -> {
            try {
                refreshGrid();
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });

        return layout;
    }

    private void refreshGrid() throws ValidationException {
        grid.setItems(gitUserService.getGitUser(usersLogin.getValue()));
    }

}

