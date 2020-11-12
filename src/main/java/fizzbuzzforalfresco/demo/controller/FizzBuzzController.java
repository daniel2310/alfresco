package fizzbuzzforalfresco.demo.controller;

import fizzbuzzforalfresco.demo.dto.Range;
import fizzbuzzforalfresco.demo.service.FizzBuzzService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

    private final FizzBuzzService service;

    public FizzBuzzController(FizzBuzzService service) {
        this.service = service;
    }

    @PostMapping(path = "/firstSolution", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postFirstSolution(@RequestBody Range range) {
        service.firstSolution(range);
        return ResponseEntity.ok(service.getResult());
    }

    @PostMapping(path = "/secondSolution", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postSecondSolution(@RequestBody Range range) {
        service.secondSolution(range);
        return ResponseEntity.ok(service.getResult());
    }
}
