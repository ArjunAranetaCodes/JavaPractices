import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Comprehensive Java Stream API Examples
 * Demonstrates various stream operations and functional programming concepts
 * 
 * @author Java Practice
 * @version 1.0
 * @since July 2025
 */
public class StreamAPIExamples {
    
    public static void main(String[] args) {
        System.out.println("=== Java Stream API Examples ===\n");
        
        // 1. Basic Stream Operations
        demonstrateBasicOperations();
        
        // 2. Stream Creation
        demonstrateStreamCreation();
        
        // 3. Intermediate Operations
        demonstrateIntermediateOperations();
        
        // 4. Terminal Operations
        demonstrateTerminalOperations();
        
        // 5. Collectors
        demonstrateCollectors();
        
        // 6. Parallel Streams
        demonstrateParallelStreams();
        
        // 7. Optional with Streams
        demonstrateOptionalStreams();
        
        // 8. Custom Collectors
        demonstrateCustomCollectors();
        
        // 9. Stream Performance
        demonstrateStreamPerformance();
        
        // 10. Practical Examples
        demonstratePracticalExamples();
    }
    
    /**
     * Demonstrates basic stream operations
     */
    private static void demonstrateBasicOperations() {
        System.out.println("1. BASIC STREAM OPERATIONS");
        System.out.println("===========================");
        
        // Creating a simple stream
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve");
        
        System.out.println("\n--- Basic Filtering and Mapping ---");
        names.stream()
            .filter(name -> name.length() > 4)
            .map(String::toUpperCase)
            .forEach(System.out::println);
        
        // Chaining operations
        System.out.println("\n--- Chaining Operations ---");
        long count = names.stream()
            .filter(name -> name.startsWith("A"))
            .map(String::toLowerCase)
            .count();
        System.out.println("Names starting with 'A': " + count);
        
        // Finding elements
        System.out.println("\n--- Finding Elements ---");
        Optional<String> firstLongName = names.stream()
            .filter(name -> name.length() > 5)
            .findFirst();
        firstLongName.ifPresent(name -> System.out.println("First long name: " + name));
        
        // Any match and all match
        System.out.println("\n--- Matching Operations ---");
        boolean anyStartsWithA = names.stream().anyMatch(name -> name.startsWith("A"));
        boolean allHaveLength4 = names.stream().allMatch(name -> name.length() == 4);
        boolean noneStartsWithZ = names.stream().noneMatch(name -> name.startsWith("Z"));
        
        System.out.println("Any name starts with 'A': " + anyStartsWithA);
        System.out.println("All names have length 4: " + allHaveLength4);
        System.out.println("No name starts with 'Z': " + noneStartsWithZ);
        
        System.out.println();
    }
    
    /**
     * Demonstrates different ways to create streams
     */
    private static void demonstrateStreamCreation() {
        System.out.println("2. STREAM CREATION");
        System.out.println("==================");
        
        // From Collections
        System.out.println("\n--- From Collections ---");
        List<String> list = Arrays.asList("A", "B", "C");
        Set<String> set = new HashSet<>(Arrays.asList("X", "Y", "Z"));
        
        list.stream().forEach(System.out::print);
        System.out.println();
        set.stream().forEach(System.out::print);
        System.out.println();
        
        // From Arrays
        System.out.println("\n--- From Arrays ---");
        String[] array = {"Apple", "Banana", "Cherry"};
        Arrays.stream(array).forEach(System.out::println);
        
        // From Stream.of()
        System.out.println("\n--- From Stream.of() ---");
        Stream.of("One", "Two", "Three").forEach(System.out::println);
        
        // From Stream.builder()
        System.out.println("\n--- From Stream.builder() ---");
        Stream<String> builderStream = Stream.<String>builder()
            .add("First")
            .add("Second")
            .add("Third")
            .build();
        builderStream.forEach(System.out::println);
        
        // From Stream.generate()
        System.out.println("\n--- From Stream.generate() ---");
        Stream.generate(() -> "Generated")
            .limit(3)
            .forEach(System.out::println);
        
        // From Stream.iterate()
        System.out.println("\n--- From Stream.iterate() ---");
        Stream.iterate(1, n -> n * 2)
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // From Stream.iterate() with predicate
        System.out.println("\n--- From Stream.iterate() with Predicate ---");
        Stream.iterate(1, n -> n < 10, n -> n + 2)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // From Random
        System.out.println("\n--- From Random ---");
        new Random().ints(5, 1, 101)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // From Files
        System.out.println("\n--- From Files (commented out) ---");
        // Files.lines(Paths.get("file.txt")).forEach(System.out::println);
        
        // From String
        System.out.println("\n--- From String ---");
        "Hello World".chars()
            .mapToObj(ch -> (char) ch)
            .forEach(System.out::print);
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * Demonstrates intermediate operations
     */
    private static void demonstrateIntermediateOperations() {
        System.out.println("3. INTERMEDIATE OPERATIONS");
        System.out.println("==========================");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter
        System.out.println("\n--- Filter ---");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Map
        System.out.println("\n--- Map ---");
        numbers.stream()
            .map(n -> n * n)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // FlatMap
        System.out.println("\n--- FlatMap ---");
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D"),
            Arrays.asList("E", "F")
        );
        
        nestedList.stream()
            .flatMap(List::stream)
            .forEach(System.out::print);
        System.out.println();
        
        // Distinct
        System.out.println("\n--- Distinct ---");
        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        duplicates.stream()
            .distinct()
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Sorted
        System.out.println("\n--- Sorted ---");
        List<String> unsorted = Arrays.asList("Charlie", "Alice", "Bob", "Diana");
        unsorted.stream()
            .sorted()
            .forEach(System.out::print);
        System.out.println();
        
        // Sorted with comparator
        System.out.println("\n--- Sorted with Comparator ---");
        unsorted.stream()
            .sorted((a, b) -> Integer.compare(a.length(), b.length()))
            .forEach(System.out::print);
        System.out.println();
        
        // Limit
        System.out.println("\n--- Limit ---");
        numbers.stream()
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Skip
        System.out.println("\n--- Skip ---");
        numbers.stream()
            .skip(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Peek (for debugging)
        System.out.println("\n--- Peek ---");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println("Filtered: " + n))
            .map(n -> n * n)
            .peek(n -> System.out.println("Mapped: " + n))
            .forEach(n -> System.out.println("Final: " + n));
        
        // TakeWhile (Java 9+)
        System.out.println("\n--- TakeWhile ---");
        numbers.stream()
            .takeWhile(n -> n < 6)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // DropWhile (Java 9+)
        System.out.println("\n--- DropWhile ---");
        numbers.stream()
            .dropWhile(n -> n < 6)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * Demonstrates terminal operations
     */
    private static void demonstrateTerminalOperations() {
        System.out.println("4. TERMINAL OPERATIONS");
        System.out.println("======================");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // forEach
        System.out.println("\n--- forEach ---");
        names.stream().forEach(System.out::println);
        
        // collect
        System.out.println("\n--- collect to List ---");
        List<String> filteredNames = names.stream()
            .filter(name -> name.length() > 4)
            .collect(Collectors.toList());
        System.out.println("Filtered names: " + filteredNames);
        
        // collect to Set
        System.out.println("\n--- collect to Set ---");
        Set<String> nameSet = names.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toSet());
        System.out.println("Name set: " + nameSet);
        
        // collect to Map
        System.out.println("\n--- collect to Map ---");
        Map<String, Integer> nameLengthMap = names.stream()
            .collect(Collectors.toMap(
                name -> name,
                String::length
            ));
        System.out.println("Name length map: " + nameLengthMap);
        
        // reduce
        System.out.println("\n--- reduce ---");
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        Optional<Integer> max = numbers.stream()
            .reduce(Integer::max);
        max.ifPresent(m -> System.out.println("Max: " + m));
        
        // count
        System.out.println("\n--- count ---");
        long count = names.stream()
            .filter(name -> name.length() > 4)
            .count();
        System.out.println("Names with length > 4: " + count);
        
        // min/max
        System.out.println("\n--- min/max ---");
        Optional<String> shortestName = names.stream()
            .min(Comparator.comparing(String::length));
        shortestName.ifPresent(name -> System.out.println("Shortest name: " + name));
        
        Optional<String> longestName = names.stream()
            .max(Comparator.comparing(String::length));
        longestName.ifPresent(name -> System.out.println("Longest name: " + name));
        
        // findFirst/findAny
        System.out.println("\n--- findFirst/findAny ---");
        Optional<String> firstLongName = names.stream()
            .filter(name -> name.length() > 4)
            .findFirst();
        firstLongName.ifPresent(name -> System.out.println("First long name: " + name));
        
        Optional<String> anyLongName = names.stream()
            .filter(name -> name.length() > 4)
            .findAny();
        anyLongName.ifPresent(name -> System.out.println("Any long name: " + name));
        
        // anyMatch/allMatch/noneMatch
        System.out.println("\n--- Matching ---");
        boolean anyStartsWithA = names.stream().anyMatch(name -> name.startsWith("A"));
        boolean allHaveLength4 = names.stream().allMatch(name -> name.length() == 4);
        boolean noneStartsWithZ = names.stream().noneMatch(name -> name.startsWith("Z"));
        
        System.out.println("Any starts with 'A': " + anyStartsWithA);
        System.out.println("All have length 4: " + allHaveLength4);
        System.out.println("None starts with 'Z': " + noneStartsWithZ);
        
        // toArray
        System.out.println("\n--- toArray ---");
        String[] nameArray = names.stream()
            .filter(name -> name.length() > 4)
            .toArray(String[]::new);
        System.out.println("Name array: " + Arrays.toString(nameArray));
        
        System.out.println();
    }
    
    /**
     * Demonstrates collectors
     */
    private static void demonstrateCollectors() {
        System.out.println("5. COLLECTORS");
        System.out.println("=============");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve", "Frank");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // toList
        System.out.println("\n--- toList ---");
        List<String> nameList = names.stream()
            .filter(name -> name.length() > 4)
            .collect(Collectors.toList());
        System.out.println("Name list: " + nameList);
        
        // toSet
        System.out.println("\n--- toSet ---");
        Set<String> nameSet = names.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toSet());
        System.out.println("Name set: " + nameSet);
        
        // toMap
        System.out.println("\n--- toMap ---");
        Map<String, Integer> nameLengthMap = names.stream()
            .collect(Collectors.toMap(
                name -> name,
                String::length,
                (existing, replacement) -> existing // Handle duplicates
            ));
        System.out.println("Name length map: " + nameLengthMap);
        
        // groupingBy
        System.out.println("\n--- groupingBy ---");
        Map<Integer, List<String>> namesByLength = names.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Names grouped by length: " + namesByLength);
        
        // partitioningBy
        System.out.println("\n--- partitioningBy ---");
        Map<Boolean, List<String>> namesPartitioned = names.stream()
            .collect(Collectors.partitioningBy(name -> name.length() > 4));
        System.out.println("Names partitioned by length > 4: " + namesPartitioned);
        
        // joining
        System.out.println("\n--- joining ---");
        String joinedNames = names.stream()
            .collect(Collectors.joining(", "));
        System.out.println("Joined names: " + joinedNames);
        
        String joinedWithPrefixSuffix = names.stream()
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined with brackets: " + joinedWithPrefixSuffix);
        
        // counting
        System.out.println("\n--- counting ---");
        long count = names.stream()
            .filter(name -> name.length() > 4)
            .collect(Collectors.counting());
        System.out.println("Count of long names: " + count);
        
        // summingInt/summingLong/summingDouble
        System.out.println("\n--- summing ---");
        int totalLength = names.stream()
            .collect(Collectors.summingInt(String::length));
        System.out.println("Total name length: " + totalLength);
        
        // averagingInt/averagingLong/averagingDouble
        System.out.println("\n--- averaging ---");
        double avgLength = names.stream()
            .collect(Collectors.averagingInt(String::length));
        System.out.println("Average name length: " + avgLength);
        
        // summarizingInt/summarizingLong/summarizingDouble
        System.out.println("\n--- summarizing ---");
        IntSummaryStatistics stats = names.stream()
            .collect(Collectors.summarizingInt(String::length));
        System.out.println("Name length statistics: " + stats);
        
        // maxBy/minBy
        System.out.println("\n--- maxBy/minBy ---");
        Optional<String> longestName = names.stream()
            .collect(Collectors.maxBy(Comparator.comparing(String::length)));
        longestName.ifPresent(name -> System.out.println("Longest name: " + name));
        
        Optional<String> shortestName = names.stream()
            .collect(Collectors.minBy(Comparator.comparing(String::length)));
        shortestName.ifPresent(name -> System.out.println("Shortest name: " + name));
        
        // reducing
        System.out.println("\n--- reducing ---");
        Optional<String> concatenated = names.stream()
            .collect(Collectors.reducing((a, b) -> a + ", " + b));
        concatenated.ifPresent(result -> System.out.println("Concatenated: " + result));
        
        // collectingAndThen
        System.out.println("\n--- collectingAndThen ---");
        List<String> unmodifiableList = names.stream()
            .filter(name -> name.length() > 4)
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                Collections::unmodifiableList
            ));
        System.out.println("Unmodifiable list: " + unmodifiableList);
        
        System.out.println();
    }
    
    /**
     * Demonstrates parallel streams
     */
    private static void demonstrateParallelStreams() {
        System.out.println("6. PARALLEL STREAMS");
        System.out.println("===================");
        
        List<Integer> numbers = IntStream.range(1, 1000001).boxed().collect(Collectors.toList());
        
        // Sequential vs Parallel
        System.out.println("\n--- Sequential vs Parallel ---");
        
        long startTime = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
            .mapToLong(Integer::longValue)
            .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("Sequential sum: " + sequentialSum + " in " + sequentialTime + "ms");
        
        startTime = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
            .mapToLong(Integer::longValue)
            .sum();
        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("Parallel sum: " + parallelSum + " in " + parallelTime + "ms");
        
        // Parallel stream creation
        System.out.println("\n--- Parallel Stream Creation ---");
        Stream.of("A", "B", "C", "D")
            .parallel()
            .forEach(System.out::print);
        System.out.println();
        
        // Parallel with custom thread pool
        System.out.println("\n--- Custom Thread Pool ---");
        // Note: This is a simplified example. In practice, you'd use ForkJoinPool
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");
        names.parallelStream()
            .map(name -> {
                System.out.println("Processing " + name + " on " + Thread.currentThread().getName());
                return name.toUpperCase();
            })
            .collect(Collectors.toList());
        
        // Parallel considerations
        System.out.println("\n--- Parallel Considerations ---");
        List<Integer> parallelNumbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Order may not be preserved in parallel streams
        System.out.println("Sequential order:");
        parallelNumbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.println("Parallel order (may vary):");
        parallelNumbers.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // forEachOrdered preserves order even in parallel
        System.out.println("Parallel forEachOrdered:");
        parallelNumbers.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * Demonstrates Optional with streams
     */
    private static void demonstrateOptionalStreams() {
        System.out.println("7. OPTIONAL WITH STREAMS");
        System.out.println("========================");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve");
        
        // Optional with findFirst
        System.out.println("\n--- Optional with findFirst ---");
        Optional<String> firstLongName = names.stream()
            .filter(name -> name.length() > 5)
            .findFirst();
        
        firstLongName.ifPresent(name -> System.out.println("Found: " + name));
        firstLongName.orElse("No long name found");
        
        // Optional with map and flatMap
        System.out.println("\n--- Optional with map and flatMap ---");
        Optional<String> result = names.stream()
            .filter(name -> name.startsWith("A"))
            .findFirst()
            .map(String::toUpperCase)
            .flatMap(name -> Optional.of("Hello " + name));
        
        result.ifPresent(System.out::println);
        
        // Optional with orElseGet
        System.out.println("\n--- Optional with orElseGet ---");
        String name = names.stream()
            .filter(n -> n.startsWith("Z"))
            .findFirst()
            .orElseGet(() -> "Default Name");
        System.out.println("Name: " + name);
        
        // Optional with orElseThrow
        System.out.println("\n--- Optional with orElseThrow ---");
        try {
            String foundName = names.stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Name not found"));
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Stream of Optionals
        System.out.println("\n--- Stream of Optionals ---");
        List<Optional<String>> optionals = Arrays.asList(
            Optional.of("Alice"),
            Optional.empty(),
            Optional.of("Bob"),
            Optional.empty(),
            Optional.of("Charlie")
        );
        
        List<String> presentValues = optionals.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
        System.out.println("Present values: " + presentValues);
        
        // Using flatMap to handle Optionals
        List<String> flatMappedValues = optionals.stream()
            .flatMap(opt -> opt.stream())
            .collect(Collectors.toList());
        System.out.println("Flat mapped values: " + flatMappedValues);
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom collectors
     */
    private static void demonstrateCustomCollectors() {
        System.out.println("8. CUSTOM COLLECTORS");
        System.out.println("====================");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Custom collector to join with custom separator
        System.out.println("\n--- Custom String Joiner ---");
        String customJoined = names.stream()
            .collect(CustomCollectors.joiningWithSeparator(" | "));
        System.out.println("Custom joined: " + customJoined);
        
        // Custom collector to find min and max
        System.out.println("\n--- Custom MinMax Collector ---");
        MinMaxResult<Integer> minMax = numbers.stream()
            .collect(CustomCollectors.minMax(Comparator.naturalOrder()));
        System.out.println("Min: " + minMax.getMin() + ", Max: " + minMax.getMax());
        
        // Custom collector to group by multiple criteria
        System.out.println("\n--- Custom Multi-Grouping ---");
        Map<String, List<String>> multiGrouped = names.stream()
            .collect(CustomCollectors.groupingByMultiple(
                name -> name.length() > 4 ? "Long" : "Short",
                name -> name.startsWith("A") ? "A" : "Other"
            ));
        System.out.println("Multi-grouped: " + multiGrouped);
        
        // Custom collector with statistics
        System.out.println("\n--- Custom Statistics Collector ---");
        NameStatistics stats = names.stream()
            .collect(CustomCollectors.nameStatistics());
        System.out.println("Name statistics: " + stats);
        
        System.out.println();
    }
    
    /**
     * Demonstrates stream performance considerations
     */
    private static void demonstrateStreamPerformance() {
        System.out.println("9. STREAM PERFORMANCE");
        System.out.println("=====================");
        
        List<Integer> numbers = IntStream.range(1, 100001).boxed().collect(Collectors.toList());
        
        // Lazy evaluation
        System.out.println("\n--- Lazy Evaluation ---");
        Stream<Integer> lazyStream = numbers.stream()
            .filter(n -> {
                System.out.println("Filtering: " + n);
                return n % 2 == 0;
            })
            .map(n -> {
                System.out.println("Mapping: " + n);
                return n * n;
            });
        
        System.out.println("Stream created (no processing yet)");
        lazyStream.limit(3).forEach(System.out::println);
        
        // Short-circuit operations
        System.out.println("\n--- Short-Circuit Operations ---");
        boolean anyMatch = numbers.stream()
            .anyMatch(n -> {
                System.out.println("Checking: " + n);
                return n > 5;
            });
        System.out.println("Any match > 5: " + anyMatch);
        
        // Order of operations matters
        System.out.println("\n--- Operation Order ---");
        long count1 = numbers.stream()
            .filter(n -> n % 2 == 0)
            .limit(1000)
            .count();
        System.out.println("Filter then limit: " + count1);
        
        long count2 = numbers.stream()
            .limit(1000)
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("Limit then filter: " + count2);
        
        // Boxing/unboxing performance
        System.out.println("\n--- Boxing Performance ---");
        long startTime = System.currentTimeMillis();
        int sum1 = numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
        long time1 = System.currentTimeMillis() - startTime;
        System.out.println("With boxing: " + sum1 + " in " + time1 + "ms");
        
        startTime = System.currentTimeMillis();
        int sum2 = numbers.stream()
            .mapToInt(n -> n)
            .sum();
        long time2 = System.currentTimeMillis() - startTime;
        System.out.println("Without boxing: " + sum2 + " in " + time2 + "ms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates practical examples
     */
    private static void demonstratePracticalExamples() {
        System.out.println("10. PRACTICAL EXAMPLES");
        System.out.println("======================");
        
        // Example 1: Word frequency counter
        System.out.println("\n--- Word Frequency Counter ---");
        String text = "the quick brown fox jumps over the lazy dog the fox is quick";
        Map<String, Long> wordFrequency = Arrays.stream(text.split("\\s+"))
            .collect(Collectors.groupingBy(
                String::toLowerCase,
                Collectors.counting()
            ));
        
        wordFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        
        // Example 2: Employee management
        System.out.println("\n--- Employee Management ---");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 75000),
            new Employee("Bob", "Sales", 65000),
            new Employee("Charlie", "Engineering", 80000),
            new Employee("Diana", "Marketing", 70000),
            new Employee("Eve", "Engineering", 90000)
        );
        
        // Average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        System.out.println("Average salary by department: " + avgSalaryByDept);
        
        // Top 3 highest paid employees
        List<Employee> top3 = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Top 3 employees: " + top3);
        
        // Example 3: Data validation
        System.out.println("\n--- Data Validation ---");
        List<String> emails = Arrays.asList(
            "alice@example.com",
            "invalid-email",
            "bob@example.com",
            "not-an-email",
            "charlie@example.com"
        );
        
        List<String> validEmails = emails.stream()
            .filter(email -> email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            .collect(Collectors.toList());
        System.out.println("Valid emails: " + validEmails);
        
        // Example 4: Batch processing
        System.out.println("\n--- Batch Processing ---");
        List<Integer> batchNumbers = IntStream.range(1, 21).boxed().collect(Collectors.toList());
        
        AtomicInteger batchCounter = new AtomicInteger(0);
        Map<Integer, List<Integer>> batches = batchNumbers.stream()
            .collect(Collectors.groupingBy(n -> batchCounter.getAndIncrement() / 5));
        System.out.println("Batches: " + batches);
        
        // Example 5: Functional pipeline
        System.out.println("\n--- Functional Pipeline ---");
        List<String> result = Arrays.asList("apple", "banana", "cherry", "date", "elderberry")
            .stream()
            .filter(fruit -> fruit.length() > 4)
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Pipeline result: " + result);
        
        System.out.println();
    }
    
    // Helper classes for examples
    static class Employee {
        private String name;
        private String department;
        private double salary;
        
        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        
        @Override
        public String toString() {
            return name + "(" + department + ", $" + salary + ")";
        }
    }
    
    static class MinMaxResult<T> {
        private final T min;
        private final T max;
        
        public MinMaxResult(T min, T max) {
            this.min = min;
            this.max = max;
        }
        
        public T getMin() { return min; }
        public T getMax() { return max; }
        
        @Override
        public String toString() {
            return "Min: " + min + ", Max: " + max;
        }
    }
    
    static class NameStatistics {
        private final int totalCount;
        private final int longNameCount;
        private final double averageLength;
        private final String longestName;
        
        public NameStatistics(int totalCount, int longNameCount, double averageLength, String longestName) {
            this.totalCount = totalCount;
            this.longNameCount = longNameCount;
            this.averageLength = averageLength;
            this.longestName = longestName;
        }
        
        @Override
        public String toString() {
            return String.format("Total: %d, Long names: %d, Avg length: %.2f, Longest: %s",
                totalCount, longNameCount, averageLength, longestName);
        }
    }
    
    // Custom collectors
    static class CustomCollectors {
        public static Collector<String, ?, String> joiningWithSeparator(String separator) {
            return Collector.of(
                StringBuilder::new,
                (sb, str) -> {
                    if (sb.length() > 0) sb.append(separator);
                    sb.append(str);
                },
                (sb1, sb2) -> {
                    if (sb1.length() > 0 && sb2.length() > 0) sb1.append(separator);
                    sb1.append(sb2);
                    return sb1;
                },
                StringBuilder::toString
            );
        }
        
        public static <T> Collector<T, ?, MinMaxResult<T>> minMax(Comparator<T> comparator) {
            return Collector.of(
                () -> new Object[]{null, null},
                (acc, t) -> {
                    if (acc[0] == null || comparator.compare(t, (T) acc[0]) < 0) acc[0] = t;
                    if (acc[1] == null || comparator.compare(t, (T) acc[1]) > 0) acc[1] = t;
                },
                (acc1, acc2) -> {
                    if (acc1[0] == null) return acc2;
                    if (acc2[0] == null) return acc1;
                    T min = comparator.compare((T) acc1[0], (T) acc2[0]) <= 0 ? (T) acc1[0] : (T) acc2[0];
                    T max = comparator.compare((T) acc1[1], (T) acc2[1]) >= 0 ? (T) acc1[1] : (T) acc2[1];
                    return new Object[]{min, max};
                },
                acc -> new MinMaxResult<>((T) acc[0], (T) acc[1])
            );
        }
        
        public static <T> Collector<T, ?, Map<String, List<T>>> groupingByMultiple(
                Function<T, String> classifier1,
                Function<T, String> classifier2) {
            return Collectors.groupingBy(
                t -> classifier1.apply(t) + "|" + classifier2.apply(t)
            );
        }
        
        public static Collector<String, ?, NameStatistics> nameStatistics() {
            return Collector.of(
                () -> new Object[]{0, 0, 0.0, ""},
                (acc, name) -> {
                    acc[0] = (Integer) acc[0] + 1;
                    if (name.length() > 4) acc[1] = (Integer) acc[1] + 1;
                    acc[2] = (Double) acc[2] + name.length();
                    if (name.length() > ((String) acc[3]).length()) acc[3] = name;
                },
                (acc1, acc2) -> {
                    acc1[0] = (Integer) acc1[0] + (Integer) acc2[0];
                    acc1[1] = (Integer) acc1[1] + (Integer) acc2[1];
                    acc1[2] = (Double) acc1[2] + (Double) acc2[2];
                    if (((String) acc2[3]).length() > ((String) acc1[3]).length()) acc1[3] = acc2[3];
                    return acc1;
                },
                acc -> new NameStatistics(
                    (Integer) acc[0],
                    (Integer) acc[1],
                    (Double) acc[2] / (Integer) acc[0],
                    (String) acc[3]
                )
            );
        }
    }
} 