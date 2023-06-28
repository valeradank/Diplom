FROM node:14


WORKDIR /app


COPY gate-simulator/app.js .


RUN npm install


COPY . .


EXPOSE 9999


CMD ["node", "app.js"]
WORKDIR /app