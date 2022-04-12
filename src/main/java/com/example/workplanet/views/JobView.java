package com.example.workplanet.views;

import com.example.workplanet.entities.JobPost;
import com.example.workplanet.services.JobService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "/job", layout = AppView.class)
//@AnonymousAllowed
@AnonymousAllowed
public class JobView extends VerticalLayout implements BeforeEnterObserver {


    JobService jobService;
    Grid<JobPost> grid = new Grid<>(JobPost.class, false);
    JobForm jobForm;


    public JobView(JobService jobService, JobPost jobPost) {
       /* grid.setItems(jobService.findByUsername(Principalutils.getName()));


            RouterLink title = new RouterLink(jobPost.getTitle(), JobView.class);
            title.getStyle().set("font-seize", "34");
            title.getStyle().set("font-weight", "bold");
            Span category = new Span(jobPost.getJobbCategory());

            Paragraph location = new Paragraph(jobPost.getLocation());
            Paragraph postedBy = new Paragraph("Posted By: ");
            Span author = new Span(jobPost.getAppUser().getUsername());
            author.getStyle().set("font-weight", "bold");
            category.getStyle().set("font-weight","bold");
            postedBy.add(author);

            add(title, category, location, postedBy, new Hr());
*/
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent
                .getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")
        );



    }
}

