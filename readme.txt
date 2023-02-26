---------Echo service----------

docker build --tag=spatnaik77/echo-service:latest .

docker run -p8080:8080 spatnaik77/echo-service

docker push spatnaik77/echo-service:latest

--------Microk8s cluster--------

microk8s kubectl apply -f /Users/siddharthpatnaik/Documents/siddharth/mygithub/argo-cd-poc/echo-service-k8s-config/deployment-service.yaml

microk8s kubectl port-forward service/echo-service 8080:8080

-------Argo CD-------------------

kubectl create namespace argocd

kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

kubectl port-forward svc/argocd-server -n argocd 8080:443

Access the UI - http://localhost:8080
User name : admin
password : result of the command - kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d

Create an application






