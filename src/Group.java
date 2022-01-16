import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Group {
    private String nameGroup;
    private List<Student> listStudents;

    public Group() {
    }

    public Group(String nameGroup, List<Student> listStudents) {
        this.nameGroup = nameGroup;
        this.listStudents = listStudents;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nameGroup='" + nameGroup + '\'' +
                ", listStudents=" + listStudents +
                '}';
    }

    public static List addGroup() {
        Group group1 = new Group("C51", new ArrayList<>(List.of(Storage.listStudents.get(0), Storage.listStudents.get(1))));
        Group group2 = new Group("A32", new ArrayList<>(List.of(Storage.listStudents.get(2), Storage.listStudents.get(3))));
        Group group3 = new Group("B23", new ArrayList<>(List.of(Storage.listStudents.get(4))));
        Storage.listGroups.add(group1);
        Storage.listGroups.add(group2);
        Storage.listGroups.add(group3);
        return Storage.listGroups;
    }

    public static void printInfoGroups() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (Group allGroups : Storage.listGroups) {
                String json = objectMapper.writeValueAsString(allGroups);
                System.out.println(json);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



    public static void printRatingGroups() {
        for (int i = 0; i < Storage.listGroups.size(); i++) {
            Group group = Storage.listGroups.get(i);
            List<Integer> listStudentGrade = new ArrayList<>();
            List<Student> listStudentInGroup = group.getListStudents();

            for (int j = 0; j < listStudentInGroup.size(); j++) {
                listStudentGrade.addAll(listStudentInGroup.get(j).getGrade());
            }

            double ratingGroup = 0;
            OptionalDouble srRating = listStudentGrade.stream()
                    .mapToInt(value1 -> value1)
                    .average();
            if (srRating.isPresent()) {
                ratingGroup = srRating.getAsDouble();
            }
            System.out.println(group.getNameGroup() + " рейтинг = " + ratingGroup);
        }
    }
}

