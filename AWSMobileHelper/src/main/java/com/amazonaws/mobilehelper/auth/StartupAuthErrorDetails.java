package com.amazonaws.mobilehelper.auth;
//
// Copyright 2017 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.16
//

import com.amazonaws.mobilehelper.auth.signin.AuthException;

/**
 * Encapsulates errors that may have happened during doStartupAuth().
 */
public class StartupAuthErrorDetails {
    private final AuthException authException;
    private final Exception unauthException;

    /* package */ StartupAuthErrorDetails(final AuthException authException,
                                          final Exception unauthException) {
        this.authException = authException;
        this.unauthException = unauthException;
    }

    /**
     * @return true if an error occurred refreshing a previously signed in provider, otherwise false.
     */
    public boolean didErrorOccurRefreshingProvider() {
        return authException != null;
    }

    /**
     * @return the AuthException that occurred while refreshing a provider, otherwise null.
     */
    public AuthException getProviderRefreshException() {
        return authException;
    }

    /**
     * @return true if an error occurred obtaining an unauthenticated identity, otherwise false.
     */
    public boolean didErrorOccurObtainingUnauthenticatedIdentity() {
        return unauthException != null;
    }

    /**
     * @return the exception that occurred while trying to obtain an unauthenticated (guest) identity.
     */
    public Exception getUnauthenticatedErrorException() {
        return unauthException;
    }
}
