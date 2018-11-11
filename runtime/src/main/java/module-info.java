module sms.runtime {
    requires sms.model;
    requires sms.persistence;
    requires sms.service;
    requires sms.filestore;
    uses sms.service.StudentService;
}