package com.pfizer.sacchonapi.router;

import com.pfizer.sacchonapi.model.ApplicationUser;
import com.pfizer.sacchonapi.model.MediData;
import com.pfizer.sacchonapi.resource.*;
import org.restlet.Application;
import org.restlet.routing.Router;

public class CustomRouter {
    private Application application;

    public CustomRouter(Application application) {
        this.application = application;

    }

    public Router createApiRouter() {

        Router router = new Router(application.getContext());

        //a doctor clicks on a patient
        router.attach("/user/{uid}/patient/{pid}", ApplicationUserResourceImpl.class);

        //a doctor consults a new patient
        router.attach("/consult-patient/{pid}", ApplicationUserResourceImpl.class);


        //a patient views their average daily blood glucose level over a user-specified period
        router.attach("/medidata/{datatype}/{fromdate}/{todate}", MediDataListResourceImpl.class);

        //medidata endpoints
        router.attach("/medidata/{id}", MediDataResourceImpl.class);
        router.attach("/medidata", MediDataListResourceImpl.class);
        router.attach("/medidata/", MediDataListResourceImpl.class);

        router.attach("/consultation/{id}", ConsultationResourceImpl.class);
        router.attach("/consultation/", ConsultationListResourceImpl.class);
        router.attach("/consultation", ConsultationListResourceImpl.class);


        return router;
    }

//    public Router publicResources() {
//        Router router = new Router();
//        router.attach("/ping", PingServerResource.class);
//        return router;
//    }

    public Router publicUser() {
        Router router = new Router();
        router.attach("/register", ApplicationUserListResourceImpl.class);
        return router;
    }
}
