#### Stage 1
FROM node as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . ./
ARG configuration=production
RUN npm run build -- --outputPath=./dist/dari-tn --configuration $configuration
#### Stage 2
FROM nginx
COPY --from=build /app/dist/dari-tn/ /usr/share/nginx/html
COPY /nginx-custom.conf /etc/nginx/conf.d/default.conf
EXPOSE 80 
ENTRYPOINT ["nginx","-g","daemon off;"]