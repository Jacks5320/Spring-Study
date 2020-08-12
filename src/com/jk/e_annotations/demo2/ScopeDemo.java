package com.jk.e_annotations.demo2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class ScopeDemo {
}
