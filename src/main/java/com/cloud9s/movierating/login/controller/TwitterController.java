package com.cloud9s.movierating.login.controller;

import java.util.Base64;
import javax.inject.Inject;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author abdalla
 */
@Controller
public class TwitterController {

    private Twitter twitter;
    private ConnectionRepository connectionRepository;

    @Inject
    public TwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/twitter")
    public ModelAndView twitterController() {
        ModelAndView model = new ModelAndView();
        model.setViewName("connect/twitterProfile");
        if (connectionRepository.findPrimaryConnection(Twitter.class) != null) {
            model.addObject("twitterProfile", twitter.userOperations().getUserProfile());
        }

        return model;
    }
}
