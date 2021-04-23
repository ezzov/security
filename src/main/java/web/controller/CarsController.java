package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarsController {

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Pagani", "Huayra Tricolore", 5.5));
        carList.add(new Car("Bugatti", "Chiron Pur Sport", 3.6));
        carList.add(new Car("Lamborghini", "Sian FKP 37", 3.6));
        carList.add(new Car("Aston Martin", "Valkyrie", 3.0));
        carList.add(new Car("Koenigsegg", "Jesko", 2.8));

        if(count == null || count > 4) {
            model.addAttribute("carList", carList);
        }  else {
            model.addAttribute("carList", carList.stream().limit(count).collect(Collectors.toList()));
        }

        return "cars";
    }
}
