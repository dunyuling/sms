module sms.filestore {
    requires sms.model;
    requires sms.persistence;
    provides sms.persistence.PersistenceService with sms.filestore.PersistenceServiceImpl;

    exports sms.filestore;
}