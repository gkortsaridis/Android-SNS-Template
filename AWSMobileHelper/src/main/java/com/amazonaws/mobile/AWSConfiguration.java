//
// Copyright 2017 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.16
//
package com.amazonaws.mobile;

import com.amazonaws.mobilehelper.config.AWSMobileHelperConfiguration;
import com.amazonaws.regions.Regions;

/**
 * This class defines constants for the developer's resource
 * identifiers and API keys. This configuration should not
 * be shared or posted to any public source code repository.
 */
public class AWSConfiguration {
    // AMAZON COGNITO
    public static final Regions AMAZON_COGNITO_REGION = Regions.fromName("us-east-1");
    public static final String  AMAZON_COGNITO_IDENTITY_POOL_ID = "COGNITO_IDENTITY_POOL_ID";
    // GOOGLE CLOUD MESSAGING SENDER ID
    public static final String GOOGLE_CLOUD_MESSAGING_SENDER_ID = "GOOGLE_CLOUD_MESSAGING_SENDER_ID";
    // SNS PLATFORM APPLICATION ARN
    public static final String AMAZON_SNS_PLATFORM_APPLICATION_ARN = "AMAZON_SNS_PLATFORM_APPLICATION_ARN";
    public static final Regions AMAZON_SNS_REGION = Regions.fromName("us-east-1");
    // SNS DEFAULT TOPIC ARN
    public static final String AMAZON_SNS_DEFAULT_TOPIC_ARN = "AMAZON_SNS_DEFAULT_TOPIC_ARN";
    // SNS PLATFORM TOPIC ARNS
    public static final String[] AMAZON_SNS_TOPIC_ARNS = {};

    private static final AWSMobileHelperConfiguration helperConfiguration = new AWSMobileHelperConfiguration.Builder()
        .withCognitoRegion(AMAZON_COGNITO_REGION)
        .withCognitoIdentityPoolId(AMAZON_COGNITO_IDENTITY_POOL_ID)
        .build();
    /**
     * @return the configuration for AWSKit.
     */
    public static AWSMobileHelperConfiguration getAWSMobileHelperConfiguration() {
        return helperConfiguration;
    }
}
