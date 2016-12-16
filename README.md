Magnolia - A complete open source e-commerce solution for Grails.
---

## Install Grails
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java
sdk install gradle
sdk install grails
grails -version
```

## Starting
```bash
git clone https://github.com/kapmahc/magnolia.git
cd magnolia
grails run-app
```
## Editor plugins
- [atom-grails](https://atom.io/packages/atom-grails)

## Deployment
```bash
cd magnolia
grails war
java -Dgrails.env=prod -jar build/libs/magnolia-grails-0.1.war -server -Xmx768M -XX:MaxPermSize=256m
```

## Notes
```bash
grails run-app                                  # start 
grails grails create-app --inplace              # create project
grails create-domain-class org.bookstore.Book   # create model
grails create-controller org.bookstore.book     # create controller
grails clean
grails war
```

## Documents
- [Grails](http://docs.grails.org/latest/)
