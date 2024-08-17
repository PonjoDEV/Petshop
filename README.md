Docker compose with more than 1 microservice 

  docker-compose up --scale msclient=2 --scale msanimal=2
  Calling for 2 instances of the animal and client microservices

To run each container separatedly 
  docker ps -a 
  to list all containers
  
  docker images
  to list the images installed on the machine

  docker run {image ID}



Still need a way to verify the log and check if both instances are registering