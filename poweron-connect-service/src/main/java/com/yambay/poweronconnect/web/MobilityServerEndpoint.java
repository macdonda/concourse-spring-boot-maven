package com.yambay.poweronconnect.web;


import com.ge.energy.enmac.mobile.nms.IncidentDispatch;
import com.yambay.poweronconnect.model.JobView;
import mobile.IncidentDispatchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by David on 05/05/2016.
 * This endpoint will receive notifications from the mobility server
 */


@Endpoint
public class MobilityServerEndpoint {

    private static final String NAMESPACE_URI = "http://www.ge.com/energy/enmac/mobile/nms";
    private static final Logger logger = LoggerFactory.getLogger(MobilityServerEndpoint.class);


    @Autowired
    RestClient restClient;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IncidentDispatch")
    @ResponsePayload
    public IncidentDispatchResponse getMessage(@RequestPayload IncidentDispatch request) {


        IncidentDispatchResponse response = new IncidentDispatchResponse();
        logger.info (request.getIncidentDispatchStc().getMsgBody().getTCSJobDetails().getTCSJobHeader().getIncidentReference());

        logger.info(restClient.getUserIdFromExternalUserId(request.getIncidentDispatchStc().getMsgBody().getToUser().getUserId()));


        JobView job = new JobView();

        job.setJobCode(request.getIncidentDispatchStc().getMsgBody().getTCSJobDetails().getTCSJobHeader().getIncidentReference());

        job.setJobSource("UKPN_OMS");

        job.setDescription(request.getIncidentDispatchStc().getMsgBody().getTCSJobDetails().getTCSJobHeader().getIncidentDescription().getValue());


        restClient.saveJob(job);

        return response;
    }



}
