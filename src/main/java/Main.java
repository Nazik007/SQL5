import java.io.IOException;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        List<MaxProjectCountClient> maxProjectCountClients = databaseQueryService.findMaxProjectsClient();
        maxProjectCountClients.forEach(System.out::println);

        List<LongestProject> longestProjects = databaseQueryService.findLongestProject();
        System.out.println("longestProjects = " + longestProjects);

        List<MaxSalaryWorker> maxSalaryWorkers = databaseQueryService.findMaxSalaryWorker();
        System.out.println("maxSalaryWorkers = " + maxSalaryWorkers);

        List<YoungestEldestWorker> youngestEldestWorkers = databaseQueryService.findYoungestEldestWorkers();
        youngestEldestWorkers.forEach(System.out::println);

        List<ProjectPrice> projectPrices = databaseQueryService.printProjectPrices();
        projectPrices.forEach(System.out::println);
    }
}
