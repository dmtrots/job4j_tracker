package ru.job4j.map;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> result = Optional.empty();
        for (Student student : students.keySet()) {
            if (student.account().equals(account)) {
                result = Optional.of(student);
                break;
            }
        }
        return result;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> student = findByAccount(account);
        Optional<Subject> result = Optional.empty();
        if (student.isPresent()) {
            Set<Subject> subjects = students.get(student.get());
            for (Subject subject : subjects) {
                if (subject.name().equals(name)) {
                    result = Optional.of(subject);
                    break;
                }
            }
        }
        return result;
    }
}
