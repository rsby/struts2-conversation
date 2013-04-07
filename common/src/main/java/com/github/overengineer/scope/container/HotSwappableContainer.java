package com.github.overengineer.scope.container;

/**
 */
public interface HotSwappableContainer extends Container {

    <T> void swap(Class<T> target, Class<? extends T> implementation) throws HotSwapException;

    <T, I extends T> void swap(Class<T> target, I implementation) throws HotSwapException;

}
