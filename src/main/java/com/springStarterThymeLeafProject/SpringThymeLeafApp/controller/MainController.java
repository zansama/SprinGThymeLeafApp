package com.springStarterThymeLeafProject.SpringThymeLeafApp.controller;

import java.util.ArrayList;
import java.util.List;

import com.springStarterThymeLeafProject.SpringThymeLeafApp.form.CarForm;
import com.springStarterThymeLeafProject.SpringThymeLeafApp.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
public class MainController {

    private static List<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car("A4", "Audi", "2011"));
        cars.add(new Car("M3", "BMW", "2018"));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String carList(Model model) {

        model.addAttribute("cars", cars);

        return "carList";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = { "/addcar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    /**
     * @param model
     * @param carForm
     * @return
     */
    @RequestMapping(value = { "/addcar" }, method = RequestMethod.POST)
    public String saveCar(Model model, //
                             @ModelAttribute("carForm") CarForm carForm) {

        String name = carForm.getName();
        String brand = carForm.getBrand();
        String year = carForm.getYear();

        if (name != null && name.length() > 0 //
                && brand != null && brand.length() > 0
                && year != null && year.length() > 0) {
            Car newCar = new Car(name, brand, year);
            cars.add(newCar);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

}