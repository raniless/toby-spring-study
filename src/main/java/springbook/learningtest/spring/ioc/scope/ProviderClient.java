package springbook.learningtest.spring.ioc.scope;

import javax.inject.Inject;
import javax.inject.Provider;

public class ProviderClient {
    @Inject
    Provider<PrototypeBean> prototypeBeanProvider;
}
