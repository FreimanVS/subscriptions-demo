package com.freimanvs.subscriptions.services;

public interface CommonService<T> {
    T save(T subscription);
    T getById(Long id);
    T update(Long id, T subscription);
    void delete(Long id);
}
