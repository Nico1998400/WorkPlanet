package com.example.workplanet.views;


import com.example.workplanet.entities.JobPost;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class JobViewLayout extends VerticalLayout {

    public JobViewLayout(JobPost jobPost) {

            H2 category = new H2(jobPost.getJobbCategory());
            Span title = new Span(jobPost.getTitle());

            Paragraph location = new Paragraph(jobPost.getLocation());
            Paragraph postedBy = new Paragraph("Posted By: ");
            Span author = new Span(jobPost.getAppUser().getUsername());
            author.getStyle().set("font-weight", "bold");
            category.getStyle().set("font-weight", "bold");
            postedBy.add(author);

            add(category, title, location, postedBy, new Hr());

    }

}
