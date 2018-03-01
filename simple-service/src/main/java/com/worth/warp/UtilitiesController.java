package com.worth.warp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/utilities")
public class UtilitiesController {

    private static final Log LOG = LogFactory.getLog(UtilitiesController.class);

    Utilities utilities = new Utilities();

    @GetMapping
    public String utilities() {
        LOG.info("Calling utilities");
        return utilities.somethingUseful();
    }
}
