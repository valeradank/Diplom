# Инструкция по запуску тестов:

1. Перед тем как открыть проект запускаем docker desktop
2. в Doсker включаем PostgreSQL
3. открываем проект в IDEA
4. открываем теминал и пишем docker compose up
5. в файле application properties убрать символ # перед spring.datasource.url=jdbc:mysql://localhost:3306/app и
   поставить символ # перед spring.datasource.url=jdbc:postgresql://localhost:5432/app
6. в build gradle убрать символы // перед systemProperty 'db.url', System.getProperty('db.url', 'jdbc:mysql://localhost:
   3306/app') и поставить их перед systemProperty 'source', System.getProperty('source', 'jdbc:postgresql://localhost:
   5432/app')
7. открыаем новый терминал и пишем java -jar aqa-shop.jar "- Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-
   Dspring.datasource.username=app" "-Dspring.datasource.password=pass"
8. открываем новый терминал и пишем ./gradlew test "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dsp
   ring.datasource.username=app" "-Dspring.datasource.password=pass"
9. для запуска на postgre :поставить # перед spring.datasource.url=jdbc:mysql://localhost:3306/app и в build gradle
   //systemProperty 'db.url', System.getProperty('db.url', 'jdbc:mysql://localhost:3306/app')

10. написать в терминале java -jar aqa-shop.jar "- Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" "-
   Dspring.datasource.username=app" "-Dspring.datasource.password=pass"

11. запуск тестов ./gradlew test "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" "-Dsp
    ring.datasource.username=app" "-Dspring.datasource.password=pass"

12. открываем новый терминал и пишем ./gradlew allureServe
