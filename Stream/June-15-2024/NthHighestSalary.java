import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary {
    public static void main(String[] args) {
        Map<String, Integer> employeeSalaries = new HashMap<>();
        employeeSalaries.put("Abrar", 30000);
        employeeSalaries.put("Chand", 80000);
        employeeSalaries.put("Kalam", 70000);
        employeeSalaries.put("Raheem", 25000);
        employeeSalaries.put("Kiran", 63000);
        employeeSalaries.put("Esa", 45000);

        int n = 3; // Find the 3rd highest salary
        Map.Entry<Integer, List<String>> result = getDynamicNthHighestSalary(employeeSalaries, n);
        System.out.println(result.getValue() + " have the " + n + "th highest salary of " + result.getKey());
    }

    public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(Map<String, Integer> employeeSalaries, int n) {
       return employeeSalaries.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .skip(n - 1)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}