package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("cakeFlavors", orderService.getCakeFlavors());
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping
    public ModelAndView submitOrder(@Valid Order order, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("cakeFlavors", orderService.getCakeFlavors());
            model.addAllAttributes(errors.getModel());
            return new ModelAndView("order", model.asMap());
        }
        log.info("SUBMITTED ORDER: " + order.toString());
        return new ModelAndView("order_confirm");
    }

    @PostMapping("/confirm")
    public String confirmOrder(Order order) {
        log.info("CONFIRMED ORDER: " + order.toString());
        return "redirect:/orders/complete";
    }

    @GetMapping("/complete")
    public String completeOrder() {
        return "order_complete";
    }
}