package com.github.overengineer.scope.struts2;

import com.github.overengineer.scope.container.BaseProvider;
import com.github.overengineer.scope.container.Provider;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;

public class StrutsScopeContainer extends BaseProvider {

    private static final long serialVersionUID = -6820777796732236492L;

    private Container container;

    @Inject
    public void setContainer(Container container) {
        this.container = container;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getProperty(Class<T> clazz, String name) {
        String string = container.getInstance(String.class, name);
        if (clazz == long.class) {
            return (T) Long.valueOf(string);
        } else if (clazz == int.class) {
            return (T) Integer.valueOf(string);
        } else if (clazz == boolean.class) {
            return (T) (Boolean) "true".equals(string);
        }
        return (T) string;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T getSingletonComponent(Class<T> clazz) {
        if (clazz.isAssignableFrom(StrutsScopeContainer.class)) {
            return (T) this;
        } else {
            String typeKey = container.getInstance(String.class, clazz.getName());
            if (typeKey == null) {
                return container.getInstance(clazz);
            }
            return container.getInstance(clazz, typeKey);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T getNewComponentInstance(Class<T> clazz) {
        try {
            return (T) getSingletonComponent(clazz).getClass().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not create new instance of component", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> Class<? extends T> getImplementationType(Class<T> clazz) {
        if (clazz.isAssignableFrom(StrutsScopeContainer.class)) {
            return (Class<? extends T>) StrutsScopeContainer.class;
        }
        return (Class<? extends T>) getSingletonComponent(clazz).getClass();
    }

}
