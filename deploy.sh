kubectl apply -f ./k8s/createNameSpace.yaml
kubectl apply -f ./k8s/configmap.yaml
kubectl apply -f ./k8s/secrets.yaml
kubectl apply -f ./k8s/postgres-pv.yaml
kubectl apply -f ./k8s/postgres-pvc.yaml

kubectl apply -f ./k8s/postgres-deployment.yaml
kubectl apply -f ./k8s/postgres-service.yaml
kubectl apply -f ./k8s/employee-deployment.yaml
kubectl apply -f ./k8s/employee-service.yaml
kubectl apply -f ./k8s/department-deployment.yaml
kubectl apply -f ./k8s/department-service.yaml
kubectl apply -f ./k8s/organization-deployment.yaml
kubectl apply -f ./k8s/organization-service.yaml
kubectl apply -f ./k8s/gateway-deployment.yaml
kubectl apply -f ./k8s/gateway-service.yaml