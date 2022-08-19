# stage 1
FROM node as build-stage
WORKDIR /app
COPY package*.json /app/
RUN npm install --legacy-peer-deps
COPY ./ /app/
ARG configuration=production
RUN npm run build -- --output-path=./dist/dari-tn --configuration $configuration
# stage 2
FROM nginxinc/nginx-unprivileged
COPY --from=build-stage /app/dist/dari-tn /usr/share/nginx/html
EXPOSE 80
CMD [ "nginx","-g","daemon off;" ]