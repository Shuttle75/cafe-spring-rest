# REST version of Spring Cafe Sample Application 

This backend version of the Spring Cafe application only provides a REST API. There is no UI.
The [spring-cafe-angular2 project](https://github.com/Shuttle75/cafe-angular) is a front-end application witch consumes the REST API.


## Running Spring Cafe locally
```
	git clone https://github.com/Shuttle75/cafe-spring-rest.git
	cd cafe-spring-rest
	./mvnw spring-boot:run
```

You can then access Spring Cafe here: http://localhost:8080/

## Swagger REST API documentation presented here:
http://localhost:8080/swagger-ui.html

1. @PersistenceContext(type=TRANSACTION, EXTENDED)
2. Spring proxy JDK and CGLIB
3. @Transactional(propagation=REQUIRED,SUPPORTS,MANDATORY,REQUIRES_NEW,NOT_SUPPORTED,NEVER,NESTED)
4. @Transactional(isolation=DEFAULT,READ_UNCOMMITTED,READ_COMMITTED,REPEATABLE_READ,SERIALIZABLE)
5. @Fetch(SELECT,JOIN,SUBSELECT), @BatchSize(size=20), JOIN FETCH, Repository.findAll()
6. PersistenceContext, ((SessionImpl) entityManager.getDelegate()).persistenceContext > 5k

