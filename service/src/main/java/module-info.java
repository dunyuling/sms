module sms.service {
    requires sms.model;
    requires sms.persistence;

    provides sms.service.StudentService with sms.service.impl.StudentServiceImpl;

    exports sms.service;
    exports sms.service.impl;

    uses sms.persistence.PersistenceService;
}