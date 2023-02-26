---------Echo service----------

docker build --tag=spatnaik77/echo-service:latest .

docker run -p8080:8080 spatnaik77/echo-service

docker push spatnaik77/echo-service:latest

--------Microk8s cluster--------

microk8s kubectl apply -f /Users/siddharthpatnaik/Documents/siddharth/mygithub/argo-cd-poc/echo-service-k8s-config/deployment-service.yaml

microk8s kubectl port-forward service/echo-service 8080:8080

-------Argo CD-------------------

microk8s kubectl create namespace argocd

microk8s kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

