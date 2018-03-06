package com.worth.warp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/simple")
public class SimpleController {

    private static final Log LOG = LogFactory.getLog(SimpleController.class);


    @GetMapping
    public String hello() {
        LOG.info("Saying hello");
        return "hello";
    }
}
