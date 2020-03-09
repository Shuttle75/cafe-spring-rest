package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.Bill;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping("/api/appcontext")
public class AppContextController {

    @Autowired
    private ApplicationContext appContext;

    @GetMapping
    public List<List<String>> getAppContextAdvices() {


        return Stream.of(appContext.getBeanDefinitionNames())
            .filter(s -> appContext.getBean(s) instanceof Advised)
            .map(s -> Stream.of(((Advised) appContext.getBean(s)).getAdvisors())
                .map(advisor -> {
                    if (advisor instanceof BeanFactoryTransactionAttributeSourceAdvisor) {
                        return advisor.getAdvice().toString() + " order " + ((BeanFactoryTransactionAttributeSourceAdvisor) advisor).getOrder();
                    }
                    if (advisor instanceof DefaultPointcutAdvisor) {
                        return advisor.getAdvice().toString() + " order " + ((DefaultPointcutAdvisor) advisor).getOrder();
                    }
                    return null;
                })
                .collect(Collectors.toList()))
            .collect(Collectors.toList());
    }
}
