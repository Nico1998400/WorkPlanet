package com.example.workplanet.views;


import com.example.workplanet.entities.JobPost;
import com.example.workplanet.services.JobService;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.RouterLink;
import java.util.List;
import java.util.Map;

public class JobViewLayout extends VerticalLayout {

    public JobViewLayout(JobPost jobPost) {

            RouterLink title = new RouterLink(jobPost.getTitle(), JobView.class);

            title.setQueryParameters(new QueryParameters(Map.of("jobId", List.of(String.valueOf(jobPost.getId())))));
            title.getStyle().set("font-seize", "34");
            title.getStyle().set("font-weight", "bold");
            Span category = new Span(jobPost.getJobbCategory());

            Paragraph location = new Paragraph(jobPost.getLocation());
            Paragraph postedBy = new Paragraph("Posted By: ");
            Span author = new Span(jobPost.getAppUser().getUsername());
            author.getStyle().set("font-weight", "bold");
            category.getStyle().set("font-weight", "bold");
            postedBy.add(author);

            add(title, category, location, postedBy, new Hr());

    }

}
