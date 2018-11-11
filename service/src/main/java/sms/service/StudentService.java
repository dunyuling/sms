package sms.service;

import sms.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> list() throws ServiceException;

    Optional<Student> getStudent(String id) throws ServiceException;

    void addStudent(Student student) throws ServiceException;

    void add(String id, String name, String group) throws ServiceException;

    void updateStudent(Student student) throws ServiceException;

    void deleteStudent(Student student) throws ServiceException;


}
