/*
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.services.cloudwatch.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * StAX request marshaller for DeleteAlarmsRequest
 */
public class DeleteAlarmsRequestMarshaller implements
        Marshaller<Request<DeleteAlarmsRequest>, DeleteAlarmsRequest> {

    public Request<DeleteAlarmsRequest> marshall(DeleteAlarmsRequest deleteAlarmsRequest) {
        if (deleteAlarmsRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(DeleteAlarmsRequest)");
        }

        Request<DeleteAlarmsRequest> request = new DefaultRequest<DeleteAlarmsRequest>(
                deleteAlarmsRequest, "AmazonCloudWatch");
        request.addParameter("Action", "DeleteAlarms");
        request.addParameter("Version", "2010-08-01");

        String prefix;
        if (deleteAlarmsRequest.getAlarmNames() != null) {
            prefix = "AlarmNames";
            java.util.List<String> alarmNames = deleteAlarmsRequest.getAlarmNames();
            int alarmNamesIndex = 1;
            String alarmNamesPrefix = prefix;
            for (String alarmNamesItem : alarmNames) {
                prefix = alarmNamesPrefix + ".member." + alarmNamesIndex;
                if (alarmNamesItem != null) {
                    request.addParameter(prefix, StringUtils.fromString(alarmNamesItem));
                }
                alarmNamesIndex++;
            }
            prefix = alarmNamesPrefix;
        }

        return request;
    }
}
