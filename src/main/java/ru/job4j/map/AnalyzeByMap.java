package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int counter = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                counter++;
            }
        }
        score /= counter;
        return score;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupilsScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int counter = 0;
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                counter++;
            }
            score /= counter;
            pupilsScore.add(new Label(pupil.name(), score));
        }
        return pupilsScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (temp.containsKey(subject.name())) {
                    temp.put((subject.name()), temp.get(subject.name()) + subject.score());
                } else {
                temp.put(subject.name(), subject.score());
                counter++;
                }
            }
        }
        List<Label> subjectScore = new ArrayList<>();
        for (String subject : temp.keySet()) {
            subjectScore.add(new Label(subject, temp.get(subject) / counter));
        }
        return subjectScore;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                students.add(new Label(pupil.name(), score));
            }
        }
        students.sort(Comparator.naturalOrder());
        return students.get(students.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (temp.containsKey(subject.name())) {
                    temp.put((subject.name()), temp.get(subject.name()) + subject.score());
                } else {
                    temp.put(subject.name(), subject.score());
                }
            }
        }
        List<Label> subjectScore = new ArrayList<>();
        for (String subject : temp.keySet()) {
            subjectScore.add(new Label(subject, temp.get(subject)));
        }
        subjectScore.sort(Comparator.naturalOrder());
        return subjectScore.get(subjectScore.size() - 1);
    }
}