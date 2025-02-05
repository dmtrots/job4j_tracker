package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sumScore = 0;
        int index = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                index++;
            }
        }
        return (double) sumScore / index;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> scoreByPupil = new ArrayList<>();
        int sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            scoreByPupil.add(new Label(pupil.name(), ((double) sumScore / pupil.subjects().size())));
            sumScore = 0;
        }
        return scoreByPupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> scoreBySubject = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String subject = entry.getKey();
            int sumScore = entry.getValue();
            double averageScore = (double) sumScore / pupils.size();
            scoreBySubject.add(new Label(subject, averageScore));
        }
        return scoreBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> best = new ArrayList<>();
        int sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            best.add(new Label(pupil.name(), sumScore));
            sumScore = 0;
        }
        best.sort(Comparator.naturalOrder());
        return best.getLast();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> best = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String subject = entry.getKey();
            int sumScore = entry.getValue();
            best.add(new Label(subject, sumScore));
        }
        best.sort(Comparator.naturalOrder());
        return best.getLast();
    }
}