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

     1. SQL Transaction log lsn
1.1. @Transactional(propagation = REQUIRED, SUPPORTS, MANDATORY, REQUIRES_NEW, NOT_SUPPORTED, NEVER, NESTED)
1.2. @Transactional(isolation = DEFAULT, READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE)
1.3. DB Buffer, Suspension

     2. Proxy
2.1. @PersistenceContext(type = TRANSACTION, EXTENDED)
2.2. Spring proxy JDK and CGLIB

     3. N+1
3.1. @Fetch(SELECT, JOIN, SUBSELECT), @BatchSize(size = 20)
3.2. JOIN FETCH
3.3. Repository.findAll()

     4. Developing
4.1. DTO, ModelMapper
4.2. Repository == RepositoryDefinition(domainClass, idClass)
4.3. SpringData findBy...
4.4. Slice, Pageable
4.5. CriteriaBuilder, QueryDSL -> QuerydslPredicateExecutor
4.6. PersistenceContext, ((SessionImpl) entityManager.getDelegate()).persistenceContext > 5k
4.7. FlashClear Antipattern
4.8. @Lock(READ, WRITE, OPTIMISTIC, OPTIMISTIC_FORCE_INCREMENT, PESSIMISTIC_READ, PESSIMISTIC_WRITE,
               PESSIMISTIC_FORCE_INCREMENT, NONE)


Question list
1. @Transactional NESTED
2. Hibernate Cache #1
3. LazyInitializationException
4. N+1
5. Optimistic and pessimistic lock
6. 
7. 
