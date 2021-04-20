package org.springframework.mytest;

import org.springframework.stereotype.Component;

/**
 * @author Lien6o
 */
@Component
public class EatService {

    public String eat() {
        return "eat() execute";
    }
}
