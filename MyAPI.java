
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyAPI {

    @PostMapping("/processArray")
    public ApiResponse processArray(@RequestBody Integer[] arr) {

        ApiResponse response = new ApiResponse();
        response.setStatus("success");
        response.setUserId(1234);
        response.setEmailId("example@example.com");
        response.setCollegeRollNumber("ABC123");

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<String> uppercaseAlphabets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenNumbers.add(arr[i]);
            } else {
                oddNumbers.add(arr[i]);
            }

            if (Character.isLetter(arr[i])) {
                uppercaseAlphabets.add(String.valueOf(arr[i]).toUpperCase());
            }
        }

        response.setEvenNumbers(evenNumbers.toArray(new Integer[evenNumbers.size()]));
        response.setOddNumbers(oddNumbers.toArray(new Integer[oddNumbers.size()]));
        response.setUppercaseAlphabets(uppercaseAlphabets.toArray(new String[uppercaseAlphabets.size()]));

        return response;
    }

    public class ApiResponse {

        private String status;
        private int userId;
        private String emailId;
        private String collegeRollNumber;
        private Integer[] evenNumbers;
        private Integer[] oddNumbers;
        private String[] uppercaseAlphabets;

        // getters and setters omitted for brevity

    }

    public static void main(String[] args) {
        SpringApplication.run(MyAPI.class, args);
    }

}
