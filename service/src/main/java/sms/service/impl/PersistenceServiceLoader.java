package sms.service.impl;

import sms.persistence.PersistenceService;

import java.util.Optional;
import java.util.ServiceLoader;

public class PersistenceServiceLoader {

    public static PersistenceService persistenceService;

    static {
        final Optional<PersistenceService> optionalPersistenceService = ServiceLoader.load(PersistenceService.class).findFirst();
//        System.out.println("----optionalPersistenceService----");
        if (optionalPersistenceService.isPresent()) {
            persistenceService = optionalPersistenceService.get();
        } else {
            throw new RuntimeException("No persistence service.");
        }
    }
}
