package com.tbe.rest;


import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorRest implements ErrorController {

    @RequestMapping(value = "/error")
    public String notFound() {
        return "/resources/404.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
