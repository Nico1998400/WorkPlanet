package com.example.workplanet.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/user")
public class UserView extends VerticalLayout {  //Här är användarens inloggningsätt. UserView används för att användardata måste sparas för att sen höra ihop med LoginView.
    // Loginview är själva inloggningen därav har jag skapat adminview så admindatan sparas och har ett enskilt inloggningssätt.
    //

    public UserView(){
        add(new H1("Welcome user!"));
    }
}
