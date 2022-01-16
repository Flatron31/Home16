import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class University {
    private String nameUniversity;
    private List<Group> listGroup;

    public University() {
    }

    public University(String nameUniversity, List<Group> listGroup) {
        this.nameUniversity = nameUniversity;
        this.listGroup = listGroup;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public List<Group> getListGroup() {
        return listGroup;
    }

    public void setListGroup(List<Group> listGroup) {
        this.listGroup = listGroup;
    }

    @Override
    public String toString() {
        return "University{" +
                "nameUniversity='" + nameUniversity + '\'' +
                ", listGroup=" + listGroup +
                '}';
    }

    public static List addUniversity() {
        University garvard = new University("Garvard", new ArrayList<>(List.of(Storage.listGroups.get(0))));
        University oxford = new University("Oxford", new ArrayList<>(List.of(Storage.listGroups.get(1), Storage.listGroups.get(2))));
        Storage.listUniversities.add(garvard);
        Storage.listUniversities.add(oxford);
        return Storage.listUniversities;
    }

    public static void printInfoUniversities() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (University allUniversities : Storage.listUniversities) {
                String json = objectMapper.writeValueAsString(allUniversities);
                System.out.println(json);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void printRatingUniversities() {
        for (University university: Storage.listUniversities){
            List<Group> listGroup = new ArrayList<>();
            listGroup.addAll(university.getListGroup());

            List<Student> listStudentInGroup = new ArrayList<>();
            List<Integer> listStudentGrade = new ArrayList<>();

            for (Group group : listGroup){
                listStudentInGroup.addAll(group.getListStudents());

                for (Student student : listStudentInGroup) {
                    listStudentGrade.addAll(student.getGrade());
                }
            }
            double r = 0;
            OptionalDouble srRating = listStudentGrade.stream()
                    .mapToInt(value -> value)
                    .average();
            if (srRating.isPresent()) {
                r = srRating.getAsDouble();
            }

            System.out.println(university.nameUniversity + " рейтинг = " + r);
        }

    }

}
