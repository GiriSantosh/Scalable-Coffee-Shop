# SB-Scalable-Coffee-Shop

Demo spring boot application with event sourcing functionality (without eventuate.io) 

### Special thanks to Sabastian Daschner (https://github.com/sdaschner)

### Quick Tips

- `minikube dashboard` To run minikube dashboard
- `minikube start --driver=docker` to run minikube with Docker as driver
- `eval $(minikube -p minikube docker-env)` To pick docker images under minikube
- `docker build -t scalable-coffee-shop-beanservice:1.1 ./BeanEvntSrc` to build image locally, must supply version
- `docker build -t scalable-coffee-shop-orderservice:1.0 ./OrderEvntSrc`
- `kubectl apply -f beanservice-deployment.yaml` make sure bean has 1.1 version
- `kubectl get pods`
- `kubectl get secret mysql-env -o yaml`
- `kubectl port-forward svc/beanservice 8080:8080` to access bean service locally.
