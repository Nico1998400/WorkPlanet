package com.example.workplanet.views;

import com.example.workplanet.entities.JobPost;
import com.example.workplanet.services.JobService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

import java.awt.*;

public class JobForm extends FormLayout {

   TextField category = new TextField("Category");
   TextField title = new TextField("Jobtitle");
   TextField location = new TextField("Location");
   Button saveButton = new Button("Save");

   Binder<JobPost> binder = new BeanValidationBinder<>(JobPost.class);
   JobService jobService;
   ManageJobsView manageJobsView;

   public JobForm(JobService jobService, ManageJobsView manageJobsView) {
       this.jobService = jobService;
       this.manageJobsView = manageJobsView;

       setVisible(false);

       binder.bindInstanceFields(this);

       saveButton.addClickListener(evt -> onSave());

       add(category, title, location, saveButton);
   }

    private void onSave() {
        JobPost jobPost = binder.validate().getBinder().getBean();
        if(jobPost.getId() != 0){
            jobService.updateJobById(jobPost.getId(), jobPost);
        } else {
            jobService.createJob(jobPost);
        }
        setJobPost(null);
        ManageJobsView.updateItems();

        this.getParent().ifPresent(component -> {
            if(component instanceof com.vaadin.flow.component.dialog.Dialog){
                ((Dialog) component).close();
            }
        });
    }

    public void setJobPost(JobPost jobPost){
        if(jobPost != null){
            binder.setBean(jobPost);
            setVisible(true);
        } else {
            setVisible(false);
        }
    }



}
