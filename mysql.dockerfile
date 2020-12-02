FROM mysql:5.7

LABEL Author="Savinov Viktor", Version=0.1

RUN service mysql start && \

    mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "CREATE DATABASE vysavinov" && \

    mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "CREATE USER 'vysavinov'@'%' identified by 'vysavinov';" && \

    mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "GRANT ALL ON vysavinov.* TO 'vysavinov'@'%' IDENTIFIED BY 'vysavinov'; FLUSH PRIVILEGES"


ENV MYSQL_ROOT_PASSWORD=root \
       MYSQL_USER=vysavinov \
       MYSQL_PASSWORD=vysavinov \
       MYSQL_DATABASE=vysavinov