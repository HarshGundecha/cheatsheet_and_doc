- [Kubernetes](#kubernetes)
  - [What it can do](#what-it-can-do)
  - [Terminologies](#terminologies)
  - [Architecture](#architecture)
  - [Kubernetes elements](#kubernetes-elements)
    - [Master node](#master-node)
      - [Components](#components)
        - [API server](#api-server)
        - [Scheduler](#scheduler)
        - [Controller manager](#controller-manager)
        - [ETCD](#etcd)
    - [Worker node](#worker-node)
      - [Components](#components-1)
        - [Kubelet](#kubelet)
        - [Kube-proxy](#kube-proxy)
        - [Container runtime](#container-runtime)
    - [Addons](#addons)
  - [Features](#features)
    - [Automatic bin packing](#automatic-bin-packing)
    - [Service discovery & load balancing](#service-discovery--load-balancing)
    - [Storage orchestration](#storage-orchestration)
    - [Self healing - by replication controller](#self-healing---by-replication-controller)
    - [Automated rollouts & rollbacks](#automated-rollouts--rollbacks)
    - [Secret & config. management](#secret--config-management)
    - [Batch execution](#batch-execution)
    - [Horizontal scaling](#horizontal-scaling)
      - [Replication controller](#replication-controller)
      - [Manifest file](#manifest-file)
      - [Horizontal pod autoscaler](#horizontal-pod-autoscaler)
- [References](#references)
  - [Online learning without installing anything](#online-learning-without-installing-anything)

# Kubernetes 
- container management tool/container orchestration engine
- a tool tomanage containers like docker which contains actual apps

## What it can do
- deploying
- scheduling
- scaling
- load balancing
- batch execution
- rollbacks
- monitoring

## Terminologies
  - -------------------------------------
    | parent        | child             |
    ----------------|--------------------
    | 1 master node | >= 1 worker Node  |
    | 1 worker node | >= 1 pods         |
    | 1 pod         | ~  1 container    |
    | 1 container   | ~  1 app          |
    | K8s ckuster   | set of any nodes  |
    -------------------------------------

## Architecture
- when you deploy k8s you get a cluster
- a cluster contains a master node & >=1 worker nodes (like server-client)
- there can be multiple masters, multiple clusters for availability & failover
- a node can be physical machine, vm or vm on cloud

## Kubernetes elements
- first read all elements, then come back and read their components

### Master node
- responsible for managing cluster
- monitor nodes & pods
- when a node fails shift workload to other node

#### Components

##### API server
- for all network communications (json over HTTP API)
- for interacting with k8s by engineer
- provides cmd(kubectl) & dashboard UI
- dasboard and kubectl both uses provided API in background

##### Scheduler
- watches newly created pods
- selects node to run these pods
- obtains information from ETCD via API server
- get information from ETCD & config files
- basically reads config & schedules pods & nodes

##### Controller manager
- runs monitor & manages activities
1. kube controller manager
- monitor & inform master in case of failures
- further containes
  - node, replication, endpoints, service accounts & token controllers

2. cloud controller manager
- monitor & inform master in case of failures on infra provided by cloud providers
- further contains 
  - node, route, service & volume controller

##### ETCD
- open source distributed key-value data source from CoreOS
- only API server directly communicates with ETCD
- everyone else communicates with API server
- it can be part of master or can be configured externally

### Worker node
- can be physical machine or VM where containers are deployed
- every node in a k8s must run in a container runtime like docker
  
#### Components

##### Kubelet
- an agent on each node that communicates with components from master node
- makes ure that containers are running in pod
- the kubelet takes a set of podspecs that are provided through various mechanisms and ensures that the containers described in podspecs are running & healty
- in case of pod fails it tries restarts pod in same or other nodes
- can only manage containers created by k8s

##### Kube-proxy
- a network agent per node responsible for maintaining network config. and rules
- exposes services to outside world
- talks to API server for addition/removal of services/endpoints
- runs as a daemon

##### Container runtime
- a software responsible for running containers
- supports several runtimes like following through Kubernetes(container runtime interface)
  - docker
  - containerd
  - Cri-o
  - rktlet

### Addons
- to extend functionality of k8s
- could provide usefulness for dashborad, monitoring, logging, DNS

## Features

### Automatic bin packing
- given certain ram & cpu
- it can autmatically distribute apps as per requiremnet vs available resouces in such a way that all apps get optimum resources
- this could be improved by specifying the resouce requirement of containers

### Service discovery & load balancing
- a service is usually deployed to **more than 1 pods**(thus more than 1 containers) with same set of resources
  - this provide scalability + uptime guarantee
- a DNS name for accessing a service (service, not pod)
  - as each service is deployed to more than 1 pod & only 1 DNS is exposed, it is k8s job to provide load balancing/distribution

### Storage orchestration
- container(s) inside pod which in turn use this single volume
- usually a single volume(storage) which could be
  - local
  - cloud
  - network file storage
- a unique IP for networking interactions
- usually it becomes 
  - N pods - N container(1 in 1) - 1 volume OR 1 pod - N container(N in 1) - 1 volume 

### Self healing - by replication controller
- if container failes - it restarts container
- if a node dies - replace & reschedule containers of that node
- if does not respond to health check - kill container & takes care of availability
- 

### Automated rollouts & rollbacks
- rollout 🚀 - changes to application or its configuration
- rollback 🔄 - revert changes & restore to previous state
- provides complete uptime while above happens

### Secret & config. management
- secret - an object in k8s to keep sensitive data seperate from pod & container to provide portability
- config map - an object in k8s to keep configuration data seperate from pod & container to provide portability
- helps in deploying & updating secrets & configs without rebuilding apps
- secret & config map are stores in ETCD key value DB
- max size for secrets is 1 MB

### Batch execution
- k8s provides **run to completion** for batch processing
- can use containers & pods as required for scalability
- container/pod failures are taken care by job controller
- on completion pods move from running to shutdown state
- useful for long running jobs

### Horizontal scaling
- scale up - add replicas
- scale down - reduce replicas
- scaling can be managed by
  - commands
  - dashborad
  - resource usage (like auto scale)

#### Replication controller
- creates multiple pods
- makes sure the availability of minimum number of pods by reading manifest file

#### Manifest file
- contains properties
- one such property is **replicas** used by replication controller

#### Horizontal pod autoscaler
- observes resource utilization
- can instruct replication controller to scale according to resource utilization or metrics
- for e.g., check CPU every 15 seconds

# References
- [Kubernetes Beginner Tutorials](https://www.youtube.com/playlist?list=PLhW3qG5bs-L8EU_Oocu6RkNPpYpaamtXX)

## Online learning without installing anything
- [Play with Kubernetes Classroom](https://training.play-with-kubernetes.com/)
- [Interactive Browser Based Labs, Courses & Playgrounds](https://www.katacoda.com/learn)
- [Play with Kubernetes](https://labs.play-with-k8s.com/)