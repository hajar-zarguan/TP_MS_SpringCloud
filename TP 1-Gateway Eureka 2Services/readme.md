# TP Eureka ![Java](https://img.shields.io/badge/-Java-333333?style=flat&logo=Java&logoColor=007396) ![SpringBoot](https://img.shields.io/badge/-Spring%20Boot-333333?style=flat&logo=spring-boot)

## 🔗 La démonstration video est disponible sur YOUTUBE
[Part 1](https://www.youtube.com/watch?v=fqfg3sNIDDk)

[Part 2](https://www.youtube.com/watch?v=0MG8akH6cfU)

[Part 3](https://www.youtube.com/watch?v=npP2GLYLW8c)


## 1. Les notions et les techniques 
Les notions et les techniques que nous avons pratiqué dans cette activité 
- Eureka server

<a href="https://getbootstrap.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a>



## 2. Travail à faire :
### Suivre les videos Bonnes pratiques de Architectures micro-services :

 I. Mise en oeuvre d'une application distribuée basée sur deux micro-services en utilisant les bonnes pratiques  :
 
 
  - Couches DA0, Service, Web, DTO

Customer service 

![image](https://user-images.githubusercontent.com/82539023/198901280-d0bdde39-4eb7-4b21-a114-550ba20bbf99.png)

Billing service

![image](https://user-images.githubusercontent.com/82539023/198901400-5a662a9c-7df7-4922-87d6-646dac0dbaf5.png)


  
  - Utilisation de MapStruct pour le mapping entre les objet Entities et DTO
  
Customer service

![image](https://user-images.githubusercontent.com/82539023/198901309-cda3ebdd-15ca-4ffc-a65b-d0f5e16eb914.png)

Billing service

![image](https://user-images.githubusercontent.com/82539023/198901421-ac3480b5-07eb-44ae-9b8c-07013092e7be.png)


  - Génération des API-DOCS en utilisant SWAGGER3 (Open API)
  
  
  - Communication entre micro-services en utilisant OpenFeign
  
  in Billing service 
  @FeignClient(name = "CUSTOMER-SERVICE")
  
  ![image](https://user-images.githubusercontent.com/82539023/198901515-adc9ac3d-a0e9-4194-b3b6-cf0542ef84e6.png)
 
  @EnableFeignClients
  
  ![image](https://user-images.githubusercontent.com/82539023/198901554-187a5fc3-1fd0-4acc-a457-dbba08ed83d2.png)


 
  - Spring Cloud Gateway
  
![image](https://user-images.githubusercontent.com/82539023/198901628-f305c38e-7223-4f0f-bfb5-d82c295b50a3.png)
![image](https://user-images.githubusercontent.com/82539023/198901639-431b8454-6784-460a-8941-865ecb55f34b.png)



  
  - Eureka Discovery Service
  
![image](https://user-images.githubusercontent.com/82539023/198901669-be33f884-5576-4b56-a798-41810fa598c3.png)

Config in Customer service 



![image](https://user-images.githubusercontent.com/82539023/198901733-cbfb7979-1900-4275-a449-81dc115cf4e0.png)


Config in Billing service

![image](https://user-images.githubusercontent.com/82539023/198901714-92c5ecb6-58fb-4edc-973c-5bc0da5b1f87.png)

![image](https://user-images.githubusercontent.com/82539023/198902485-04996e78-8d15-4561-862b-b0aad7f864e2.png)


Customer Service 

![image](https://user-images.githubusercontent.com/82539023/198905594-98fbe21c-b8b9-4f91-b918-07570475abe2.png)

Billing Service
![image](https://user-images.githubusercontent.com/82539023/198906133-65fae550-dfd2-4fa7-8dc3-b3649fa0686b.png)


Eureka 

![image](https://user-images.githubusercontent.com/82539023/198905906-c6355092-1e53-46bc-99fd-eb669b853b6b.png)


Gateway

![image](https://user-images.githubusercontent.com/82539023/198905887-70d380b4-228d-42ec-a076-2a60b53c7c89.png)




Les images docker

![image](https://user-images.githubusercontent.com/82539023/198906329-762d2c6d-040a-420b-8c2a-f25204210980.png)

Run

![image](https://user-images.githubusercontent.com/82539023/198906390-0ec85510-c10b-4bf1-9b55-4d9a8089167e.png)

