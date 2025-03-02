package com.freimanvs.subscriptions.exceptions;

public class SubscriptionsException extends RuntimeException {
    public SubscriptionsException() {
    }

    public SubscriptionsException(String message) {
        super(message);
    }

    public SubscriptionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubscriptionsException(Throwable cause) {
        super(cause);
    }

    public SubscriptionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
