# Инструкция по запуску тестов:
1. Перед тем как открыть проект запускаем docker desktop
2. в Doсker включаем PostgreSQL
3. открываем проект в IDEA
4. открываем теминал и пишем docker compose up
5. открыаем новый терминал и пишем java -jar aqa-shop.jar "- Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "- Dspring.datasource.username=app" "-Dspring.datasource.password=pass"
6. открываем новый терминал и пишем ./gradlew  test "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dsp
   ring.datasource.username=app" "-Dspring.datasource.password=pass"
7. открываем новый терминал и пишем ./gradlew allureServe
