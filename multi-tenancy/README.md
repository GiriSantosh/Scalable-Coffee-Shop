1. Pass your .env values to kubernetes using `kubectl create secret generic mysql-tenant-env --from-env-file=.env` command.
2. Run your `mysql-pv-claim.yaml` and `mysql-deployment.yaml` file. It would run successfully
3. login using root and run below commands to create 2 tenant dBs

`CREATE DATABASE eventuate_a;`
`CREATE DATABASE eventuate_b;`

### Create a user for tenant A
`CREATE USER 'eventuate_a'@'%' IDENTIFIED BY 'eventuate@A';`

### Grant privileges on the eventuate_a database
`GRANT ALL PRIVILEGES ON eventuate_a.* TO 'eventuate_a'@'%';`

-- Create a user for tenant B
`CREATE USER 'eventuate_b'@'%' IDENTIFIED BY 'eventuate@B';`

-- Grant privileges on the eventuate_b database
`GRANT ALL PRIVILEGES ON eventuate_b.* TO 'eventuate_b'@'%';`

-- Apply changes
FLUSH PRIVILEGES;

SHOW DATABASES;
SHOW GRANTS FOR 'eventuate_a'@'%';
SHOW GRANTS FOR 'eventuate_b'@'%';


## Deploying Beanservice

- `kubectl create configmap java-config --from-literal=JAVA_OPTS="-Xmx256m --add-opens java.base/java.lang=ALL-UNNAMED"`
- `kubectl apply -f tenant-config-a.yaml`
- `kubectl apply -f tenant-secret-a.yaml`
- `kubectl apply -f beanservice-deployment.yaml`
  - Make sure to build your image using `docker build -t scalable-coffee-shop-beanservice:1.1 ./BeanEvntSrc`
  - If you're using `microk8s` then make sure to upload local docker images using command 
    - `docker save scalable-coffee-shop-beanservice:1.1 > bean.tar`
    - `microk8s ctr image import bean.tar`
- `kubectl apply -f orderservice-deployment.yaml`
  - Make sure to build, `docker build -t scalable-coffee-shop-orderservice:1.0 ./OrderEvntSrc`
- `kubectl apply -f tenant-ingress.yaml`


## To Delete Minikube