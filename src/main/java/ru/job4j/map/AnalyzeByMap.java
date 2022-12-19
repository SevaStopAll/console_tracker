package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int counter = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject1 subject1 : pupil.subject1s()) {
                score += subject1.score();
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
            for (Subject1 subject1 : pupil.subject1s()) {
                score += subject1.score();
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
            for (Subject1 subject1 : pupil.subject1s()) {
                if (temp.containsKey(subject1.name())) {
                    temp.put((subject1.name()), temp.get(subject1.name()) + subject1.score());
                } else {
                temp.put(subject1.name(), subject1.score());
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
            for (Subject1 subject1 : pupil.subject1s()) {
                score += subject1.score();
                students.add(new Label(pupil.name(), score));
            }
        }
        students.sort(Comparator.naturalOrder());
        return students.get(students.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject1 subject1 : pupil.subject1s()) {
                int score = temp.getOrDefault(subject1.name(), 0);
                temp.put(subject1.name(), score + subject1.score());
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