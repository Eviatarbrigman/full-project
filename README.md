in this project is a Java Quiz application designed using a microservices architecture.


It consists of independent services including :
Quiz Service: https://github.com/Eviatarbrigman/quiz-service
Question Service: https://github.com/Eviatarbrigman/question-service
Eureka service: https://github.com/Eviatarbrigman/quiz-question-registry-service
api-gateway service: https://github.com/Eviatarbrigman/quiz-question-api-gateway


These services manage specific functionalities related to quizzes and questions 
and are stored in a Postgres database. I used Spring Cloud technologies such as Feign Client,
Eureka, and API Gateway for service discovery, client-side load balancing, and inter-service communication. 
