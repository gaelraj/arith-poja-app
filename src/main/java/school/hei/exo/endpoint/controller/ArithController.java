package school.hei.exo.endpoint.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.exo.service.ArithService;

@RestController
@AllArgsConstructor
public class ArithController {

    private ArithService arithService;

    @GetMapping("/add")
    public double add(@RequestParam("a") double a,
                      @RequestParam("b") double b) {
        return arithService.add(a, b);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam("a") double a,
                           @RequestParam("b") double b) {
        return arithService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam("a") double a,
                           @RequestParam("b") double b) {
        return arithService.multiply(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam("a") double a,
                         @RequestParam("b") double b) {
        return arithService.divide(a, b);
    }

}
