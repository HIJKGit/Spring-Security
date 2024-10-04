FROM postgres:alpine

ENV POSTGRES_USER=vin
ENV POSTGRES_PASSWORD=password

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432