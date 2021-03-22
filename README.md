# KLEIO_BE
Back end code for KLEIO

* Push code to docker hub  
```mvn clean package dockerfile:push```

* Connect to server  
```ssh -i "KleioServerKey.pem" ec2-user@ec2-54-81-254-195.compute-1.amazonaws.com```

* Start services
  * Update all packages (-y means "Assume yes if prompt")  
  ```sudo yum update -y``` 
  
  * Start docker  
  ```sudo systemctl docker start```
  
  * Go to ```docker-compose.yml``` file  
  ```cd /opt/kleio/app```
  
  * Change the yml file if needed  
  ```sudo vi docker-compose.yml```
  
  * Pull the latest code to docker  
  ```sudo docker-compose pull kleio```
  
  * Start the service (-d means "Start the service in background")  
  ```sudo docker-compsoe up -d```
  
  * See logs of the server  
  ```sudo docker-compose logs```
