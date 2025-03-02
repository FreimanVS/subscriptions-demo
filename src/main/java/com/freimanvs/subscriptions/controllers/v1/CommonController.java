package com.freimanvs.subscriptions.controllers.v1;

public interface CommonController<T> {
    T save(T user);
    T getById(Long id);
    T update(Long id, T user);
    void delete(Long id);
}
