# argo-cd-poc

## Setup the echo service

* Echo-service is used as the sample service
* Build the service : mvn clean install
* Create a docker image : docker build --tag=spatnaik77/echo-service:latest .
* Run the docker image locally to verify : docker run -p8080:8080 spatnaik77/echo-service
* Test : curl localhost:8080/siddharth --> You should see hello siddharth
* Publish the image to docker registry : docker push spatnaik77/echo-service:latest

## Setup local k8s cluster
* I used docker desktop for the local cluster
* Deploy echo-service to the cluster : kubectl apply -f echo-service-k8s-config/deployment-service.yaml
* Check service status : kubectl get svc <br>
NAME           TYPE        CLUSTER-IP    EXTERNAL-IP   PORT(S)    AGE <br>
echo-service   ClusterIP   10.96.4.229   <none>        8080/TCP   11h <br>
kubernetes     ClusterIP   10.96.0.1     <none>        443/TCP    301d <br>
siddharthpatnaik@SPATNAIKLAPTOP ~ % kubectl get pods <br>
NAME                            READY   STATUS    RESTARTS   AGE <br>
echo-service-5b6f77df75-d6b2c   1/1     Running   0          11h <br>
* Portforward the service to access : kubectl port-forward service/echo-service 8080:8080
* Test the service : curl localhost:8080/siddharth --> You should see hello siddharth

## Setup Argocd in the cluster
* kubectl create namespace argocd
* kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
* kubectl port-forward svc/argocd-server -n argocd 8080:443
* Access the UI - http://localhost:8080
** User name : admin
** password : result of the command - kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
* Create an application. point the echo-service-k8s-config folder for the configuration

## Final test
* Go and update the number of replicas to 3 in deployment-service.yaml
* Now argocd should automatically detect this change and apply the configuration in cluster. As a result now u will see 3 pods of echo service


