
FROM node:14


WORKDIR /app


COPY gate-simulator/app.js .


RUN npm install


COPY . .


EXPOSE 3306


CMD ["node", "app.js"]
WORKDIR /app

