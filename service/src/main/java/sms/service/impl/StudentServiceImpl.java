package sms.service.impl;

import sms.model.Student;
import sms.persistence.PersistenceException;
import sms.persistence.PersistenceService;
import sms.service.ServiceException;
import sms.service.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private PersistenceService persistenceService = PersistenceServiceLoader.persistenceService;


    @Override
    public List<Student> list() throws ServiceException {

        try {
            return persistenceService.list(Student.class);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Student> getStudent(String id) throws ServiceException {
        try {
            return persistenceService.get(Student.class, id);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addStudent(Student student) throws ServiceException {
        try {
            persistenceService.save(student);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void add(String id, String name, String group) throws ServiceException {
        try {
            addStudent(new Student(id, name, group));
        } catch (ServiceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateStudent(Student student) throws ServiceException {
        try {
            persistenceService.save(student);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteStudent(Student student) throws ServiceException {
        try {
            persistenceService.delete(student.getClass(), student.getId());
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }
}
