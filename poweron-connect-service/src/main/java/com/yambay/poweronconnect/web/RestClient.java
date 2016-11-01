package com.yambay.poweronconnect.web;

import com.yambay.poweronconnect.model.JobView;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Created by David on 04/10/2016.
 */
@Service
public class RestClient extends RestTemplate {


    public String getUserIdFromExternalUserId(String externalUserId)
    {

        String url = "http://user-device-service.cfapps.io/user/{externalUserId}/getUserIdFromExternalUserId";

        return getForObject(url, String.class, externalUserId);

    }

    public void saveJob(JobView job)
    {
       String url = "http://job-service.cfapps.io/job/create";

      //  String url = "http://10.61.7.34:8080/job/create";

        Object o = postForObject(
                url, job, Object.class);

    }


}
