Magnolia - A complete open source e-commerce solution for Ruby on Rails.
---

* Deploy
```bash
gradle build
ls -l build/libs
```

* Config file orders
```
application-{profile}.properties
application.properties
```
```

```

* Database
```
gradle flywayMigrate -Dflyway.url=... -Dflyway.user=... -Dflyway.password=...

gradle flywayMigrate -i
gradle flywayClean
gradle flywayInfo
```

* Test
```
gradle test
firefox build/reports/tests/test/index.html
```

* Documents
- http://mvnrepository.com/
- http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
- https://flywaydb.org/documentation/gradle/
- https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98