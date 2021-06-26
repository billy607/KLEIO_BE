# KLEIO_BE
Back end code for KLEIO

* Install docker and docker compose
  * Install docker  
  ```sudo yum install docker```
  * Install docker compose  
  ```sudo curl -L "https://github.com/docker/compose/releases/download/1.29.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose```  
  ```sudo chmod +x /usr/local/bin/docker-compose```  
  ```sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose```  

* Push code to docker hub  
```mvn clean package dockerfile:push```

* Connect to server  
```ssh -i "kleio.pem" ec2-user@ec2-54-174-141-206.compute-1.amazonaws.com```

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
  ```sudo docker-compsoe up -d kleio```
  
  * See logs of the server  
  ```sudo docker-compose logs```
