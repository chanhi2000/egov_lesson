package com.hr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("main/main.do")
    public String hello(Model model ) {
        model.addAttribute("msg", "Hello Spring Web!");

        LOG.debug("----------------------");
        LOG.debug("HelloController.hello calling");
        LOG.debug("------------------------------------------");
        /**
         * <beans:property name="prefix" value="/" />
         * <beans:property name="suffix" value=".jsp" />
         * /main.jsp
         */
        return "main";
    }
}
