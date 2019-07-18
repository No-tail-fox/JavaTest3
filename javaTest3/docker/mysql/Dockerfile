FROM registry.saas.hand-china.com/tools/mysql:5.6
   
RUN yum install -y mysql-server mysql  
   
RUN /etc/init.d/mysqld start &&\  
    mysql -e "grant all privileges on *.* to 'root'@'%' identified by 'letmein';"&&\  
    mysql -e "grant all privileges on *.* to 'root'@'localhost' identified by 'letmein';"&&\  
    mysql -u root -pletmein -e "show databases;"  
   
EXPOSE 3306  
   
CMD ["/usr/bin/mysqld_safe"] 