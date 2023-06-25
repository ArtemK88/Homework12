import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Artem", "A", 25));
        users.add(new User("Anton", "B", 30));
        users.add(new User("Olga", "C", 22));
        users.add(new User("Maryna", "D", 28));
        users.add(new User("Oleg", "F", 35));
        users.add(new User("Petro", "G", 20));
        users.add(new User("Sergiy", "F", 40));
        users.add(new User("Andriy", "H", 27));
        users.add(new User("Viktor", "S", 32));
        users.add(new User("Alex", "P", 17));

        List<User> sortedByAge = users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
        System.out.println("Сортування за віком:");
        for (User user : sortedByAge) {
            System.out.println(user);
        }
        double averageAge = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Середній вік юзерів: " + averageAge);

        List<User> sortedByFirstNameAndAge = users.stream()
                .sorted(Comparator.comparing(User::getFirstName).thenComparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("Сортування за ім'ям та віком:");
        for (User user : sortedByFirstNameAndAge) {
            System.out.println(user);
        }

        boolean hasUsersWithSorA = users.stream()
                .anyMatch(user -> user.getSecondName().startsWith("S") || user.getSecondName().startsWith("A"));
        System.out.println("Чи є юзери з прізвищами, що починаються з літери 'S' або 'А': " + hasUsersWithSorA);


        boolean allUsersAbove18 = users.stream()
                .allMatch(user -> user.getAge() > 18);
        System.out.println("Чи всі юзери старше 18 років: " + allUsersAbove18);
    }
}